# EvilBounce — Module Keep / Nuke List

> Cross-reference with [`dependencies.md`](dependencies.md) before acting on any deletion.

---

## NUKE — Full Removal Required

### Server-Breaking Exploits
| Module | Path | Notes |
|--------|------|-------|
| ModuleServerCrasher | `exploit/servercrasher/` (whole folder) | Log4j, paper crashes, grim spam, etc. |
| ModuleDupe | `exploit/dupe/` (whole folder) | Item duplication |
| ModuleKick | `exploit/ModuleKick.kt` | Kicks other players |

### Teleport Cheats
| Module | Path | Notes |
|--------|------|-------|
| ModulePhase | `exploit/phase/` (whole folder) | Wall clipping |
| ModuleClickTp | `exploit/ModuleClickTp.kt` | Click-to-teleport |
| ModuleTpAura | `combat/tpaura/` (whole folder) | Teleport + attack |

### Online Services (not modules, but must be removed)
| System | Path | Notes |
|--------|------|-------|
| MarketplaceManager | `features/marketplace/` | Full folder |
| Marketplace API | `api/models/marketplace/` + `api/services/marketplace/` | Full folders |
| Marketplace Commands | `command/commands/client/marketplace/` | Full folder |
| MarketplaceFunctions | `integration/.../rest/v1/client/MarketplaceFunctions.kt` | REST endpoint |
| CosmeticService | `api/services/cosmetics/` | Full folder |
| Cosmetics models | `api/models/cosmetics/` | Full folder |
| Account manager | `features/account/` | Full folder |
| AccountFunctions | `integration/.../rest/v1/client/AccountFunctions.kt` | REST endpoint |
| OAuth / Auth | `api/core/auth/` | OAuthClient, OAuthSession, NettyAuthHandler |

---

## KEEP — Do Not Touch

### Combat
| Module | Path |
|--------|------|
| ModuleKillAura | `combat/killaura/` |
| ModuleReach | `player/ModuleReach.kt` |
| ModuleVelocity | `combat/velocity/` |
| ModuleCriticals | `combat/criticals/` |
| ModuleCrystalAura | `combat/crystalaura/` |
| ModuleAimbot | `combat/ModuleAimbot.kt` |
| ModuleAutoBow | `combat/aimbot/ModuleAutoBow.kt` |
| ModuleProjectileAimbot | `combat/aimbot/ModuleProjectileAimbot.kt` |
| ModuleDroneControl | `combat/aimbot/ModuleDroneControl.kt` |
| ModuleAutoClicker | `combat/ModuleAutoClicker.kt` |
| ModuleBacktrack | `combat/backtrack/ModuleBacktrack.kt` |
| ModuleHitbox | `combat/ModuleHitbox.kt` |
| ModuleSuperKnockback | `combat/ModuleSuperKnockback.kt` |
| ModuleFakeLag | `combat/ModuleFakeLag.kt` |
| ModuleTickBase | `combat/ModuleTickBase.kt` |
| ModuleTimerRange | `combat/ModuleTimerRange.kt` |
| ModuleElytraTarget | `combat/elytratarget/` |
| ModuleMaceKill | `combat/ModuleMaceKill.kt` |
| ModuleAutoArmor | `combat/autoarmor/` |
| ModuleAutoRod | `combat/ModuleAutoRod.kt` |
| ModuleAutoWeapon | `combat/ModuleAutoWeapon.kt` |
| ModuleKeepSprint | `combat/ModuleKeepSprint.kt` |
| ModuleNoMissCooldown | `combat/ModuleNoMissCooldown.kt` |
| ModuleSwordBlock | `combat/ModuleSwordBlock.kt` |
| ModuleAutoShoot | `combat/ModuleAutoShoot.kt` |
| ModuleAutoLeave | `combat/ModuleAutoLeave.kt` |

### World / Utility
| Module | Path |
|--------|------|
| ModuleScaffold | `world/scaffold/` |
| ModuleBedDefender | `world/ModuleBedDefender.kt` |
| ModulePacketMine | `world/packetmine/` |
| ModuleNuker | `world/nuker/` |
| ModuleFastBreak | `world/ModuleFastBreak.kt` |
| ModuleFastPlace | `world/ModuleFastPlace.kt` |
| ModuleSurround | `world/ModuleSurround.kt` |
| ModuleHoleFiller | `world/ModuleHoleFiller.kt` |
| ModuleAutoTrap | `world/traps/` |
| ModuleTimer | `world/ModuleTimer.kt` |
| ModuleAutoBuild | `world/autobuild/` |
| ModuleAutoFarm | `world/autofarm/` |
| ModuleFucker | `world/fucker/ModuleFucker.kt` |
| ModuleAirPlace | `world/ModuleAirPlace.kt` |
| ModuleAutoTool | `world/ModuleAutoTool.kt` |
| ModuleBlockTrap | `world/ModuleBlockTrap.kt` |
| ModuleExtinguish | `world/ModuleExtinguish.kt` |
| ModuleLiquidPlace | `world/ModuleLiquidPlace.kt` |

