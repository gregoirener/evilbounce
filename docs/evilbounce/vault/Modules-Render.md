---
tags: [modules, render]
---

# Modules: Render

## Status: ALL KEPT

| Module | Feature | Path |
|--------|---------|------|
| ModuleESP | See entities through walls | `render/esp/` |
| ModuleNametags | Enhanced player nametags | `render/nametags/` |
| ModuleHitFX | Hit effects/particles | `render/hitfx/` |
| ModuleTrajectories | Show projectile trajectories | `render/trajectories/` |
| ModuleCrosshair | Custom crosshair | `render/crosshair/` |
| ModuleMurderMystery | Murder Mystery game helper | `render/murdermystery/` |
| ModuleHats | Wear blocks as hats | `render/hats/` |
| ModuleCameraClip | Remove camera clipping | `render/cameraclip/` |
| ModuleAnimations | Custom arm animations | `render/ModuleAnimations.kt` |
| ModuleAntiBlind | Remove blindness/darkness effects | `render/ModuleAntiBlind.kt` |
| ModuleAspect | Change aspect ratio | `render/ModuleAspect.kt` |
| ModuleAutoF5 | Auto third-person view | `render/ModuleAutoF5.kt` |
| ModuleBedPlates | BedWars bed health display | `render/ModuleBedPlates.kt` |
| ModuleBetterInventory | Better inventory rendering | `render/ModuleBetterInventory.kt` |
| ModuleBlockESP | Highlight specific blocks | `render/ModuleBlockESP.kt` |
| ModuleBlockOutline | Custom block selection outline | `render/ModuleBlockOutline.kt` |
| ModuleBreadcrumbs | Show player trail | `render/ModuleBreadcrumbs.kt` |
| ModuleChams | Entity model color override | `render/ModuleChams.kt` |
| ModuleClickGui | In-game module GUI | `render/ModuleClickGui.kt` |
| ModuleCrystalView | Crystal render improvements | `render/ModuleCrystalView.kt` |
| ModuleCustomAmbience | Fog/sky color override | `render/ModuleCustomAmbience.kt` |
| ModuleDamageParticles | Show damage numbers | `render/ModuleDamageParticles.kt` |

## God Node Dependency

- [[GodNodes]] → `Color4b` (47 edges) — used throughout all render modules for RGBA colors

## Rebrand Impact

- `ModuleClickGui` — may have a hardcoded blue accent color; update to red
- ESP and nametag colors are user-configurable — no change needed
- Any hardcoded blue values in render code → red (see [[Rebrand]])

## Relations

- [[Systems-CEF]] — render system overlaps with the CEF GUI layer
- [[GodNodes]] — Color4b is critical here
- [[Rebrand]] — some modules need color updates
