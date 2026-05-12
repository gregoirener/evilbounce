---
tags: [system, critical]
---

# System: Mixin Injection Layer

## Status: KEEP — This IS How the Client Works

Mixins are the foundation. They inject EvilBounce code into Minecraft's classes at load time. Without them, the client does nothing.

## What It Is

SpongePowered Mixins allow modifying Minecraft classes without shipping Mojang's copyrighted code. EvilBounce injects via `@Mixin`, `@Inject`, `@Redirect`, and `@ModifyVariable` annotations.

## Key Locations

| Location | Role |
|----------|------|
| `src/main/java/.../injection/` | Java mixins — most core Minecraft patches |
| `src/main/java/.../interfaces/` | Interface additions (e.g., `IMixinPlayer`) |
| `src/main/kotlin/.../additions/` | Kotlin-side additions and extensions |
| `src/main/resources/liquidbounce.mixins.json` | Mixin config — lists all active mixins |

## Critical Rule

**Never delete a mixin without checking every module that uses the interface it adds.**

Example: `IMixinPlayer` may add `getActiveHand()` or similar — if KillAura uses it, deleting the mixin breaks KillAura.

## How Modules Use Mixins

Modules do not usually extend mixins directly. Instead:
1. A mixin fires an event (e.g., `EventManager.callEvent(AttackEntityEvent(...))`)
2. The module's event handler catches it
3. The mixin may also expose extra data via interfaces on Minecraft classes

## Relations

- [[Systems-Events]] — mixins are the primary source of events
- [[Modules-Combat]] — combat mixins handle attack, damage, packet interception
- [[Modules-Movement]] — movement mixins hook player motion and input
