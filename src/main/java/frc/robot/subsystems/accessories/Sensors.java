// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.accessories;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {

  private boolean intakePosition;
  private static Sensors instance;
  public Rotation2d targetRotation;

  /** Creates a new Sensors. */
  public Sensors() {
    // true is out, false is in TODO: match end of auton
    intakePosition = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Sensors getInstance() {
    if (instance == null)
      instance = new Sensors();
    return instance;
  }

  // Get and set intake positions
  public void setIntakePosition(boolean intakePosition) {
    this.intakePosition = intakePosition;
  }
  public boolean getIntakePosition() {
    return intakePosition;
  }

  public void setTargetRotation() {
    // if (alliance == blue) {
    //   blueXTargetMeters - photonxdistance, yMeters
    // }
  }
  public Rotation2d getTargetRotation() {
    return targetRotation;
  }
}
