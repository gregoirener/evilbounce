/*
 * This file is part of LiquidBounce (https://github.com/CCBlueX/LiquidBounce)
 *
 * Copyright (c) 2015 - 2026 CCBlueX
 *
 * LiquidBounce is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LiquidBounce is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LiquidBounce. If not, see <https://www.gnu.org/licenses/>.
 */
package net.ccbluex.liquidbounce.features.module.modules.render.hitfx

import net.ccbluex.liquidbounce.config.types.list.Tagged
import net.ccbluex.liquidbounce.event.events.AttackEntityEvent
import net.ccbluex.liquidbounce.event.events.PacketEvent
import net.ccbluex.liquidbounce.event.events.WorldRenderEvent
import net.ccbluex.liquidbounce.event.handler
import net.ccbluex.liquidbounce.features.module.ClientModule
import net.ccbluex.liquidbounce.features.module.ModuleCategories
import net.ccbluex.liquidbounce.features.module.modules.combat.killaura.ModuleKillAura
import net.ccbluex.liquidbounce.render.drawCircleOutline
import net.ccbluex.liquidbounce.render.engine.type.Color4b
import net.ccbluex.liquidbounce.render.renderEnvironmentForWorld
import net.ccbluex.liquidbounce.render.withPositionRelativeToCamera
import net.ccbluex.liquidbounce.utils.entity.interpolateCurrentPosition
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.network.protocol.game.ClientboundSoundPacket
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.block.Blocks
import kotlin.math.sin

object ModuleHitFX : ClientModule("HitFX", ModuleCategories.RENDER) {

    init {
        HitFXRegistry.registerAll()
    }

    // -------------------------------------------------------------------------
    // Hit particles (existing system)
    // -------------------------------------------------------------------------

    enum class Particle(override val tag: String) : Tagged {
        BLOOD("Blood"),
        FIRE("Fire"),
        HEART("Heart"),
        WATER("Water"),
        SMOKE("Smoke"),
        MAGIC("Magic"),
        CRITS("Crits"),
    }

    private val particles by multiEnumChoice("Particle", Particle.FIRE)
    private val particleAmount by intRange("ParticleAmount", 1..1, 1..20)

    private val otherSoundSet by multiEnumChoice("OtherSound", HitFXRegistry.POP)

    private val otherSound
        get() = otherSoundSet.randomOrNull()?.sounds?.randomOrNull()

    val selfSound
        get() = selfSoundSet.randomOrNull()?.sounds?.randomOrNull()

    private val selfSoundSet by multiEnumChoice("SelfSound", HitFXRegistry.BOYKISSER)

    private var lastTargetId: Int? = null

    private val vanillaHitSounds = setOf(
        SoundEvents.ARROW_HIT_PLAYER,
        SoundEvents.PLAYER_ATTACK_NODAMAGE,
        SoundEvents.PLAYER_ATTACK_KNOCKBACK,
        SoundEvents.PLAYER_ATTACK_CRIT,
        SoundEvents.PLAYER_ATTACK_STRONG,
        SoundEvents.PLAYER_ATTACK_SWEEP,
        SoundEvents.PLAYER_ATTACK_WEAK,
        SoundEvents.SPEAR_HIT,
        SoundEvents.PLAYER_HURT,
    )

    @Suppress("unused")
    private val effectHandler = handler<PacketEvent> { event ->
        val packet = event.packet

        if (packet !is ClientboundSoundPacket) {
            return@handler
        }

        val source = packet.source
        val sound = packet.sound.value()

        // Cannot be from any living entity.
        if (source != SoundSource.PLAYERS && source != SoundSource.NEUTRAL && source != SoundSource.HOSTILE) {
            return@handler
        }

        if (sound !in vanillaHitSounds) {
            return@handler
        }

        val lastTarget = lastTargetId?.let { world.getEntity(it) as? LivingEntity } ?: return@handler
        if (!lastTarget.isAlive) {
            return@handler
        }

        val distanceToSq = lastTarget.distanceToSqr(packet.x, packet.y, packet.z)
        if (distanceToSq > 8.0) {
            return@handler
        }

        playEffect(lastTarget)
        otherSound?.let { sound ->
            mc.execute {
                world.playSeededSound(
                    player,
                    packet.x,
                    packet.y,
                    packet.z,
                    sound,
                    packet.source,
                    packet.volume,
                    packet.pitch,
                    packet.seed
                )
            }
            event.cancelEvent()
        }
        this.lastTargetId = null
    }

    @Suppress("unused")
    private val attackHandler = handler<AttackEntityEvent> { event ->
        val target = event.entity

        if (target is LivingEntity) {
            if (!target.isAlive) {
                return@handler
            }

            this.lastTargetId = target.id
        }
    }

    private fun playEffect(target: LivingEntity) = mc.execute {
        val particles = particles.ifEmpty { return@execute }
        repeat(particleAmount.random()) {
            when (particles.random()) {
                Particle.BLOOD -> world.addDestroyBlockEffect(
                    target.blockPosition().above(1),
                    Blocks.REDSTONE_BLOCK.defaultBlockState()
                )

                Particle.FIRE -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.LAVA)
                Particle.HEART -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.HEART)
                Particle.WATER -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.FALLING_WATER)
                Particle.SMOKE -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.SMOKE)
                Particle.MAGIC -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.ENCHANTED_HIT)
                Particle.CRITS -> mc.particleEngine.createTrackingEmitter(target, ParticleTypes.CRIT)
            }
        }
    }

    // -------------------------------------------------------------------------
    // EvilBounce FEEL — red aura rings on the KillAura target.
    // Three cheap drawCircleOutline calls per frame — no mesh, no loops.
    // -------------------------------------------------------------------------

    private val feelEnabled by boolean("FeelAura", true)
    private val feelColor by color("FeelColor", Color4b(212, 23, 23, 210))
    private val feelSpeed by float("FeelSpeed", 1.0f, 0.1f..3.0f)
    private val feelRadius by float("FeelRadius", 1.0f, 0.4f..2.5f)

    // Monotonic tick counter — incremented each render frame, cheap int add.
    private var feelTick = 0.0

    @Suppress("unused")
    private val feelRenderHandler = handler<WorldRenderEvent> { event ->
        if (!feelEnabled) return@handler
        val target = ModuleKillAura.targetTracker.target ?: return@handler
        if (!target.isAlive) return@handler

        feelTick += event.partialTicks * feelSpeed * 0.04f

        val t = feelTick.toDouble()
        val basePos = target.interpolateCurrentPosition(event.partialTicks)

        // Three pulse phases staggered so rings breathe independently
        val p0 = (0.85f + 0.15f * sin(t * 2.0).toFloat())
        val p1 = (0.88f + 0.12f * sin(t * 2.0 + 1.0).toFloat())
        val p2 = (0.90f + 0.10f * sin(t * 2.0 + 2.0).toFloat())

        val r = feelRadius

        renderEnvironmentForWorld(event.matrixStack) {
            // Ring 1 — feet level, widest, most visible
            withPositionRelativeToCamera(basePos) {
                drawCircleOutline(r * p0, feelColor.with(a = 220))
            }
            // Ring 2 — mid-body
            withPositionRelativeToCamera(basePos.add(0.0, target.bbHeight * 0.5, 0.0)) {
                drawCircleOutline(r * 0.75f * p1, feelColor.with(a = 160))
            }
            // Ring 3 — above head, smallest, faintest
            withPositionRelativeToCamera(basePos.add(0.0, target.bbHeight + 0.1, 0.0)) {
                drawCircleOutline(r * 0.45f * p2, feelColor.with(a = 100))
            }
        }
    }
}
