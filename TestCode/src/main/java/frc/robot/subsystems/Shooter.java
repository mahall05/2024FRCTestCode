// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private PWMSparkMax topFront;
  private PWMSparkMax topBack;
  private PWMSparkMax bottomFront;
  private PWMSparkMax bottomBack;

  private final int topFrontPWM = 1;
  private final int topBackPWM = 2;
  private final int bottomFrontPWM = 0;
  private final int bottomBackPWM = 3;

  private double topFrontSpeed = 0.0;
  private double topBackSpeed = 0.0;
  private double bottomFrontSpeed = 0.0;
  private double bottomBackSpeed = 0.0;

  /** Creates a new Shooter. */
  public Shooter() {
    topFront = new PWMSparkMax(topFrontPWM);
    topBack = new PWMSparkMax(topBackPWM);
    bottomFront = new PWMSparkMax(bottomFrontPWM);
    bottomBack = new PWMSparkMax(bottomBackPWM);
  }

  public void setShootSpeed(double speed){
    topBackSpeed = -speed;
    bottomBackSpeed = speed;
  }
  public void setTopFrontSpeed(double speed){
    topFrontSpeed = speed;
  }
  public void setBottomFrontSpeed(double speed){
    bottomFrontSpeed = -speed;
  }
  public void setAll(double speed){
    setShootSpeed(speed);
    setTopFrontSpeed(speed);
    setBottomFrontSpeed(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    topFront.set(topFrontSpeed);
    topBack.set(topBackSpeed);
    bottomFront.set(bottomFrontSpeed);
    bottomBack.set(bottomBackSpeed);
  }
}
