# EvilBounce — Dependency Danger Zones

> **Check this file before deleting any module, service, or system.**
> These are the known cascade chains — deleting X also requires cleaning up Y.

---

## MarketplaceManager

**Depends on it:**
- `LiquidBounce.kt` — `ConfigSystem.root(MarketplaceManager)` at line ~284, cosmetics launch block ~329, marketplace update coroutine ~411
- `ModuleAutoConfig.kt` — uses marketplace to fetch remote configs; if MarketplaceManager is removed, ModuleAutoConfig must be gutted or removed too
- `InteropFunctionRegistry.kt` — registers `MarketplaceFunctions`; remove that registration
- `CommandManager.kt` — registers `CommandMarketplace`; remove that registration
- `ThemeManager.kt` — references marketplace for theme items; audit after removal
- `ModuleFunctions.kt` (REST) — may reference marketplace for config listing

**Action plan:**
1. Delete `features/marketplace/` folder
2. Delete `api/models/marketplace/` and `api/services/marketplace/`
3. Delete `command/commands/client/marketplace/` folder
4. Delete `integration/.../MarketplaceFunctions.kt`
5. In `LiquidBounce.kt`: remove the 3 marketplace references
6. In `InteropFunctionRegistry.kt`: remove MarketplaceFunctions registration
7. In `CommandManager.kt`: remove CommandMarketplace registration
8. Audit `ModuleAutoConfig.kt` — it downloads configs from the marketplace; decide if it should be removed or repurposed for local configs only

---

## CosmeticService

**Depends on it:**
- `LiquidBounce.kt` — `CosmeticService.refreshCarriers()` in the init coroutine
- Various render modules may check cosmetics for skin/cape rendering

**Action plan:**
1. Delete `api/services/cosmetics/` and `api/models/cosmetics/`
2. In `LiquidBounce.kt`: remove the cosmetics launch block
3. Search for `CosmeticService` across `src/` and remove all references

---

## Account Manager (features/account/)

**Depends on it:**
- `AccountFunctions.kt` (REST) — exposes account list to the CEF UI
- `InteropFunctionRegistry.kt` — registers AccountFunctions
- The CEF UI has an account management screen

**Action plan:**
1. Delete `features/account/` folder
2. Delete `integration/.../AccountFunctions.kt`
3. Remove AccountFunctions from `InteropFunctionRegistry.kt`
4. Remove the account screen from `src-theme/` (or leave as dead UI — low risk)

---

## ModuleServerCrasher

**Depends on it:**
- `ModuleManager.kt` — has import + registration; remove both
- Nothing else depends on it — self-contained

**Action plan:**
1. Delete `exploit/servercrasher/` folder
2. In `ModuleManager.kt`: remove `import ModuleServerCrasher` and remove from modules list

---

## ModuleDupe

**Depends on it:**
- `ModuleManager.kt` — import + registration
- `DupeExploit.kt` and `DupePaper1204.kt` are internal to the folder

**Action plan:**
1. Delete `exploit/dupe/` folder
2. In `ModuleManager.kt`: remove import + registration

---

## ModuleKick

**Depends on it:**
- `ModuleManager.kt` — import + registration only

**Action plan:**
1. Delete `exploit/ModuleKick.kt`
2. In `ModuleManager.kt`: remove import + registration

---

## ModulePhase (+ modes)

**Depends on it:**
- `ModuleManager.kt` — import + registration
- `PhaseBlink.kt` internally imports `ModuleBlink` from the blink feature — this is fine, Blink stays

**Action plan:**
1. Delete `exploit/phase/` folder
2. In `ModuleManager.kt`: remove import + registration

---

## ModuleClickTp

**Depends on it:**
- `ModuleManager.kt` — import + registration only

**Action plan:**
1. Delete `exploit/ModuleClickTp.kt`
2. In `ModuleManager.kt`: remove import + registration

---

## ModuleTpAura (+ modes)

**Depends on it:**
- `ModuleManager.kt` — import + registration
- `ModuleAutoLeave.kt` — check if it references TpAura; from the grep it appeared in the same search but as a false positive (ModuleAutoLeave is a separate combat module that's kept)

**Action plan:**
1. Delete `combat/tpaura/` folder
2. In `ModuleManager.kt`: remove import + registration
3. Verify `ModuleAutoLeave.kt` compiles cleanly after removal

---

## InteropFunctionRegistry

This file registers all REST endpoints for the CEF UI. When removing online services, remove the corresponding registration lines here:
- `MarketplaceFunctions`
- `AccountFunctions`
- Any cosmetics-related functions

File: `src/main/kotlin/.../integration/interop/ClientInteropServer.kt` or `InteropFunctionRegistry.kt`

---

## Things That Are Safe to Delete in Isolation

These have no known dependents outside their own folder:
- `servercrasher/` exploit types
- `dupe/` exploit types
- `phase/` modes
- `tpaura/` modes
- All `marketplace/` command subcommands
- All `api/models/marketplace/` data classes

---

## Graphify Cross-Reference

When in doubt, run:
```
graphify query <ClassName>
```
or open `graphify-out/graph.json` and search for the node. The graph has 9339 nodes and 12048 edges — every dependency in the codebase is mapped there.
