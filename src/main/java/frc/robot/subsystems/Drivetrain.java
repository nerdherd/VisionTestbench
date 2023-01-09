package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase{
    // PID constants should be tuned per robot
    PIDController forwardController = new PIDController(DriveConstants.kLinearP, 0, DriveConstants.kLinearP);
    PIDController turnController = new PIDController(DriveConstants.kAngularP, 0, DriveConstants.kAngularD);

     // Drive motors
    PWMTalonFX leftMotor = new PWMTalonFX(0);
    PWMTalonFX rightMotor = new PWMTalonFX(1);
    DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
    
    public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }
}
