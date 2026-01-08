package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import com.ctre.phoenix6.hardware.TalonFX;


public class RobotContainer {

  public final TalonFX m1 = new TalonFX(30);
  public final CommandXboxController input_interface = new CommandXboxController(0);

    public RobotContainer() {
    runMotor();
    }

    private void runMotor() {
      input_interface.a().onTrue(
        new InstantCommand(() -> {
          System.out.println("m1 set at 0.5");
          m1.set(0.5);
        })
      );
      input_interface.a().onFalse(
        new InstantCommand(() -> {
          m1.set(0.0);
        })
      );
    }
}



