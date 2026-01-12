# flatbot2026

[![CI](https://github.com/Team4973/flatbot2026/actions/workflows/ci.yml/badge.svg)](https://github.com/Team4973/flatbot2026/actions/workflows/ci.yml)

FRC Team 4973's robot code for the 2026 season.

## Build Commands

```bash
# Build
./gradlew build

# Deploy to robot (requires robot connection)
./gradlew deploy

# Run simulation with GUI
./gradlew simulateJava

# Run tests
./gradlew test

# Clean build
./gradlew clean
```

## Architecture

- **Team Number**: 4973
- **Framework**: WPILib TimedRobot with Command-based structure
- **Motor Controllers**: CTRE Phoenix6 TalonFX
- **Language**: Java 17
