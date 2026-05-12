---
tags: [modules, world, sacred]
---

# Modules: World

## Status: ALL KEPT

## Module List

| Module | Key Feature | Path |
|--------|------------|------|
| ModuleScaffold | Auto-place blocks while bridging | `world/scaffold/` |
| ModuleBedDefender | Protect your bed in BedWars | `world/ModuleBedDefender.kt` |
| ModulePacketMine | Fast block breaking via packets | `world/packetmine/` |
| ModuleNuker | Break blocks in area/sphere | `world/nuker/` |
| ModuleFastBreak | Speed up block breaking | `world/ModuleFastBreak.kt` |
| ModuleFastPlace | Speed up block placing | `world/ModuleFastPlace.kt` |
| ModuleSurround | Surround yourself with obsidian | `world/ModuleSurround.kt` |
| ModuleHoleFiller | Fill holes/safe spots near targets | `world/ModuleHoleFiller.kt` |
| ModuleAutoTrap | Trap enemies with blocks | `world/traps/` |
| ModuleTimer | Manipulate game timer | `world/ModuleTimer.kt` |
| ModuleAutoBuild | Auto-build structures | `world/autobuild/` |
| ModuleAutoFarm | Auto harvest/replant crops | `world/autofarm/` |
| ModuleFucker | Break specific target blocks (beds, spawners) | `world/fucker/` |
| ModuleAirPlace | Place blocks in air | `world/ModuleAirPlace.kt` |
| ModuleAutoTool | Auto-switch to best tool | `world/ModuleAutoTool.kt` |
| ModuleBlockTrap | Trap player in blocks | `world/ModuleBlockTrap.kt` |
| ModuleExtinguish | Extinguish fire with water | `world/ModuleExtinguish.kt` |
| ModuleLiquidPlace | Place blocks underwater | `world/ModuleLiquidPlace.kt` |
| ModuleBedPlates | (render) Show BedWars bed status | `render/ModuleBedPlates.kt` |

## Scaffold Architecture

Scaffold is the most complex world module (~20 files):
- `ScaffoldMovementPlanner` — calculates where to place next block
- `ScaffoldBlockItemSelection` — picks the right block from inventory
- `techniques/` — Normal, GodBridge, Breezily, Expand, Telly
- `features/` — Acceleration, AutoBlock, Blink, Ceiling, HeadHitter, Eagle, etc.
- `tower/` — Hypixel, Karhu, Motion, Pulldown, Vulcan tower modes

## BedBreaker / PacketMine

`ModulePacketMine` is the "BedBreaker" equivalent — it breaks blocks using packet manipulation to exceed normal break speed. Modes: Civ, Immediate, Normal.

## Relations

- [[Systems-Events]] — world modules hook block/world events
- [[Systems-Mixins]] — block interaction mixins feed these modules
- [[Modules-Combat]] — BedDefender and Fucker are combat-support modules
