# Parking Lot – Low Level Design

A Java implementation of a Parking Lot system, designed and built as LLD interview
practice. Supports multiple floors, multiple vehicle types, slot allocation,
ticket generation, and fare calculation on exit.

## Problem Statement
Design a parking lot that:
- Has multiple floors, each with parking slots of different types (Bike, Car, Truck)
- Assigns an available compatible slot to an incoming vehicle
- Issues a ticket with entry time on parking
- Calculates fare based on duration on exit, and frees the slot

## Class Design
- `VehicleType` – enum: BIKE, CAR, TRUCK
- `SpotType` – enum: BIKE, CAR, TRUCK, with a `canFit(VehicleType)` compatibility check
- `Vehicle` – vehicle number + type
- `ParkingSlot` – slot id, type, availability
- `ParkingFloor` – a floor's list of slots
- `ParkingLot` – name, address, list of floors
- `Ticket` – ticket no, vehicle, entry time, assigned slot
- `ParkingService` – business logic: allocate slot on park, compute fare on unpark

## Key Design Decisions
1. **Single enum + compatibility method over two matching enums.**
   Considered separate `VehicleType`/`SpotType` enums matched via `.name().equals()`.
   Replaced with `SpotType.canFit(VehicleType)` — a bigger slot can hold a smaller
   vehicle (e.g. a TRUCK slot fits any vehicle), avoiding fragile string comparison.

2. **Constructor injection over Singleton for `ParkingLot`.**
   A parking lot is conceptually a single physical resource, which is the textbook
   Singleton case. Chose constructor injection instead — `ParkingService` takes a
   `ParkingLot` instance directly — for easier testing and to avoid global mutable
   state / hidden coupling.

## How to Run
```bash
cd src
javac parkinglot/*.java
java parkinglot.Main
```

## Known Limitations / Next Steps
- `getFloors()`/`getSlots()` currently return live internal lists (encapsulation leak) — TODO: return unmodifiable views.
- No automated tests yet — currently verified via `Main.java` manual run.
- No persistence layer — in-memory only.
