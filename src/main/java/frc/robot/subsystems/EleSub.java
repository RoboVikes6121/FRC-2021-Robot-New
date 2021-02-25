// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;

public class EleSub extends SubsystemBase {
  private static WPI_VictorSPX elevator = new WPI_VictorSPX(Constants.ELEVATOR);
  /** Creates a new EleSub. */
  public EleSub() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void elevate(){
    elevator.set(0.8);
  }
  public void stop(){
    elevator.set(0);
  }
}
