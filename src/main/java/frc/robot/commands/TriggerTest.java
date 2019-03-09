/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class TriggerTest extends Command {
  public TriggerTest() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.test);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }
/*
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(OI.atkJoy1.getRawAxis(2) ==  1 && Test.trigBol){
      System.out.println("HIIIIIIIII");
      Test.trigBol = false;
    }
    else if(OI.atkJoy1.getRawAxis(2) < 0.5 && Test.trigBol == false){
      Test.trigBol = true;
    }
    
    if(OI.atkJoy1.getPOV(0) == 0 && Test.povBol1){
      System.out.println("WEEEEEEEEEEEEEEE");
      Test.povBol1 = false;
    }else if(OI.atkJoy1.getPOV(0) == 180 && Test.povBol2){
      System.out.println("WOOOOOOOOOOOOOOO");
      Test.povBol2 = false;
    }else if(OI.atkJoy1.getPOV(0) == -1){
      Test.povBol1 = true;
      Test.povBol2 = true;
    }
  }
  */ 
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
