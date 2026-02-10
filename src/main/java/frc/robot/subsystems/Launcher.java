// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANMapping;

public class Launcher extends SubsystemBase {
  private final SparkMax launcherMotorL;
  private final SparkMax launcherMotorR;
  private static Launcher instance;
  private SparkClosedLoopController launcherMotorLPID;
  private SparkMaxConfig launcherMotorLConfig;
  private SparkMaxConfig launcherMotorRConfig;

  /** Creates a new Launcher. */
  public Launcher() {
        // Create motors, configuration, and PID
    launcherMotorL = new SparkMax(CANMapping.LAUNCHER_DRIVE_L, MotorType.kBrushless);
    launcherMotorR = new SparkMax(CANMapping.LAUNCHER_DRIVE_R, MotorType.kBrushless);
    launcherMotorLPID = launcherMotorL.getClosedLoopController();
    launcherMotorLConfig = new SparkMaxConfig();
    launcherMotorRConfig = new SparkMaxConfig();

    // PID values
    launcherMotorLConfig.closedLoop
        .p(0.0)
        .i(0.0)
        .d(0.0)
        .outputRange(-1, 1)
        .feedForward.kV(565);

    launcherMotorL.configure(launcherMotorLConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    // Top motor follows the bottom motor.
    launcherMotorRConfig.follow(launcherMotorL.getDeviceId(), true);
    launcherMotorR.configure(launcherMotorRConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public static Launcher getInstance() {
    if (instance == null)
      instance = new Launcher();
    return instance;
  }

  public void RunLauncher(double velocity) {
    launcherMotorL.set(velocity);
  }

  public void pidSetVelocity(double velocity) {
    launcherMotorLPID.setSetpoint(velocity, ControlType.kVelocity);
  }

  public void stop() {
    launcherMotorL.setVoltage(0);
    launcherMotorR.setVoltage(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
