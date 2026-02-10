// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class Spindexer extends SubsystemBase {
  private final SparkMax m_SpindexerMotor = new SparkMax(CANMapping.SPINDEXER_DRIVE, MotorType.kBrushless);
  private static Spindexer instance;

  /** Creates a new Spindexer. */
  public Spindexer() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static Spindexer getInstance() {
    if (instance == null)
      instance = new Spindexer();
    return instance;
  }

  public void runSpindexer(double SpindexerPower) {
    m_SpindexerMotor.set(SpindexerPower);
  }

  public void stop() {
    m_SpindexerMotor.set(0);
  }
}
