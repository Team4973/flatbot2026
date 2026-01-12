#!/bin/bash
# Run the same CI build locally using the WPILib Docker container
# This mimics what GitHub Actions runs

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

echo "Running CI build in WPILib Docker container..."
echo "Project directory: $PROJECT_DIR"

docker run --rm \
  -v "$PROJECT_DIR":/work \
  -w /work \
  wpilib/roborio-cross-ubuntu:2025-22.04 \
  bash -c "chmod +x gradlew && ./gradlew build"

echo ""
echo "CI build completed successfully!"
