# EvilBounce — Agent Context File

> **Read this entire file before touching any code.**
> Every session, every agent, every task — start here.

---

## What Is This Project

**EvilBounce** is a fork of [LiquidBounce nextgen](https://github.com/CCBlueX/LiquidBounce) (v0.37.0), a Fabric-based mixin injection Minecraft hacked client written in Kotlin + Java.

Our goal is to:
1. **Strip dead weight** — remove online services, server-destroying exploits, and teleport cheats to reduce jar size and complexity
2. **Keep all blatant combat and utility features** — KillAura, Reach, Scaffold, BedBreaker, Velocity, CrystalAura, and everything in between
3. **Rebrand completely** — EvilBounce, red theme, flipped logo

This is a **blatant PvP client**. We are not trying to be legit. Anticheat bypass modules, movement hacks, and combat cheats are all intentional and must be preserved.

---

## Rebrand Rules

> **Before touching any UI/theme file, read [`docs/evilbounce/rebrand.md`](docs/evilbounce/rebrand.md) in full.**

- Client name: `LiquidBounce` → `EvilBounce` everywhere (strings, configs, metadata, UI)
- Primary color: all blues (`#1787D4`, `#5B9BD5`, CCBlueX brand blue) → **red** (`#D41717` or equivalent)
- Window title bar icon / taskbar icon: flip upside down + recolor red
- CEF browser GUI (the Svelte/JS theme in `src-theme/`): keep it, just recolor blue → red
- Do NOT rewrite the CEF/browser UI system — it is the heaviest system and rewriting it would be enormous scope
- The logo SVG lives at: referenced via `LiquidCloud` CDN in `README.md` — replace with local red/flipped version
- Maven group `net.ccbluex` and internal package names can stay as-is to minimize refactor scope

---

## What to DELETE

> **Before deleting anything, check [`docs/evilbounce/dependencies.md`](docs/evilbounce/dependencies.md).
> Many of these touch `LiquidBounce.kt`, `ModuleManager.kt`, `CommandManager.kt`, and the REST interop registry — you must clean up all references or the build breaks.**

### Online Services (full removal)
| System | Location |
|--------|----------|
| Marketplace feature | `src/main/kotlin/.../features/marketplace/` |
| Marketplace API models | `src/main/kotlin/.../api/models/marketplace/` |
| Marketplace API service | `src/main/kotlin/.../api/services/marketplace/MarketplaceApi.kt` |
| Marketplace commands | `src/main/kotlin/.../command/commands/client/marketplace/` |
| Marketplace REST functions | `src/main/kotlin/.../integration/interop/protocol/rest/v1/client/MarketplaceFunctions.kt` |
| Cosmetics service | `src/main/kotlin/.../api/services/cosmetics/` (and all `CosmeticService` references) |
| Cosmetics API models | `src/main/kotlin/.../api/models/cosmetics/` |
| Account manager | `src/main/kotlin/.../features/account/` |
| Account REST functions | `src/main/kotlin/.../integration/interop/protocol/rest/v1/client/AccountFunctions.kt` |
| Online auth / OAuth | `src/main/kotlin/.../api/core/auth/` and `NettyAuthHandler`, `OAuthClient`, `OAuthSession` |

**After removing:** clean up `LiquidBounce.kt` — remove `MarketplaceManager` init, cosmetics launch block, and marketplace update coroutine. Remove from `InteropFunctionRegistry`.

### Server-Breaking Exploits (full removal)
| Module | Location |
|--------|----------|
| ModuleServerCrasher + all exploit types | `src/main/kotlin/.../exploit/servercrasher/` (entire folder) |
| ModuleDupe + DupeExploit, DupePaper1204 | `src/main/kotlin/.../exploit/dupe/` (entire folder) |
| ModuleKick | `src/main/kotlin/.../exploit/ModuleKick.kt` |

### Teleport Cheats (full removal)
| Module | Location |
|--------|----------|
| ModulePhase + all modes | `src/main/kotlin/.../exploit/phase/` (entire folder) |
| ModuleClickTp | `src/main/kotlin/.../exploit/ModuleClickTp.kt` |
| ModuleTpAura + AStarMode + ImmediateMode | `src/main/kotlin/.../combat/tpaura/` (entire folder) |

**After removing each module:** remove the corresponding `import` and registration line from `ModuleManager.kt`.

---

## What to KEEP (do not touch)

### Core Combat (sacred — never delete)
- `ModuleKillAura` + all subfeatures (Range, AutoBlock, FightBot, etc.)
- `ModuleReach` (`player/ModuleReach.kt`)
- `ModuleVelocity` + all modes
- `ModuleCriticals` + all modes
- `ModuleCrystalAura` + all submodules
- `ModuleAimbot` / `ModuleAutoBow` / `ModuleProjectileAimbot`
- `ModuleAutoClicker`
- `ModuleBacktrack`
- `ModuleHitbox`
- `ModuleSuperKnockback`
- `ModuleFakeLag`
- `ModuleTickBase` / `ModuleTimerRange`
- `ModuleElytraTarget`
- `ModuleMaceKill`

### World / Utility (sacred)
- `ModuleScaffold` + all techniques and tower modes
- `ModuleBedDefender` (bed protection)
- `ModulePacketMine` (fast bed breaking)
- `ModuleNuker` + all modes
- `ModuleFastBreak` / `ModuleFastPlace`
- `ModuleSurround`
- `ModuleHoleFiller`
- `ModuleAutoTrap`
- `ModuleTimer`

### Movement (keep all)
- All of: `ModuleFly`, `ModuleSpeed`, `ModuleStep`, `ModuleNoSlow`, `ModuleSpider`, `ModuleNoFall`, `ModuleLiquidWalk`, `ModuleBlink`, `ModuleHighJump`, `ModuleLongJump`, `ModuleElytraFly`, `ModuleInventoryMove`
- AC-bypass movement: `ModuleDisabler`, `ModuleResetVL`

### Exploit (keep all remaining)
- `ModuleSleepWalker`, `ModuleAntiHunger`, `ModuleGhostHand`, `ModuleMultiActions`, `ModuleMoreCarry`
- `ModuleNoPitchLimit`, `ModulePingSpoof`, `ModuleFakeLag`, `ModulePlugins`, `ModuleNameCollector`
- `ModuleDisabler` + all disabler modes
- `ModuleYggdrasilSignatureFix`

### Infrastructure (never delete)
- **Event system** (`event/`) — everything depends on this
- **Config/ValueGroup system** (`config/`) — everything depends on this
- **Mixin system** (`injection/`, `interfaces/`) — this IS how the client works
- **Script engine** (`features/script/`, `ScriptManager`) — keep, it's modular and adds value
- **DeepLearn** (`deeplearn/`) — keep, used by aimbot features
- **CEF integration** (`integration/`) — keep entirely, just rebrand the theme
- **Render system** (`render/`) — keep entirely

---

## Architecture Overview

Every agent working on this codebase must understand these 6 systems:

### 1. Module System
- Base class: `ClientModule` (`features/module/ClientModule.kt`)
- Registered in: `ModuleManager.kt` — one import + one entry in the `modules` list per module
- Modules subscribe to events via `handler { }` and `sequenceHandler { }` delegates
- Settings are declared as `val x by [type]("Name", default)` inside the module class

### 2. Event System
- Event bus in `event/EventManager.kt`
- Events fired via `EventManager.callEvent(event)`
- Handlers registered automatically when a `ClientModule` is enabled
- God node: `events.js` (63 edges) — the JS side mirrors every Kotlin event for the CEF UI

### 3. Config / ValueGroup System
- Settings serialize to JSON via `ConfigSystem`
- `ValueGroup` (51 edges) is the base for all grouped settings
- `regular()` (117 edges) and `variable()` (81 edges) are the most-used setting DSL functions — **do not remove or rename these**
- `jsonObject()` (57 edges) is the serialization utility — do not touch

### 4. CEF Integration (browser GUI)
- Kotlin backend: `integration/` — REST server, event bridge, screen management
- JS/Svelte frontend: `src-theme/` — the actual GUI rendered in a Chromium window
- Bridge: `rest.js` (125 edges — **most connected node in the entire codebase**)
- `types.js` (87 edges) and `events.js` (63 edges) are equally critical
- When rebranding: change colors in `src-theme/`, do NOT restructure the bridge

### 5. Mixin System
- Java mixins: `src/main/java/.../injection/` and `interfaces/`
- Kotlin-side additions: `additions/`
- Mixins inject into Minecraft classes at load time — changes here affect game behavior globally
- Never delete a mixin without checking every module that relies on the interface it adds

### 6. Script Engine
- `features/script/ScriptManager.kt` — loads JS scripts as modules
- Scripts can register modules, commands, and event handlers
- Keep intact — zero runtime cost when no scripts are loaded

---

## God Nodes (from graphify — most connected abstractions)

These are the 10 nodes with the most edges in the entire codebase. **Renaming or removing any of these without a full codebase search will break the build.**

| Node | Edges | What it is |
|------|-------|-----------|
| `rest.js` | 125 | CEF ↔ Kotlin REST bridge — the spine of the UI |
| `regular()` | 117 | Primary setting declaration DSL function |
| `Vec3` | 88 | 3D vector used everywhere in movement/combat math |
| `types.js` | 87 | JS type definitions for all CEF UI data |
| `variable()` | 81 | Variable setting declaration DSL function |
| `events.js` | 63 | JS-side event definitions mirroring Kotlin events |
| `jsonObject()` | 57 | Gson extension for building JSON responses |
| `ValueGroup` | 51 | Base class for all grouped module settings |
| `Color4b` | 47 | RGBA color used throughout render system |
| `markAsError()` | 46 | Error reporting in config/command DSL |

---

## Hard Rules for Every Agent

1. **Read `docs/evilbounce/dependencies.md` before deleting any file or class.** The delete list above has known cascades — that file has the full map.
2. **After removing a module, always remove its `import` and registration from `ModuleManager.kt`.** The build will fail otherwise.
3. **After removing an online service, always clean up `LiquidBounce.kt`.** The init sequence calls Marketplace, Cosmetics, and Auth explicitly.
4. **Never touch `regular()`, `variable()`, `ValueGroup`, `Vec3`, or `rest.js` without checking all 50–117 dependents first.**
5. **The CEF theme (`src-theme/`) uses Svelte + TypeScript.** When recoloring, change CSS variables and theme config files — do not restructure components.
6. **Run `./gradlew build` (or at minimum `./gradlew compileKotlin`) after any structural change** to verify the build is not broken before reporting a task complete.
7. **Check node relations in the Obsidian vault** at `docs/evilbounce/vault/` when unsure about what depends on what. The vault mirrors the graphify knowledge graph.

---

## File Map

```
CLAUDE.md                          ← you are here (read every session)
docs/evilbounce/
  modules.md                       ← full keep/nuke module list with paths
  dependencies.md                  ← cascade map: what breaks when you delete X
  rebrand.md                       ← color, logo, naming rules
  vault/                           ← Obsidian knowledge graph
    EvilBounce.md                  ← vault entry point / hub
    Systems-*.md                   ← one note per core system
    Modules-*.md                   ← one note per module category
    Deletions.md                   ← deletion tracker (update as you remove things)
    GodNodes.md                    ← the 10 god nodes and their dependents
graphify-out/
  GRAPH_REPORT.md                  ← full graphify output (9339 nodes, 12048 edges)
  graph.json                       ← raw graph data
```

---

## Build & Dev

```bash
./gradlew genSources       # generate Minecraft sources (do once)
./gradlew runClient        # run the client in dev
./gradlew build            # full build
./gradlew compileKotlin    # fast check — just verify Kotlin compiles
```

Requires: JDK 21, Node.js (for src-theme), Gradle.
