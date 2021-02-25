/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Teleop.Kick;
import frc.robot.commands.Teleop.Shoot;
import frc.robot.commands.Teleop.Feed;
import frc.robot.commands.Teleop.Elevator;
import frc.robot.commands.Teleop.Intack;
import frc.robot.commands.Teleop.IntakeUpDown;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.EleSub;
import frc.robot.subsystems.SetGyro;
import frc.robot.subsystems.AssemblyLine;
import frc.robot.subsystems.FeedSub;
import frc.robot.subsystems.Intake;
//import frc.robot.subsystems.KickSub;

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
  private static final FeedSub FeedSub = new FeedSub();
//  private static final KickSub KickSub = new KickSub();
  private static final EleSub EleSub = new EleSub();
  private static final Intake Intake = new Intake();

  //creation of controllers 
  private static final XboxController mainDriveCon = new XboxController(Constants.MAINDRIVECON);
  private static final Joystick mainOperCon = new Joystick(Constants.MAINOPERCON);
  private static JoystickButton presitionButton = new JoystickButton(mainDriveCon, XboxController.Button.kBumperLeft.value);
  private static JoystickButton shootButton = new JoystickButton(mainOperCon, 5);
  private static JoystickButton feedButton = new JoystickButton(mainOperCon, 7);
//  private static JoystickButton kickButton = new JoystickButton(mainOperCon, 1);
  private static JoystickButton elevatorButton = new JoystickButton(mainOperCon, 6);
  private static JoystickButton intakeButton = new JoystickButton(mainOperCon, 2);
  private static JoystickButton intakeUpDownButton = new JoystickButton(mainOperCon, 8);

  //creating commands 
  private static Shoot shoot;
  private static Feed  feed;
//  private static Kick  kick;
  private static Elevator elevator;
  private static Intack intack;
  private static IntakeUpDown intakeUpDown;
  
  public RobotContainer() {
    // finshing command setup
    shoot = new Shoot(AssemblyLine);
  //  kick = new Kick(AssemblyLine);
    feed = new Feed(FeedSub);
    elevator = new Elevator(AssemblyLine);
    intack = new Intack(Intake);
    intakeUpDown = new IntakeUpDown(Intake);

    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //binding a button to a command
    shootButton.whenPressed(shoot);
    feedButton.whenHeld(feed);
  //  kickButton.whenPressed(kick);
    elevatorButton.whenPressed(elevator);
    intakeButton.whenHeld(intack);
    intakeUpDownButton.whenPressed(intakeUpDown);
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
  public static FeedSub getFeedSub(){
    return FeedSub;
  }
  /*public static KickSub getKickSub(){
    return KickSub;
  }*/
  public static EleSub getEleSub(){
    return EleSub;
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
  /*public static boolean getKickButon(){
    return kickButton.get();
  }*/
  public static boolean getElevatorButton(){
    return elevatorButton.get();
  }
  public static boolean getIntakeButton(){
    return intakeButton.get();
  }
  public static boolean getIntakeUpDownButton(){
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
   
