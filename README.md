# Assignment 3 - Bridge Pattern

- **Student:** Alizhan Alikhanov
- **Group:** SE-2523
- **Topic:** Option D (Remote controls and Devices)

## Role Map
| Role | Class | Source Path |
| :--- | :--- | :--- |
| Abstraction | Remote | src/remote/Remote.java |
| Refined Abstraction (A1) | BasicRemote | src/remote/BasicRemote.java |
| Refined Abstraction (A2) | QuietRemote | src/remote/QuietRemote.java |
| Implementor | Device | src/device/Device.java |
| Concrete Implementor (I1) | TvDevice | src/device/TvDevice.java |
| Concrete Implementor (I2) | RadioDevice | src/device/RadioDevice.java |
| Extended Implementor (I3) | ProjectorDevice | src/device/ProjectorDevice.java |
| Client | Main | src/Main.java |

## Key Pointers
- **Bridge field:** `device` in `src/remote/Remote.java`
- **execute():** `Remote.execute()` (delegates call to `Device.applySettings`)
- **setImplementation(...):** `Remote.setImplementation(Device device)`
- **T5 check:** `Main.java` (checks reference equality with `==` and verifies unchanged id/preset)

## Build and Run
```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo