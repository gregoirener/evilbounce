---
tags: [modules, combat, sacred]
---

# Modules: Combat

## Status: ALL KEPT — Sacred, Do Not Remove

These are the core reason EvilBounce exists.

## Module List

| Module | Key Feature | Path |
|--------|------------|------|
| ModuleKillAura | Auto-attack with range, autoblock, fightbot | `combat/killaura/` |
| ModuleReach | Extended attack reach | `player/ModuleReach.kt` |
| ModuleVelocity | Reduce/cancel knockback | `combat/velocity/` |
| ModuleCriticals | Force critical hits | `combat/criticals/` |
| ModuleCrystalAura | Auto place/break end crystals | `combat/crystalaura/` |
| ModuleAimbot | ML-assisted aimbot | `combat/ModuleAimbot.kt` |
| ModuleAutoBow | Auto-shoot bow at optimal charge | `combat/aimbot/ModuleAutoBow.kt` |
| ModuleProjectileAimbot | Aim prediction for projectiles | `combat/aimbot/ModuleProjectileAimbot.kt` |
| ModuleAutoClicker | Auto left/right click | `combat/ModuleAutoClicker.kt` |
| ModuleBacktrack | Delay entity position updates | `combat/backtrack/` |
| ModuleHitbox | Expand entity hitboxes | `combat/ModuleHitbox.kt` |
| ModuleSuperKnockback | Increase knockback dealt | `combat/ModuleSuperKnockback.kt` |
| ModuleFakeLag | Delay packets (position desync) | `combat/ModuleFakeLag.kt` |
| ModuleTickBase | Manipulate tick rate | `combat/ModuleTickBase.kt` |
| ModuleTimerRange | Timer-based attack range | `combat/ModuleTimerRange.kt` |
| ModuleElytraTarget | Target tracking while on elytra | `combat/elytratarget/` |
| ModuleMaceKill | Mace kill optimization | `combat/ModuleMaceKill.kt` |
| ModuleAutoArmor | Auto-equip best armor | `combat/autoarmor/` |
| ModuleAutoRod | Auto fish rod during combat | `combat/ModuleAutoRod.kt` |
| ModuleAutoWeapon | Auto-switch to best weapon | `combat/ModuleAutoWeapon.kt` |
| ModuleKeepSprint | Maintain sprint during combat | `combat/ModuleKeepSprint.kt` |
| ModuleNoMissCooldown | Remove miss attack cooldown | `combat/ModuleNoMissCooldown.kt` |
| ModuleSwordBlock | Re-enable sword blocking | `combat/ModuleSwordBlock.kt` |
| ModuleAutoShoot | Auto-shoot crossbow/bow | `combat/ModuleAutoShoot.kt` |
| ModuleAutoLeave | Auto-leave on low HP | `combat/ModuleAutoLeave.kt` |

## REMOVED From Combat

| Module | Reason |
|--------|--------|
| ModuleTpAura | Teleport cheat — see [[Deletions]] |

## Key Architecture Notes

- KillAura uses `KillAuraTargetTracker` + `KillAuraClicker` + `KillAuraRotationsValueGroup` — all in `combat/killaura/`
- CrystalAura is the most complex module (~20 files across place/destroy/trigger/post subfolders)
- Velocity has 14+ server-specific modes in `combat/velocity/mode/`
- KillAura range is in `combat/killaura/features/KillAuraRange.kt` — this is the "Reach for KillAura" feature

## Relations

- [[Systems-Events]] — all modules are event-driven
- [[Systems-DeepLearn]] — Aimbot uses ML
- [[GodNodes]] — Vec3 used in all combat math
- [[Modules-Movement]] — combat often depends on movement state
