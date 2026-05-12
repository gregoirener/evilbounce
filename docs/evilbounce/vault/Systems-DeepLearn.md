---
tags: [system]
---

# System: DeepLearn (ML Aimbot)

## Status: KEEP

Machine learning support for aimbot behavior. Used by combat modules for humanized aim prediction.

## What It Is

The `deeplearn/` package provides neural network-based aim smoothing and target prediction, used primarily by `ModuleAimbot` and potentially `ModuleKillAura` aim components.

## Key Location

`src/main/kotlin/.../deeplearn/`

## Dependencies

- `ModuleAimbot` imports from deeplearn
- Commands in `command/commands/deeplearn/` expose training/config controls

## Relations

- [[Modules-Combat]] — Aimbot and KillAura use deeplearn for aim
- [[EvilBounce]] — kept as-is, part of our combat feature set
