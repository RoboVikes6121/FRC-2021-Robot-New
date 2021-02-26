// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

public class KickSub extends SubsystemBase {
  private static DoubleSolenoid kicker = new DoubleSolenoid(Constants.KICKERIN,Constants.KICKEROUT);
  //Creates a new KickSub.
  public KickSub() {}

  @Override
  public void periodic() {
    //This method will be called once per scheduler run
  }
  public void kick(){
    kicker.set(DoubleSolenoid.Value.kForward);
    Timer.delay(1.0);
    kicker.set(DoubleSolenoid.Value.kReverse);
  }
}
