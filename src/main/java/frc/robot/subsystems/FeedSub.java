// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class FeedSub extends SubsystemBase {
  private static WPI_VictorSPX feeder = new WPI_VictorSPX(Constants.FEEDER);
  /** Creates a new FeedSub. */
  public FeedSub() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void feed(){
    feeder.set(-0.18);
  }
  public void fed(){
    feeder.set(0);
  }
}
