package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase{
    public PhotonCamera photonCamera;
    public PhotonTrackedTarget photonTrackedTarget;
    public Vision(){
        photonCamera = new PhotonCamera("687Limelight1");
    }
    public PhotonTrackedTarget getTarget(){
        var result = photonCamera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        
        if (hasTargets) {
            photonTrackedTarget = result.getBestTarget();
            return photonTrackedTarget;
        } 
        else {
            return null;
        }

    }
}