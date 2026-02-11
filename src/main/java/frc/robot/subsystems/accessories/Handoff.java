// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.accessories;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class Handoff extends SubsystemBase {
  private final SparkMax m_HandoffMotor = new SparkMax(CANMapping.HANDOFF_DRIVE, MotorType.kBrushless);
  private static Handoff instance;

  /** Creates a new Handoff. */
  public Handoff() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Handoff getInstance() {
    if (instance == null)
      instance = new Handoff();
    return instance;
  }

  public void runHandoff(double HandoffPower) {
    m_HandoffMotor.set(HandoffPower);
  }

  public void stop() {
    m_HandoffMotor.set(0);
  }
}
