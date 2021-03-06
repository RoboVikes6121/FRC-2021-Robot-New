/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AssemblyLine;

public class Shoot extends CommandBase {

  //private boolean isRunning= false;

  private AssemblyLine m_AssemblyLine;

  // sets up command
  public Shoot(AssemblyLine AssemblyLine) {
    m_AssemblyLine = AssemblyLine;
    addRequirements(m_AssemblyLine);
  }

  // Called when the command is initially scheduled.
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    m_AssemblyLine.start();
  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }
}
