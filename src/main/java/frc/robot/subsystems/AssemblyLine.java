// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AssemblyLine extends SubsystemBase {
  private static WPI_VictorSPX elevator = new WPI_VictorSPX(Constants.ELEVATOR);
  private static WPI_VictorSPX feeder = new WPI_VictorSPX(Constants.FEEDER);
  private static TalonSRX shooter = new TalonSRX(Constants.FALCON);
  private static DoubleSolenoid kicker = new DoubleSolenoid(Constants.KICKERIN,Constants.KICKEROUT);

  /** Creates a new shooter. */
  public void shooter() {
  shooter.configPeakCurrentLimit(40);
  shooter.setNeutralMode(NeutralMode.Coast);
  shooter.configFactoryDefault();
  shooter.setInverted(false);
  shooter.setSensorPhase(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
  }


  public void start(){ //on
    shooter.set(ControlMode.PercentOutput, 0.50);
  }
  public void end(){ //off
    shooter.set(ControlMode.PercentOutput, 0);
  }

  public void kick(){
    kicker.set(DoubleSolenoid.Value.kForward);
    Timer.delay(1.0);
    kicker.set(DoubleSolenoid.Value.kReverse);
  }

  public void feed(){
    feeder.set(-0.18);
  }
  
  public void fed(){
    feeder.set(0);
  }

  public void elevate(){
    elevator.set(0.8);
  }
  public void stop(){
    elevator.set(0);
  }

}
