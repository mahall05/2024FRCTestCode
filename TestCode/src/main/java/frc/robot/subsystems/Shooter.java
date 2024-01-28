// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/* TODO INSTRUCTIONS
 * Before doing anything, check which ports the motors, and enter those into the correct spots
 * under MOTOR PORTS so the code knows what each motor is.
 * 
 * Start by trying to run the shooter at a very slow speed (see ShooterCommand.java). If all motors are
 * running in the correct direction to fire, nothing needs to change. If one or more needs to be flipped,
 * do so under MOTOR SPEED SETTING. Each speed is labelled. To flip one, either add or remove a negative
 * before the name of the speed (e.g. topBackSpeed -> -topBackSpeed)
 */

public class Shooter extends SubsystemBase {
  /* MOTORS */
  private PWMSparkMax topFront;
  private PWMSparkMax topBack;
  private PWMSparkMax bottomFront;
  private PWMSparkMax bottomBack;

  /* MOTOR PORTS */
  // TODO
  private final int topFrontPWM = 0;
  private final int topBackPWM = 0;
  private final int bottomFrontPWM = 0;
  private final int bottomBackPWM = 0;

  /* SPEED VARIABLES */
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

  /* MOTOR SPEED SETTING */
  public void setShootSpeed(double speed){
    // TODO flip one of these if needed
    topBackSpeed = -speed;
    bottomBackSpeed = speed;
  }
  public void setTopFrontSpeed(double speed){
    // TODO flip this if needed
    topFrontSpeed = speed;
  }
  public void setBottomFrontSpeed(double speed){
    // TODO flip this if needed
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
