---
tags: [system]
---

# System: Script Engine

## Status: KEEP — Zero Runtime Cost, High Value

The scripting system lets users write JavaScript modules that plug into EvilBounce. No runtime cost when no scripts are loaded.

## What It Is

`ScriptManager` loads `.js` files from a scripts folder and exposes EvilBounce APIs (modules, events, commands) to them. Scripts can register new modules, add commands, and subscribe to events — identical to built-in modules.

## Key Files

| File | Role |
|------|------|
| `features/script/ScriptManager.kt` | Loads, runs, unloads JS scripts |
| `features/script/ScriptContextProvider.kt` | Provides EvilBounce APIs to script context |
| `features/script/ScriptReflectionUtil.kt` | Reflection utilities for JS ↔ Kotlin bridge |
| `features/script/ScriptAsyncUtil.kt` | Async/coroutine utilities for scripts |

## Relations

- [[Systems-Events]] — scripts subscribe to the same events as built-in modules
- [[Systems-Config]] — scripts can declare settings via the same DSL
- [[EvilBounce]] — keep intact, documented in CLAUDE.md as preserved
