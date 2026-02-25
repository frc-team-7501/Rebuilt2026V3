// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.accessories;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {

  private boolean intakePosition;

  /** Creates a new Sensors. */
  public Sensors() {
    // true is out, false is in TODO: match end of auton
    intakePosition = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Get and set intake positions
  public void setIntakePosition(boolean intakePosition) {
    this.intakePosition = intakePosition;
  }
  public boolean getIntakePosition() {
    return intakePosition;
  }
  
  // public double[] getTagPosition() {
  //   var result = photonCamera.getLatestResult();
  //   target = result.getBestTarget();
  //   // Defaults values to zero
  //   // IF YOU CHANGE THIS ARRAY CHANGE IT IN AUTONOMOUS
  //   double[] photonPositions = { 0.0, 0.0, 0.0, 0.0};
  //   // If it sees a target
  //   if (result.hasTargets()) {
  //     targetID = target.getFiducialId();
  //     Transform3d cameraToTarget = target.getBestCameraToTarget();
  //     if ((targetID >= 6 && targetID <= 11) || (targetID >= 17 && targetID <= 22)) {
  //       photonPositions[MiscMapping.VISX] = cameraToTarget.getTranslation().getX();
  //       photonPositions[MiscMapping.VISY] = cameraToTarget.getTranslation().getY();
  //       // Fix the rotation values for PID commands
  //       if (cameraToTarget.getRotation().getZ() * (180 / Math.PI) > 0) {
  //         photonPositions[MiscMapping.VISZ] = cameraToTarget.getRotation().getZ() * (180 / Math.PI) - 180;
  //       } else {
  //         photonPositions[MiscMapping.VISZ] = cameraToTarget.getRotation().getZ() * (180 / Math.PI) + 180;
  //       }
  //       photonPositions[MiscMapping.VISFOUND] = 1.0;
  //     }
  //   }
  // }
}
