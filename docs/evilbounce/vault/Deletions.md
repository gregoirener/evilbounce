---
tags: [deletions, tracker]
---

# Deletion Tracker

> Update this file as you complete each removal. Check off the item and add the date.

---

## Online Services

- [ ] `features/marketplace/` — MarketplaceManager, SubscribedItem
- [ ] `api/models/marketplace/` — all data classes
- [ ] `api/services/marketplace/MarketplaceApi.kt`
- [ ] `command/commands/client/marketplace/` — all marketplace commands
- [ ] `integration/.../rest/v1/client/MarketplaceFunctions.kt`
- [ ] `api/services/cosmetics/` + `api/models/cosmetics/`
- [ ] `features/account/` — AccountManager
- [ ] `integration/.../rest/v1/client/AccountFunctions.kt`
- [ ] `api/core/auth/` — OAuthClient, OAuthSession, NettyAuthHandler

**After the above — cleanup in:**
- [ ] `LiquidBounce.kt` — remove 3 marketplace/cosmetics references (lines ~284, ~329, ~411)
- [ ] `InteropFunctionRegistry.kt` — remove Marketplace + Account registrations
- [ ] `CommandManager.kt` — remove CommandMarketplace registration
- [ ] `ModuleAutoConfig.kt` — audit / gut marketplace dependency

---

## Server-Breaking Exploits

- [ ] `exploit/servercrasher/` (entire folder)
  - After: remove import + registration from `ModuleManager.kt`
- [ ] `exploit/dupe/` (entire folder)
  - After: remove import + registration from `ModuleManager.kt`
- [ ] `exploit/ModuleKick.kt`
  - After: remove import + registration from `ModuleManager.kt`

---

## Teleport Cheats

- [ ] `exploit/phase/` (entire folder)
  - After: remove import + registration from `ModuleManager.kt`
- [ ] `exploit/ModuleClickTp.kt`
  - After: remove import + registration from `ModuleManager.kt`
- [ ] `combat/tpaura/` (entire folder)
  - After: remove import + registration from `ModuleManager.kt`
  - After: verify `ModuleAutoLeave.kt` still compiles

---

## Completed Deletions

*(Move items here once done, with date)*

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
