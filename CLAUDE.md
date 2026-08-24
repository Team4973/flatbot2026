# flatbot2026 - Java Robot Code

FRC Team 4973's robot code for the 2026 REBUILT season.

## Quick Start

```bash
# Build (requires Java 17 or use Docker)
./gradlew build

# Run tests
./gradlew test

# Deploy to robot (requires robot connection)
./gradlew deploy

# Run simulation with GUI
./gradlew simulateJava
```

## Local Development with Docker

Your local Java may be too new (project requires Java 17). Use the WPILib Docker container:

```bash
# Run full CI build locally
./scripts/local-ci.sh

# Or manually:
docker run --rm -v $(pwd):/work -w /work \
  wpilib/roborio-cross-ubuntu:2025-22.04 \
  bash -c "./gradlew build"

# Run tests only:
docker run --rm -v $(pwd):/work -w /work \
  wpilib/roborio-cross-ubuntu:2025-22.04 \
  bash -c "./gradlew test"
```

## Architecture

```
src/main/java/frc/robot/
├── Main.java           # Entry point (launches Robot)
├── Robot.java          # TimedRobot lifecycle (auto, teleop, test modes)
└── RobotContainer.java # Subsystems, commands, controller bindings
```

**Framework**: WPILib TimedRobot with Command-based structure

**Control Flow**:
1. `Main.java` calls `RobotBase.startRobot(Robot::new)`
2. `Robot` constructor creates `RobotContainer`
3. `RobotContainer` initializes hardware and binds controller inputs to commands
4. `Robot.robotPeriodic()` runs `CommandScheduler.getInstance().run()` every 20ms

## Hardware Configuration

| Component | Type | ID |
|-----------|------|-----|
| Drive Motor | TalonFX (Phoenix6) | CAN 30 |
| Controller | Xbox | Port 0 |

## Testing

Tests are in `src/test/java/frc/robot/`. Uses JUnit 5 with WPILib HAL simulation.

```java
@BeforeEach
void setup() {
    HAL.initialize(500, 0);  // Required for simulation
}
```

Test reports: `build/reports/tests/test/index.html`

## CI/CD

GitHub Actions runs on all branches and PRs. See `.github/workflows/ci.yml`.

Badge: `[![CI](https://github.com/Team4973/flatbot2026/actions/workflows/ci.yml/badge.svg)](https://github.com/Team4973/flatbot2026/actions/workflows/ci.yml)`

## Vendor Dependencies

Located in `vendordeps/`:
- **Phoenix6** - CTRE TalonFX motor controllers
- **WPILibNewCommands** - Command-based framework

## Key Files

| File | Purpose |
|------|---------|
| `build.gradle` | Build config, dependencies, simulation settings |
| `settings.gradle` | Project name |
| `.wpilib/wpilib_preferences.json` | Team number (4973) |
| `src/main/deploy/` | Files deployed to robot's `/home/lvuser/deploy/` |
