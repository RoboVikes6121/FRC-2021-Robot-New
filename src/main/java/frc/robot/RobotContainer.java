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
import frc.robot.commands.Teleop.Kick;
import frc.robot.commands.Teleop.Shoot;
import frc.robot.commands.Teleop.Kick;
import frc.robot.commands.Teleop.Feed;
//import frc.robot.commands.Teleop.Elevator;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SetGyro;
import frc.robot.subsystems.AssemblyLine;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //creating sub systems
  private static final DriveTrain driveTrain = new DriveTrain();
  private static final SetGyro setGyro = new SetGyro();
  private static final AssemblyLine AssemblyLine = new AssemblyLine();

  //creation of controllers 
  private static final XboxController mainDriveCon = new XboxController(Constants.MAINDRIVECON);
  private static JoystickButton presitionButton = new JoystickButton(mainDriveCon, XboxController.Button.kBumperLeft.value);
  private static JoystickButton shootButton = new JoystickButton(mainDriveCon, XboxController.Button.kX.value);
  private static JoystickButton feedButton = new JoystickButton(mainDriveCon, XboxController.Button.kB.value);
  private static JoystickButton kickButton = new JoystickButton(mainDriveCon, XboxController.Button.kY.value);
  private static JoystickButton elevatorButton = new JoystickButton(mainDriveCon, XboxController.Button.kA.value);

  //creating commands 
  private static Shoot shoot;
  private static Feed  feed;
  private static Kick  kick;
  //private static Elevator elevator;
  
  public RobotContainer() {
    // finshing command setup
    shoot = new Shoot(AssemblyLine);
    kick = new Kick(AssemblyLine);
    feed = new Feed(AssemblyLine);
    //elevator = new Elevator(AssemblyLine);

    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //binding a button to a command
    shootButton.whenHeld(shoot);
    feedButton.whenHeld(feed);
    kickButton.whenPressed(kick);
    //elevatorButton.whenHeld(elevator);


  }

  // creating get methodes for subsystems
  public static DriveTrain getDriveTrain(){
    return driveTrain;
  } 
  public static SetGyro getGyro(){
    return setGyro;
  }
  public static AssemblyLine getAssemblyLine(){
    return AssemblyLine;

  }

  // creating get methodes for buttons
  public static boolean getPresitionButton(){
    return presitionButton.get();
  } 
  public static boolean getShootButton(){
    return shootButton.get();
  }
  public static boolean getFeedButton(){
    return feedButton.get();
  }
  public static boolean getKickButon(){
    return kickButton.get();
  }
  public static boolean getElevatorButton(){
    return elevatorButton.get();
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
   
