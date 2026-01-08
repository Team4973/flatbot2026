package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import com.ctre.phoenix6.hardware.TalonFX;


public class RobotContainer {

  public final TalonFX m1 = new TalonFX(30); // change device ID to match your configuration
  public final CommandXboxController input_interface = new CommandXboxController(0);

  public double speed = 0.1; // initalize the speed as 0.1

    public RobotContainer() {
    runMotor();
    changeSpeed();
    }

    private void runMotor() {
      input_interface.a().onTrue(
        new InstantCommand(() -> {
          System.out.println("m1 set at" + speed);
          m1.set(speed); // spin up motor 1 at 0.1 speed
        })
      );
      input_interface.a().onFalse(
        new InstantCommand(() -> {
          m1.set(0.0); // set motor off when a is not true
        })
      );
    }

    private void changeSpeed() {
      input_interface.povUp().onTrue(
        new InstantCommand(() -> {
          speed += 0.05;
        })
      );
      input_interface.povDown().onTrue(
        new InstantCommand(() -> {
          speed -= 0.05;
        })
      );
      
    }
}



