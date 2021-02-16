/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TurnAuton extends CommandBase {

  private DriveTrain m_DriveTrain;
  boolean isDone;
  double angle;

  // sets up command
  public TurnAuton(DriveTrain driveTrain, double angle) {
    m_DriveTrain = driveTrain;
    addRequirements(m_DriveTrain);

    this.angle = angle;
    isDone = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_DriveTrain.turnAuton(angle);
    if(RobotContainer.getGyro().getAngle() >= angle-0.5 && RobotContainer.getGyro().getAngle() <= angle+0.5) isDone = true;
    System.out.println("ISDONE= "+ isDone);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.end();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isDone;
  }
}
