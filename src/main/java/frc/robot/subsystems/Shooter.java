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

public class Shooter extends SubsystemBase {
  private static WPI_VictorSPX elevator = new WPI_VictorSPX(Constants.ELEVATOR);
  private static WPI_VictorSPX feeder = new WPI_VictorSPX(Constants.FEEDER);
  private static TalonSRX shooter = new TalonSRX(Constants.FALCON);

  private static DoubleSolenoid kicker = new DoubleSolenoid(Constants.KICKERIN,Constants.KICKEROUT);

  /** Creates a new Shooter. */
  public Shooter() {
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
    System.out.println("ON");
    shooter.set(ControlMode.PercentOutput, 0.50);
    // elevator.set(0.75);
  }
  public void end(){ //off
    System.out.println("OFF");
    shooter.set(ControlMode.PercentOutput, 0);
    // elevator.set(0);
  }
  public void kick(){
    kicker.set(DoubleSolenoid.Value.kForward);
    Timer.delay(1.0);
    kicker.set(DoubleSolenoid.Value.kReverse);
  }

  public void feeder(){
    feeder.set(0.5);
    Timer.delay(0.3);
    feeder.set(0);
  }
}
