---
tags: [system, gui, critical]
---

# System: CEF Browser GUI

## Status: KEEP — Do Not Restructure

The heaviest single system in the project. Kept as-is. Only rebrand (colors, name strings).

## What It Is

LiquidBounce (and EvilBounce) renders its GUI using **Chromium Embedded Framework (CEF)**. A Svelte/TypeScript frontend runs inside a Chromium window embedded in Minecraft. Kotlin serves a local REST API that the JS frontend consumes.

## Key Files

| File | Role |
|------|------|
| `src-theme/` | Entire Svelte/TS frontend — all GUI screens |
| `integration/` | Kotlin backend — REST server, event bridge, CEF lifecycle |
| `integration/interop/protocol/rest/v1/` | REST endpoint handlers |
| `integration/interop/ClientInteropServer.kt` | Starts the local HTTP server |
| `integration/theme/ThemeManager.kt` | Loads and manages the theme |
| `integration/screen/` | Screen management (which screen is open) |

## God Node Dependencies

- [[GodNodes]] → `rest.js` (125 edges) — the JS bridge to all Kotlin REST calls
- [[GodNodes]] → `types.js` (87 edges) — all TS/JS type definitions
- [[GodNodes]] → `events.js` (63 edges) — JS event subscriptions

## Rebrand Tasks

See [[Rebrand]] for full rules. Summary:
- Change CSS color variables: blue → red
- Update brand name strings in JS/Svelte components
- Replace logo asset with red/flipped version
- Do NOT modify rest.js, types.js, or events.js structure

## Removal Requirement for Online Services

When removing Marketplace and Account features:
- Delete `MarketplaceFunctions.kt` from the REST registry
- Delete `AccountFunctions.kt` from the REST registry
- Remove corresponding UI screens from `src-theme/` (or leave as dead screens — low risk)
- Update `InteropFunctionRegistry` / `ClientInteropServer.kt`

## Relations

- [[Systems-Events]] — events.js mirrors Kotlin events
- [[Systems-Config]] — REST endpoints expose config values
- [[Modules-Render]] — some render modules integrate with the CEF overlay
- [[Deletions]] — Marketplace and Account screens to be removed
