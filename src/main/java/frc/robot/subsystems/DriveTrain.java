/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Teleop.DriveTele;

public class DriveTrain extends SubsystemBase {

  private static WPI_TalonSRX leftmaster = new WPI_TalonSRX(Constants.LEFTMASTER);
  private static WPI_TalonSRX leftslave = new WPI_TalonSRX(Constants.LEFTSLAVE);
  private static WPI_TalonSRX rightmaster = new WPI_TalonSRX(Constants.RIGHTMASTER);
  private static WPI_TalonSRX rightslave = new WPI_TalonSRX(Constants.RIGHTSLAVE);

  DifferentialDrive drive = new DifferentialDrive(leftmaster, rightmaster);

  public DriveTrain() {
    // set to follow
    leftslave.follow(leftmaster);
    rightslave.follow(rightmaster);

    // set amp limiters
    leftmaster.configPeakCurrentLimit(40);
    leftslave.configPeakCurrentLimit(40);
    rightmaster.configPeakCurrentLimit(40);
    rightslave.configPeakCurrentLimit(40);

  }

  public static double[] GetEncoder() {
    double[] ENCODER_LIST = new double[6];
    ENCODER_LIST[0] = DriveTrain.leftmaster.getSelectedSensorVelocity();
    ENCODER_LIST[1] = DriveTrain.leftmaster.getSelectedSensorPosition();
    ENCODER_LIST[2] = DriveTrain.rightmaster.getSelectedSensorVelocity();
    ENCODER_LIST[3] = DriveTrain.rightmaster.getSelectedSensorPosition();
    return ENCODER_LIST;
  }

  // teleop
  public void driveManuale() {
    double move = RobotContainer.getDriveRawAxis(Constants.LEFTSTICKY);
    double turn = RobotContainer.getDriveRawAxis(Constants.RIGHTSTICKX);
    boolean presition = RobotContainer.getPresitionButton();

    if (presition == false) {
      if (move > Constants.MAXSPEED)
        move = Constants.MAXSPEED;
      if (move < -Constants.MAXSPEED)
        move = -Constants.MAXSPEED;
      if (turn > Constants.MAXSPEED-.2)
        turn = Constants.MAXSPEED-.2;
      if (turn < -Constants.MAXSPEED-.2)
        turn = -Constants.MAXSPEED-.2;
    } else {
      move = move / 2;
      turn = turn / 2;
      if (move > Constants.MAXPRSPEED)
        move = Constants.MAXPRSPEED;
      if (move < -Constants.MAXPRSPEED)
        move = -Constants.MAXPRSPEED;
      if (turn > Constants.MAXPRSPEED-.2)
        turn = Constants.MAXPRSPEED-.2;
      if (turn < -Constants.MAXPRSPEED-.2)
        turn = -Constants.MAXPRSPEED-.2;
    }

    drive.arcadeDrive(-move, turn);
  }

  // drives strait at a set speed in auton called
  public void driveAuton(double speed) {
    double move = speed;
    double turn = 0;

    if (move > Constants.MAXSPEED)
      move = Constants.MAXSPEED;
    if (move < -Constants.MAXSPEED)
      move = -Constants.MAXSPEED;

    if (Math.abs(RobotContainer.getGyro().getAngle()) > 0) {
      turn = RobotContainer.getGyro().getAngle() * Constants.DRIVEP;
      if (turn > Constants.MAXPRSPEED)
        turn = Constants.MAXPRSPEED;
      if (turn < -Constants.MAXPRSPEED)
        turn = -Constants.MAXPRSPEED;
    }
    drive.arcadeDrive(move, turn);
  }

  // turn a set amount in auton when called
  public void turnAuton(double angle) {
    double error = angle - RobotContainer.getGyro().getAngle();
    double turn = error * Constants.DRIVEP;
    //boolean running = true;
    if (Math.abs(error) <= 20) {
      /*if (Math.abs(error) <= 1) {
        turn = turn / 3;
        //running = false;
      }*/
      //turn = turn / 2;
    }

    if (turn > Constants.MAXPRSPEED)
      turn = Constants.MAXPRSPEED;
    if (turn < -Constants.MAXPRSPEED)
      turn = -Constants.MAXPRSPEED;

    drive.arcadeDrive(0, -turn);
    // drive.arcadeDrive(.5, -turn);
    /*
    if(running){drive.tankDrive(-.5, .5);
    }else{}
    */
  }


  public void end() {
    leftmaster.set(0);
    rightmaster.set(0);
  }

  // set motors to coast mode
  public void setCoastMode() {
    leftmaster.setNeutralMode(NeutralMode.Coast);
    leftslave.setNeutralMode(NeutralMode.Coast);
    rightmaster.setNeutralMode(NeutralMode.Coast);
    leftmaster.setNeutralMode(NeutralMode.Coast);
  }

  // set motors to brack mode
  public void setBrakeMode() {
    leftmaster.setNeutralMode(NeutralMode.Brake);
    leftslave.setNeutralMode(NeutralMode.Brake);
    rightmaster.setNeutralMode(NeutralMode.Brake);
    leftmaster.setNeutralMode(NeutralMode.Brake);
  }

  // getting encoder avrage vol (left+right)/2
  public double getAvrageVol() {
    return (leftmaster.getSelectedSensorVelocity() + rightmaster.getSelectedSensorVelocity()) / 2;
  }

  // getting encoder avrage pos (left+right)/2
  public double getAvragePos() {
    return (Math.abs(leftmaster.getSelectedSensorPosition()) + Math.abs(rightmaster.getSelectedSensorPosition())) / 2;
  }

  // reseting the encoders
  public void resetEncoders() {
    leftmaster.setSelectedSensorPosition(0, 0, 10);
    rightmaster.setSelectedSensorPosition(0, 0, 10);
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic() {
    setDefaultCommand(new DriveTele(RobotContainer.getDriveTrain()));
  }
}
