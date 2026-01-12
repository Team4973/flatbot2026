package frc.robot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.wpi.first.hal.HAL;

/**
 * Unit tests for RobotContainer.
 * These tests run in simulation mode using the HAL simulation layer.
 */
class RobotContainerTest {

    @BeforeEach
    void setup() {
        // Initialize HAL for simulation - required before creating any WPILib objects
        HAL.initialize(500, 0);
    }

    @AfterEach
    void teardown() {
        // Clean up HAL after each test
        HAL.shutdown();
    }

    @Test
    void robotContainerInitializes() {
        // Test that RobotContainer can be instantiated without errors
        RobotContainer container = new RobotContainer();
        assertNotNull(container);
    }

    @Test
    void initialSpeedIsCorrect() {
        // Test that the initial speed is set to 0.1
        RobotContainer container = new RobotContainer();
        assertEquals(0.1, container.speed, 0.001, "Initial speed should be 0.1");
    }

    @Test
    void motorIsInitialized() {
        // Test that the TalonFX motor is created
        RobotContainer container = new RobotContainer();
        assertNotNull(container.m1, "TalonFX motor should be initialized");
    }
}
