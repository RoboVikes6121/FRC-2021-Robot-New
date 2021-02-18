// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private static WPI_VictorSPX intake = new WPI_VictorSPX(Constants.INTAKE);
  private static DoubleSolenoid intakeDoubleSolenoid = new DoubleSolenoid(Constants.INTAKE1,Constants.INTAKE2);
  public Intake() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void start(){
    intake.set(.75);
  }

  public void end(){
    intake.set(0);
  }

  public void sol() {
    if(intakeDoubleSolenoid.get() == DoubleSolenoid.Value.kReverse){
      intakeDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }else{
      intakeDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
