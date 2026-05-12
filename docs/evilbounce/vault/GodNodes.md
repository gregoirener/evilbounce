---
tags: [critical, architecture]
---

# God Nodes

> These are the 10 most-connected nodes in the codebase (from graphify).
> **Renaming or removing any of these without a full codebase search will break the build.**

## The List

| Rank | Node | Edges | Location | What It Does |
|------|------|-------|----------|--------------|
| 1 | `rest.js` | 125 | `src-theme/.../integration/rest.js` | CEF ↔ Kotlin REST bridge. Spine of the entire GUI. |
| 2 | `regular()` | 117 | `config/types/` DSL | Primary setting declaration function. Used in every module. |
| 3 | `Vec3` | 88 | Minecraft / utils | 3D vector. Used in all movement and combat math. |
| 4 | `types.js` | 87 | `src-theme/.../integration/types.js` | JS type definitions for all CEF data structures. |
| 5 | `variable()` | 81 | `config/types/` DSL | Variable setting declaration. Used alongside `regular()`. |
| 6 | `events.js` | 63 | `src-theme/.../integration/events.js` | JS-side event definitions mirroring Kotlin events. |
| 7 | `jsonObject()` | 57 | `config/gson/util/GsonExtensions.kt` | Gson builder utility. Used in all REST response builders. |
| 8 | `ValueGroup` | 51 | `config/types/ValueGroup.kt` | Base class for all grouped module settings. |
| 9 | `Color4b` | 47 | `render/engine/type/Color4b.kt` | RGBA color. Used throughout the entire render system. |
| 10 | `markAsError()` | 46 | Config / command DSL | Error flagging in config/command parsing. |

## Relations

- `rest.js` → connects to [[Systems-CEF]]
- `regular()`, `variable()`, `ValueGroup` → connects to [[Systems-Config]]
- `Vec3` → used by [[Modules-Combat]], [[Modules-Movement]], [[Systems-CEF]]
- `types.js`, `events.js` → connects to [[Systems-CEF]], [[Systems-Events]]
- `jsonObject()` → connects to [[Systems-CEF]] (REST responses)
- `Color4b` → connects to [[Modules-Render]]
- `markAsError()` → connects to [[Systems-Config]]

## Rule

Before touching any of these nodes:
1. Run `graphify query <node>` to see all dependents
2. Or search `graphify-out/graph.json` for the node name
3. Plan changes to all dependents before making the edit
