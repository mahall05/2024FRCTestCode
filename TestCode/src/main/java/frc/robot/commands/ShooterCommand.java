// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.subsystems.Shooter;

/* TODO INSTRUCTIONS
 * 
 * There is only one thing to be changed here. You will need to adjust the shooter
 * speeds to actually be able to shoot. Right now they're both set to 30%, so that it's
 * not super violent at the start
 */
public class ShooterCommand extends Command {
  private Shooter shooter;
  private CommandPS4Controller controller;

  /* SHOOTER SPEEDS */
  private final double ejectSpeed = 0.3;
  private final double shootSpeed = 0.3;

  /** Creates a new ShooterDefault. */
  public ShooterCommand(Shooter shooter, CommandPS4Controller controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    this.controller = controller;
    
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(controller.cross().getAsBoolean()){
      shooter.setShootSpeed(ejectSpeed);
      shooter.setTopFrontSpeed(ejectSpeed);
      shooter.setBottomFrontSpeed(-ejectSpeed);
    }
    else if(controller.triangle().getAsBoolean()){
      shooter.setShootSpeed(ejectSpeed);
      shooter.setTopFrontSpeed(-ejectSpeed);
      shooter.setBottomFrontSpeed(ejectSpeed);
    }
    else if(controller.square().getAsBoolean()){
      shooter.setAll(shootSpeed);
    }
    else{
      shooter.setAll(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
