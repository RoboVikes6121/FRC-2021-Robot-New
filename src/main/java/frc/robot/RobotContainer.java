/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Teleop.IntakeIn;
import frc.robot.commands.Teleop.IntakeUpDown;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.SetGyro;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //creating sub systems
  private static final DriveTrain DriveTrain = new DriveTrain();
  private static final SetGyro SetGyro = new SetGyro();
  private static final Intake Intake = new Intake();

  //creation of controllers 
  private final static XboxController mainDriveCon = new XboxController(Constants.MAINDRIVECON);
  private static JoystickButton presitionButton = new JoystickButton(mainDriveCon, XboxController.Button.kBumperLeft.value);
  private static JoystickButton intakeButton = new JoystickButton(mainDriveCon, XboxController.Button.kY.value);
  private static JoystickButton intakeUpDownButton = new JoystickButton(mainDriveCon, XboxController.Button.kA.value);

  //creating commands 
  private static IntakeIn intakeIn;
  private static IntakeUpDown intakeUpDown;
  
  public RobotContainer() {
    // finshing command setup
    intakeIn = new IntakeIn(Intake);
    intakeUpDown = new IntakeUpDown(Intake);

    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //binding a button to a command
    intakeButton.whenHeld(intakeIn);
    intakeUpDownButton.whenPressed(intakeUpDown);
  }

  // creating get methodes for subsystems
  public static DriveTrain getDriveTrain(){
    return DriveTrain;
  } 
  public static SetGyro getGyro(){
    return SetGyro;
  }
  public static Intake Intake(){
    return Intake;
  }

  // creating get methodes for buttons
  public static boolean getPresitionButton(){
    return presitionButton.get();
  } 
  public static boolean getIntake(){
    return intakeButton.get();
  }
  public static boolean getIntakeUpDown(){
    return intakeUpDownButton.get();
  }

  // creating get methodes for axis on controler One
  public static double getDriveRawAxis(int axis) {
    return mainDriveCon.getRawAxis(axis);
  }
  

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
  
}