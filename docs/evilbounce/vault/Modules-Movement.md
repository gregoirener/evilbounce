---
tags: [modules, movement]
---

# Modules: Movement

## Status: ALL KEPT

## Module List

| Module | Feature | Path |
|--------|---------|------|
| ModuleFly | Fly in various modes | `movement/fly/` |
| ModuleSpeed | Move faster | `movement/speed/` |
| ModuleStep | Step up blocks instantly | `movement/step/` |
| ModuleNoSlow | Cancel slowdown effects | `movement/noslow/` |
| ModuleSpider | Climb walls | `movement/spider/` |
| ModuleLiquidWalk | Walk on water/lava | `movement/liquidwalk/` |
| ModuleBlink (player) | Freeze position / teleport | `player/ModuleBlink.kt` |
| ModuleHighJump | Jump much higher | `movement/highjump/` |
| ModuleLongJump | Jump much farther | `movement/longjump/` |
| ModuleElytraFly | Elytra flight hacks | `movement/elytrafly/` |
| ModuleInventoryMove | Move while in inventory | `movement/inventorymove/` |
| ModuleNoWeb | Cancel cobweb slowdown | `movement/noweb/` |
| ModuleTerrainSpeed | Speed on specific terrain | `movement/terrainspeed/` |
| ModuleAutoDodge | Auto-dodge projectiles | `movement/autododge/` |
| ModuleAvoidHazards | Avoid fall/fire damage | `movement/avoidhazards/` |
| ModuleSprint | Force sprinting | `movement/ModuleSprint.kt` |
| ModuleStrafe | Strafe around targets | `movement/ModuleStrafe.kt` |
| ModuleSneak | Auto-sneak | `movement/ModuleSneak.kt` |
| ModuleSafeWalk | Don't fall off edges | `movement/ModuleSafeWalk.kt` |
| ModuleAnchor | Lock position | `movement/ModuleAnchor.kt` |
| ModuleAirJump | Jump in midair | `movement/ModuleAirJump.kt` |
| ModuleTargetStrafe | Strafe around combat target | `movement/ModuleTargetStrafe.kt` |
| ModuleNoClip | Clip through blocks (kept) | `movement/ModuleNoClip.kt` |
| ModuleFreeze | Freeze player in place | `movement/ModuleFreeze.kt` |

## REMOVED From Movement

| Module | Reason |
|--------|--------|
| ModulePhase | Wall clip exploit — see [[Deletions]] |
| ModuleClickTp | Teleport exploit — see [[Deletions]] |

## Relations

- [[Systems-Events]] — movement hooks `MovementInputEvent`, `TickEvent`
- [[Systems-Mixins]] — movement mixins patch player motion code
- [[Modules-Combat]] — combat targeting uses player position from movement state
