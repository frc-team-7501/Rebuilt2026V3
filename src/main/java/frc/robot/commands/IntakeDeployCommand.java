// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.accessories.IntakeDeploy;
import frc.robot.subsystems.accessories.Sensors;

public class IntakeDeployCommand extends Command {
  /** Creates a new LiftControlCommand. */
  private final IntakeDeploy intakeDeploy;
  private final boolean position;
  private Sensors sensors;

  public IntakeDeployCommand(IntakeDeploy intakeDeploy, boolean position, Sensors sensors) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeDeploy = intakeDeploy;
    this.position = position;
    this.sensors = sensors;
    addRequirements(intakeDeploy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeDeploy.moveIntake(position, sensors);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeDeploy.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}