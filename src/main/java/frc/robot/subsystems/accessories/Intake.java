// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.accessories;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class Intake extends SubsystemBase {
  private final TalonFX m_IntakeMotor = new TalonFX(CANMapping.INTAKE_DRIVE);
  private static Intake instance;
  
  /** Creates a new Intake. */
  public Intake() {
  }

  public static Intake getInstance() {
    if (instance == null)
      instance = new Intake();
    return instance;
  }

  public void runIntake(double IntakePower) {    
      m_IntakeMotor.set(IntakePower); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    m_IntakeMotor.set(0);
  }
}