### Movement
| Module | Path |
|--------|------|
| ModuleFly | `movement/fly/` |
| ModuleSpeed | `movement/speed/` |
| ModuleStep | `movement/step/` |
| ModuleNoSlow | `movement/noslow/` |
| ModuleSpider | `movement/spider/` |
| ModuleLiquidWalk | `movement/liquidwalk/` |
| ModuleBlink (player) | `player/ModuleBlink.kt` |
| ModuleHighJump | `movement/highjump/` |
| ModuleLongJump | `movement/longjump/` |
| ModuleElytraFly | `movement/elytrafly/` |
| ModuleInventoryMove | `movement/inventorymove/` |
| ModuleNoSlow | `movement/noslow/` |
| ModuleNoWeb | `movement/noweb/` |
| ModuleTerrainSpeed | `movement/terrainspeed/` |
| ModuleAutoDodge | `movement/autododge/` |
| ModuleAvoidHazards | `movement/avoidhazards/` |
| ModuleSprint | `movement/ModuleSprint.kt` |
| ModuleStrafe | `movement/ModuleStrafe.kt` |
| ModuleSneak | `movement/ModuleSneak.kt` |
| ModuleSafeWalk | `movement/ModuleSafeWalk.kt` |
| ModuleStep | `movement/step/` |
| ModuleAnchor | `movement/ModuleAnchor.kt` |
| ModuleAirJump | `movement/ModuleAirJump.kt` |

### Exploit (kept)
| Module | Path |
|--------|------|
| ModuleDisabler | `exploit/disabler/` (all modes) |
| ModuleResetVL | `exploit/ModuleResetVL.kt` |
| ModuleYggdrasilSignatureFix | `exploit/ModuleYggdrasilSignatureFix.kt` |
| ModuleSleepWalker | `exploit/ModuleSleepWalker.kt` |
| ModuleAntiHunger | `exploit/ModuleAntiHunger.kt` |
| ModuleGhostHand | `exploit/ModuleGhostHand.kt` |
| ModuleMultiActions | `exploit/ModuleMultiActions.kt` |
| ModuleMoreCarry | `exploit/ModuleMoreCarry.kt` |
| ModuleNoPitchLimit | `exploit/ModuleNoPitchLimit.kt` |
| ModulePingSpoof | `exploit/ModulePingSpoof.kt` |
| ModulePlugins | `exploit/ModulePlugins.kt` |
| ModuleNameCollector | `exploit/ModuleNameCollector.kt` |
| ModuleAbortBreaking | `exploit/ModuleAbortBreaking.kt` |
| ModuleAntiReducedDebugInfo | `exploit/ModuleAntiReducedDebugInfo.kt` |
| ModuleClip | `exploit/ModuleClip.kt` |
| ModuleDamage | `exploit/ModuleDamage.kt` |
| ModuleExtendedFirework | `exploit/ModuleExtendedFirework.kt` |
| ModulePortalMenu | `exploit/ModulePortalMenu.kt` |
| ModuleTimeShift | `exploit/ModuleTimeShift.kt` |
| ModuleVehicleOneHit | `exploit/ModuleVehicleOneHit.kt` |

### Player
| Module | Path |
|--------|------|
| ModuleNoFall | `player/nofall/` |
| ModuleOffhand | `player/offhand/` |
| ModuleReach | `player/ModuleReach.kt` |
| ModuleChestStealer | `player/cheststealer/` |
| ModuleInventoryCleaner | `player/invcleaner/` |
| ModuleAutoBuff | `player/autobuff/` |
| ModuleAutoQueue | `player/autoqueue/` |
| ModuleAutoShop | `player/autoshop/` |
| ModuleAntiVoid | `player/antivoid/` |
| ModuleFastUse | `player/ModuleFastUse.kt` |
| ModuleSmartEat | `player/ModuleSmartEat.kt` |

### Misc (all kept)
All modules in `features/module/modules/misc/` are kept.

### Render (all kept)
All modules in `features/module/modules/render/` are kept.
