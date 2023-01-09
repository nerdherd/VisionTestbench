package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase{
    public PhotonCamera photonCamera;
    public PhotonTrackedTarget photonTrackedTarget;

    public Vision(){
        photonCamera = new PhotonCamera("687Limelight1");
    }

    public PhotonTrackedTarget getTarget(){
        var result = photonCamera.getLatestResult();
        
        if (result.hasTargets()) { // Check to result.hasTargets() cannot be in a separate variable, it must be checked directly.
            photonTrackedTarget = result.getBestTarget();
            return photonTrackedTarget;
        } 
        else {
            return null;
        }

    }
}