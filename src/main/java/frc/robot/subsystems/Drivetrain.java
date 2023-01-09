package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase{
    private Vision vision;
    public Drivetrain(Vision vision){
        this.vision = vision;
    }
    // PID constants should be tuned per robot
    PIDController forwardController = new PIDController(DriveConstants.kLinearP, 0, DriveConstants.kLinearP);
    PIDController turnController = new PIDController(DriveConstants.kAngularP, 0, DriveConstants.kAngularD);

     // Drive motors
    PWMTalonFX leftMotor = new PWMTalonFX(0);
    PWMTalonFX rightMotor = new PWMTalonFX(1);
    DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
    
    public double getApriltagRotation() {
        double rotationSpeed;
        if(vision.limelightHasTargets){
            rotationSpeed = -turnController.calculate(vision.getYaw(), 0);
        }else{
        rotationSpeed = 0;
        }
        SmartDashboard.putNumber("RotationSpeed", rotationSpeed);
        return rotationSpeed;
    }

    public void arcadeDrive(double forwardSpeed, double rotationSpeed){
        drive.arcadeDrive(forwardSpeed, rotationSpeed);
    }
}
