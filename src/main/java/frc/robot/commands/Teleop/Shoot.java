/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {

  private Shooter m_Shooter;

  // sets up command
  public Shoot(Shooter shooter) {
    m_Shooter = shooter;
    addRequirements(m_Shooter);
  }

  // Called when the command is initially scheduled.
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    m_Shooter.start();
    System.out.println("SHOOT");
  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
    m_Shooter.end();
    System.out.println("END");
  }

  // Returns true when the command should end.
  public boolean isFinished() {
    return false;
  }
}
