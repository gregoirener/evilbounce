---
tags: [modules, misc]
---

# Modules: Misc

## Status: ALL KEPT

| Module | Feature | Path |
|--------|---------|------|
| ModuleAntiBot | Filter bot entities | `misc/antibot/` |
| ModuleBetterChat | Anti-spam, chat improvements | `misc/betterchat/` |
| ModuleDebugRecorder | Record debug data (aim, CPS, etc.) | `misc/debugrecorder/` |
| ModuleNameProtect | Hide your name client-side | `misc/nameprotect/` |
| ModuleReportHelper | Auto-report system | `misc/reporthelper/` |
| ModuleAntiCheatDetect | Detect what AC is running | `misc/ModuleAntiCheatDetect.kt` |
| ModuleAntiStaff | Detect staff members | `misc/ModuleAntiStaff.kt` |
| ModuleAutoAccount | Auto-login to alts | `misc/ModuleAutoAccount.kt` |
| ModuleAutoChatGame | Auto-play chat games | `misc/ModuleAutoChatGame.kt` |
| ModuleAutoConfig | Download/apply remote configs | `misc/ModuleAutoConfig.kt` ⚠️ |
| ModuleAutoPearl | Auto-throw ender pearl | `misc/ModuleAutoPearl.kt` |
| ModuleBetterTab | Better tab list display | `misc/ModuleBetterTab.kt` |
| ModuleBookBot | Auto-write books | `misc/ModuleBookBot.kt` |
| ModuleEasyPearl | Easier pearl throws | `misc/ModuleEasyPearl.kt` |
| ModuleElytraSwap | Auto-swap elytra with chestplate | `misc/ModuleElytraSwap.kt` |
| ModuleFlagCheck | Check for anticheat flags | `misc/ModuleFlagCheck.kt` |
| ModuleGUICloser | Auto-close GUIs | `misc/ModuleGUICloser.kt` |
| ModuleInventoryTracker | Track inventory changes | `misc/ModuleInventoryTracker.kt` |
| ModuleItemScroller | Scroll through item stacks | `misc/ModuleItemScroller.kt` |
| ModuleMacros | Key-bind macros | `misc/ModuleMacros.kt` |
| ModuleMiddleClickAction | Middle-click actions | `misc/ModuleMiddleClickAction.kt` |
| ModuleNotifier | Custom notifications | `misc/ModuleNotifier.kt` |
| ModulePacketLogger | Log network packets | `misc/ModulePacketLogger.kt` |
| ModuleSpammer | Auto-spam chat | `misc/ModuleSpammer.kt` |
| ModuleTargetLock | Lock onto a specific target | `misc/ModuleTargetLock.kt` |
| ModuleTeams | Team detection | `misc/ModuleTeams.kt` |
| ModuleTextFieldProtect | Protect text field input | `misc/ModuleTextFieldProtect.kt` |
| ModuleBetterTitle | Better title display | `misc/ModuleBetterTitle.kt` |

## ⚠️ ModuleAutoConfig Note

`ModuleAutoConfig` fetches config presets from the Marketplace. Once Marketplace is removed, this module's remote config fetching will break. Options:
1. Remove the module entirely (it's misc, not combat-critical)
2. Gut it to only support local config files

See [[Systems-Config]] and [[Deletions]] for context.

## Relations

- [[Systems-CEF]] — some misc modules expose data to the UI
- [[Deletions]] — ModuleAutoConfig may need attention after Marketplace removal
