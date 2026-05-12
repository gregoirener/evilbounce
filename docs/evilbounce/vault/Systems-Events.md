---
tags: [system, critical]
---

# System: Event Bus

## Status: KEEP — Core Infrastructure

Every module communicates through this system. Removing or breaking it kills all modules.

## What It Is

A synchronous event bus. Kotlin events are fired via `EventManager.callEvent(event)`. Modules register handlers using Kotlin delegation:

```kotlin
val attackHandler = handler<AttackEntityEvent> { event ->
    // runs when player attacks
}
```

Handlers are automatically registered/unregistered when a module is enabled/disabled.

## Key Files

| File | Role |
|------|------|
| `event/EventManager.kt` | Central bus, fires events |
| `event/events/` | All event definitions (~60+ events) |
| `event/handler` delegates | `handler { }`, `sequenceHandler { }` — subscription DSL |
| `src-theme/.../integration/events.js` | JS mirror of all events for the CEF UI |

## God Node

- [[GodNodes]] → `events.js` (63 edges) — the JS side must stay in sync with Kotlin events

## Important Events for EvilBounce Work

| Event | Fired When | Key Users |
|-------|-----------|-----------|
| `AttackEntityEvent` | Player hits entity | KillAura, AutoClicker |
| `PacketEvent` | Any packet sent/received | Velocity, Backtrack, FakeLag |
| `MovementInputEvent` | Player movement tick | Speed, Fly, NoSlow, Scaffold |
| `WorldRenderEvent` | Game render frame | ESP, Nametags, Trajectories |
| `TickEvent` | Game tick | Most combat modules |
| `BedStateChangeEvent` | Bed destroyed/placed | BedDefender, UI |

## Relations

- [[Systems-CEF]] — events.js subscribes to these events for UI updates
- [[Modules-Combat]] — combat modules are heavily event-driven
- [[Modules-Movement]] — movement modules hook MovementInputEvent
- [[Systems-Config]] — config change events trigger UI updates
