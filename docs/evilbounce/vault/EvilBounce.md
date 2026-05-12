---
tags: [hub, overview]
---

# EvilBounce

Blatant PvP Minecraft client — fork of LiquidBounce nextgen v0.37.0.

## Mission
- Strip dead weight (online services, server exploits, teleport cheats)
- Keep all combat/utility/movement features
- Full rebrand: blue → red, logo flipped upside-down

## Core Systems
- [[Systems-CEF]] — browser GUI (Chromium, kept as-is for now)
- [[Systems-Events]] — event bus wiring all modules together
- [[Systems-Config]] — ValueGroup / settings serialization
- [[Systems-Mixins]] — Fabric mixin injection layer
- [[Systems-Scripting]] — JS script engine
- [[Systems-DeepLearn]] — ML aimbot support

## Module Categories
- [[Modules-Combat]] — KillAura, Reach, Velocity, CrystalAura, etc.
- [[Modules-World]] — Scaffold, PacketMine, Surround, Nuker, etc.
- [[Modules-Movement]] — Fly, Speed, Step, Blink, HighJump, etc.
- [[Modules-Exploit]] — Disabler, SleepWalker, GhostHand, etc.
- [[Modules-Player]] — NoFall, Reach, InventoryCleaner, etc.
- [[Modules-Misc]] — AntiBot, BetterChat, Macros, etc.
- [[Modules-Render]] — ESP, Nametags, HitFX, etc.

## Deletion Tracker
- [[Deletions]] — what has been removed and when

## Critical Reference
- [[GodNodes]] — top 10 most-connected abstractions (never blindly delete)
- [[Rebrand]] — color, logo, naming rules

## Graph Stats
9339 nodes · 12048 edges · 1213 communities (graphify, 2026-05-12)
