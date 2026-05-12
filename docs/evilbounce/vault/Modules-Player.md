---
tags: [modules, player]
---

# Modules: Player

## Status: ALL KEPT

| Module | Feature | Path |
|--------|---------|------|
| ModuleNoFall | Cancel fall damage | `player/nofall/` |
| ModuleOffhand | Auto-manage offhand slot | `player/offhand/` |
| ModuleReach | Extended interaction/attack reach | `player/ModuleReach.kt` |
| ModuleChestStealer | Auto-loot chests | `player/cheststealer/` |
| ModuleInventoryCleaner | Auto-sort/clean inventory | `player/invcleaner/` |
| ModuleAutoBuff | Auto-use potions/buffs | `player/autobuff/` |
| ModuleAutoQueue | Auto-rejoin queue | `player/autoqueue/` |
| ModuleAutoShop | Auto-buy from shop | `player/autoshop/` |
| ModuleAntiVoid | Prevent void death | `player/antivoid/` |
| ModuleFastUse | Use items faster | `player/ModuleFastUse.kt` |
| ModuleSmartEat | Eat at optimal HP | `player/ModuleSmartEat.kt` |
| ModuleAntiAFK | Prevent AFK kick | `player/ModuleAntiAFK.kt` |
| ModuleAutoBreak | Auto-break blocks | `player/ModuleAutoBreak.kt` |
| ModuleAutoFish | Auto-fish | `player/ModuleAutoFish.kt` |
| ModuleAutoRespawn | Auto-respawn on death | `player/ModuleAutoRespawn.kt` |
| ModuleAutoWalk | Walk automatically | `player/ModuleAutoWalk.kt` |
| ModuleAutoWindCharge | Auto-use wind charge | `player/ModuleAutoWindCharge.kt` |
| ModuleBlink (player) | Packet delay / position freeze | `player/ModuleBlink.kt` |
| ModuleEagle | Sneak on edge for bridging | `player/ModuleEagle.kt` |
| ModuleFastExp | Pick up XP faster | `player/ModuleFastExp.kt` |
| ModuleNoRotateSet | Prevent server-forced rotation | `player/ModuleNoRotateSet.kt` |
| ModulePotionSpoof | Fake potion effects to server | `player/ModulePotionSpoof.kt` |
| ModuleReplenish | Auto-replenish hotbar items | `player/ModuleReplenish.kt` |

## Relations

- [[Modules-Combat]] — Reach is critical for combat
- [[Systems-Events]] — player modules hook inventory and tick events
