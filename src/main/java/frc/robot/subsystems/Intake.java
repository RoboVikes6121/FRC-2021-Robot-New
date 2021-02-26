// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private static WPI_VictorSPX intack = new WPI_VictorSPX(Constants.INTACK);
  private static DoubleSolenoid intakeDoubleSolenoid = new DoubleSolenoid(Constants.INTAKE1,Constants.INTAKE2);
  public Intake() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void nom(){
    intack.set(-.75);
  }

  public void wom(){
    intack.set(0);
  }

  public void sol() {
    if(intakeDoubleSolenoid.get().equals(DoubleSolenoid.Value.kReverse)){
      intakeDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }else{
      intakeDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
