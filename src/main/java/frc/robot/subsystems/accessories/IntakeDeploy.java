// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.accessories;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;
import frc.robot.Constants.MiscMapping;

public class IntakeDeploy extends SubsystemBase {
  /** Creates a new IntakeDeployer. */
  private final SparkMax intakeDeployMotor;
  private static IntakeDeploy instance;
  private SparkClosedLoopController intakeDeployMotorPID;
  private SparkMaxConfig intakeDeployMotorConfig;

  public IntakeDeploy() {
    // Create motors, configuration, and PID
    intakeDeployMotor = new SparkMax(CANMapping.INTAKE_DEPLOY, MotorType.kBrushless);
    intakeDeployMotorPID = intakeDeployMotor.getClosedLoopController();
    intakeDeployMotorConfig = new SparkMaxConfig();

    // PID values
    intakeDeployMotorConfig.closedLoop
        .p(0.05)
        .i(0.0)
        .d(0.0)
        .outputRange(-0.2, 0.2);

    intakeDeployMotorConfig.closedLoopRampRate(1);

    intakeDeployMotor.configure(intakeDeployMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void resetEncoder() {
    intakeDeployMotor.getEncoder().setPosition(0);
  }

  public static IntakeDeploy getInstance() {
    if (instance == null)
      instance = new IntakeDeploy();
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("IntakePosition", getIntakePosition());
    SmartDashboard.putNumber("DeployMotorPower", intakeDeployMotor.getAppliedOutput());
  }

  public double getIntakePosition() {
    return intakeDeployMotor.getEncoder().getPosition();
  }

  // Manual command
  public void moveIntake(boolean position, Sensors sensors) {
    if (position == MiscMapping.INTAKE_OUT) {
      intakeDeployMotorPID.setSetpoint(MiscMapping.INTAKE_OUT_POSITION, ControlType.kPosition);
    } else {
      intakeDeployMotorPID.setSetpoint(MiscMapping.INTAKE_IN_POSITION, ControlType.kPosition);
    }
    sensors.setIntakePosition(position);
  }

  // // PID command
  // public void pidSetPosition(double position) {
  // intakeDeployMotorPID.setSetpoint(position, ControlType.kPosition);
  // }

  public void stop() {
    intakeDeployMotor.stopMotor();
  }
}
