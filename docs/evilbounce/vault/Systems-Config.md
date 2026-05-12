---
tags: [system, critical]
---

# System: Config & ValueGroup

## Status: KEEP — Core Infrastructure

All module settings are declared, serialized, and deserialized through this system.

## What It Is

A declarative settings DSL. Modules declare settings as Kotlin properties:

```kotlin
val range by floats("Range", default = 3.0f, min = 1.0f, max = 6.0f)
val mode by enumChoice("Mode", ModeEnum.NORMAL, ModeEnum.values())
```

These are automatically serialized to JSON and exposed to the CEF UI via the REST layer.

## Key Files

| File | Role |
|------|------|
| `config/ConfigSystem.kt` | Root config serializer, loads/saves all settings |
| `config/types/ValueGroup.kt` | Base class — all settings containers inherit from this |
| `config/types/` | All setting types: float, int, bool, enum, color, etc. |
| `config/autoconfig/AutoConfig.kt` | Downloads + applies remote config presets |
| `config/gson/util/GsonExtensions.kt` | `jsonObject()`, `jsonArray()` — Gson helpers |

## God Nodes

- [[GodNodes]] → `regular()` (117 edges) — primary setting declaration
- [[GodNodes]] → `variable()` (81 edges) — variable settings
- [[GodNodes]] → `ValueGroup` (51 edges) — base class for settings groups
- [[GodNodes]] → `jsonObject()` (57 edges) — serialization utility
- [[GodNodes]] → `markAsError()` (46 edges) — error handling in config DSL

## AutoConfig Note

`AutoConfig` downloads config presets from the Marketplace. When Marketplace is removed:
- `ModuleAutoConfig` must be audited — it may break without a valid marketplace source
- Option: gut `ModuleAutoConfig` to only support local config files
- Option: remove `ModuleAutoConfig` entirely (it's a misc module, not combat-critical)

## Relations

- [[Systems-CEF]] — settings exposed via REST for UI rendering
- [[Modules-Combat]] — every module uses `regular()` and `variable()`
- [[Deletions]] — AutoConfig may need modification after Marketplace removal
