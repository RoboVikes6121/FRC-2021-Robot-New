/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Auton.MoveAuton;
import frc.robot.commands.Auton.PinkAuton;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  //When robot starts will run
  @Override
  public void robotInit() {
    //creating a RobotContaner so that it can be called 
    m_robotContainer = new RobotContainer();
    
    //reset encoders
    m_robotContainer.getDriveTrain().resetEncoders();

    //Creating cam 1 
    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
    camera1.setResolution(360, 240);
    //creating cam 2
    UsbCamera camera2 =CameraServer.getInstance().startAutomaticCapture();
    camera2.setResolution(360, 240);
  }

  // Runs the Scheduler  (will run over and over when the robot is on)
  @Override
  public void robotPeriodic() {
    //running the schedel
    CommandScheduler.getInstance().run();
  }

  //called once each time the robot enters Disabled mode.
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  //set up auton
  @Override
  public void autonomousInit() {
    RobotContainer.getDriveTrain().setBrakeMode();
    m_robotContainer.getDriveTrain().resetEncoders();
    
    m_robotContainer.getGyro().reset();

    m_autonomousCommand = new PinkAuton(RobotContainer.getDriveTrain());

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  //called periodically during auton
  @Override
  public void autonomousPeriodic() {}

  //set up teleop
  @Override
  public void teleopInit() {
    m_robotContainer.getDriveTrain().setCoastMode();
    m_robotContainer.getGyro().reset();

    m_robotContainer.getDriveTrain().resetEncoders();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  //called periodically during teleop
  @Override
  public void teleopPeriodic() {
  }

  //set up test 
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  //called periodically during test mode
  @Override
  public void testPeriodic() {}
}
