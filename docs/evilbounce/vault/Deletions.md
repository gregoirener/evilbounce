---
tags: [deletions, tracker]
---

# Deletion Tracker

> Update this file as you complete each removal. Check off the item and add the date.

---

## Online Services

- [x] `features/marketplace/` — MarketplaceManager, SubscribedItem — 2026-05-17
- [x] `api/models/marketplace/` — all data classes — 2026-05-17
- [x] `api/services/marketplace/MarketplaceApi.kt` — 2026-05-17
- [x] `command/commands/client/marketplace/` — all marketplace commands — 2026-05-17
- [x] `integration/.../rest/v1/client/MarketplaceFunctions.kt` — 2026-05-17
- [x] `features/cosmetic/` — CosmeticService, CapeCosmeticsManager, ClientAccountManager — 2026-05-17
- [x] `api/services/cosmetics/` + `api/models/cosmetics/` — 2026-05-17
- [x] CCBlueX OAuth account — `api/services/auth/`, `api/models/auth/`, `api/services/user/`, `api/models/user/`, `UserFunctions.kt` — 2026-05-17
- [ ] ~~`features/account/` — AccountManager~~ **KEPT** — this is the Minecraft alt-account manager (Microsoft/cracked/Altening login), NOT a CCBlueX online service. Docs mislabeled it.
- [ ] ~~`AccountFunctions.kt`~~ **KEPT** — alt-account REST, depends only on `api/core`. Stays with AccountManager.

**Cleanup completed in:**
- [x] `LiquidBounce.kt` — removed marketplace/cosmetics/ClientAccountManager init + imports
- [x] `InteropFunctionRegistry.kt` — removed Marketplace + User route registrations
- [x] `CommandManager.kt` — removed CommandMarketplace registration
- [x] `ScriptManager.kt` / `ThemeManager.kt` / `Theme.kt` — removed marketplace script/theme loading + `MARKETPLACE` origin
- [x] `CommandClient.kt` — removed account + cosmetics subcommands
- [x] `ClientInteropServer.kt` — removed marketplace static file route
- [x] `ClientEvents.kt` / `EventManager.kt` — removed `UserLoggedIn/OutEvent`
- [x] 3 Java mixins (`MixinPlayerInfo`, `MixinLivingEntityRenderer`, `MixinDeadmau5EarsLayer`) — stripped cosmetic code, mixins kept
- [x] 63 `command.marketplace.*` lang keys removed (en_us, zh_cn)
- ModuleAutoConfig: no marketplace dependency found — dependencies.md was outdated, no action needed.

---

## Server-Breaking Exploits

- [x] `exploit/servercrasher/` (entire folder) — 2026-05-12
- [x] `exploit/dupe/` (entire folder) — 2026-05-12
- [ ] ~~`exploit/ModuleKick.kt`~~ **KEPT** — turns out it self-disconnects (not griefing) and `ModuleAutoLeave` depends on it

---

## Teleport Cheats

- [x] `exploit/phase/` (entire folder) — 2026-05-12
- [x] `exploit/ModuleClickTp.kt` — 2026-05-12
- [x] `combat/tpaura/` (entire folder) — 2026-05-12 (verified `ModuleAutoLeave.kt` unaffected — no TpAura dependency)

---

## Completed Deletions

**2026-05-12 — Batch 1 (isolated modules):**
- ModuleServerCrasher (+ all 11 exploit types)
- ModuleDupe (+ DupeExploit, DupePaper1204)
- ModulePhase (+ 4 mode files)
- ModuleClickTp
- ModuleTpAura (+ AStarMode, ImmediateMode)
- Stripped 5 imports + 5 registrations from `ModuleManager.kt`
- Stripped 149 dead lang keys across 10 locale JSONs
- `./gradlew compileKotlin` → BUILD SUCCESSFUL

**Note:** `ModuleKick` retained — it is a self-kick utility used by `ModuleAutoLeave`, not a griefing tool. Docs were inaccurate.

**2026-05-17 — Batch 2 (online services):**
- Marketplace stack (features/marketplace, api marketplace models+service, 13 commands, MarketplaceFunctions REST)
- Cosmetics stack (features/cosmetic: CosmeticService/CapeCosmeticsManager/ClientAccountManager, api cosmetics models+services)
- CCBlueX OAuth account (api auth+user models/services, UserFunctions REST, account+cosmetics client subcommands)
- Cascade cleanup across LiquidBounce.kt, InteropFunctionRegistry, CommandManager, ScriptManager, ThemeManager, Theme, CommandClient, ClientInteropServer, ClientEvents, EventManager
- 3 cosmetic render mixins stripped (kept as files per decision)
- 63 marketplace lang keys removed
- `./gradlew compileKotlin compileJava` → BUILD SUCCESSFUL

**Note:** `features/account/AccountManager` retained — it is the Minecraft alt-account manager (Microsoft/cracked/Altening), independent of CCBlueX auth API. Docs mislabeled it as an online service. `AccountFunctions.kt` kept with it.

**Dead GUI (not yet addressed):** `src-theme/` still contains marketplace + CCBlueX-login pages. They will 404 against the removed REST endpoints but won't crash the client. To be cleaned during the GUI redesign pass.

---

## Key Reminder

After **every single deletion**, run:
```
./gradlew compileKotlin
```
to confirm the build is not broken before moving to the next deletion.

## Relations

- [[Modules-Exploit]] — shows what's kept vs removed in exploit category
- [[Modules-Combat]] — TpAura removed from here
- [[Modules-Movement]] — Phase and ClickTp removed from here
- [[Systems-CEF]] — Marketplace/Account UI cleanup needed
