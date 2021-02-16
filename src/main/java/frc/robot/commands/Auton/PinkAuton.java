/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PinkAuton extends SequentialCommandGroup {
  /**
   * Creates a new PinkAuton.
   */
  public PinkAuton(DriveTrain m_driveTrain) {
    
    super(
      
     // new MoveAuton(m_driveTrain, .5, 48)
      new TurnAuton(m_driveTrain, 90)
    );
  }
}
