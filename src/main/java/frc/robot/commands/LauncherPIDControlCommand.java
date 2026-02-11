// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.accessories.Launcher;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class LauncherPIDControlCommand extends Command {
  /** Creates a new LauncherPIDControlCommand. */
  private final Launcher launcher;
  private double velocity;
  
  public LauncherPIDControlCommand(Launcher launcher, double velocity) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.launcher = launcher;
    this.velocity = velocity;
    addRequirements(launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (velocity != 0) {
      launcher.pidSetVelocity(velocity);
    } else {
      launcher.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launcher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
