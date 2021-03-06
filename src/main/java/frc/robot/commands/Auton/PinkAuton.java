/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PinkAuton extends SequentialCommandGroup {
  /**
   * Creates a new PinkAuton.
   */
  //angle positive = left
  //angle negative = right
  public PinkAuton(DriveTrain m_driveTrain) {
    addCommands(new MoveAuton(m_driveTrain, .5, 7));
    addCommands(new TurnAuton(m_driveTrain, 45));
    addCommands(new MoveAuton(m_driveTrain, .5, 39));
    addCommands(new TurnAuton(m_driveTrain, -42));
    addCommands(new MoveAuton(m_driveTrain, .5, 63));
    addCommands(new TurnAuton(m_driveTrain, -45));
    addCommands(new MoveAuton(m_driveTrain, .5, 39));
    addCommands(new TurnAuton(m_driveTrain, 45));
    addCommands(new MoveAuton(m_driveTrain, .5, 11));
    addCommands(new TurnAuton(m_driveTrain, 90));
    addCommands(new MoveAuton(m_driveTrain, .5, 30));//halfway
    addCommands(new TurnAuton(m_driveTrain, 90));
    /*addCommands(new MoveAuton(m_driveTrain, .5, 30));
    addCommands(new TurnAuton(m_driveTrain, 90));
    addCommands(new MoveAuton(m_driveTrain, .5, 35));
    addCommands(new TurnAuton(m_driveTrain, -90));
    addCommands(new MoveAuton(m_driveTrain, .5, 90));
    addCommands(new TurnAuton(m_driveTrain, -90));
    addCommands(new MoveAuton(m_driveTrain, .5, 30));
    addCommands(new TurnAuton(m_driveTrain, 90));
    addCommands(new MoveAuton(m_driveTrain, .5, 30));*/
    }
}
