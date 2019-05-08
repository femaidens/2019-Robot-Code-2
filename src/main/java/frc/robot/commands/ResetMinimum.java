/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ResetMinimum extends Command {
  public ResetMinimum() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  /*
    LiftSpark.leftLiftHall.setPosition(0.0);
    LiftSpark.rightLiftHall.setPosition(0.0);
    Lift.initial = Lift.frontHall.getPosition();
    Lift.initial2 = Lift.rearHall.getPosition();
    
    SmartDashboard.putNumber("Initial Lift", Robot.lift.initial);
    SmartDashboard.putNumber("Initial2 Lift", Robot.lift.initial2);
    SmartDashboard.putString("Print statements", "reset lift hall sensors");

    LiftSpark.level = 0;
    LiftSpark.initposition = Math.min(LiftSpark.leftLiftHall.getPosition(), LiftSpark.rightLiftHall.getPosition());
    LiftSpark.height = new double[] {
      LiftSpark.initposition, //starting position
      //6 + LiftSpark.initposition, //hatch 1 position
      19 + LiftSpark.initposition, //cargo 1 position
      35 + LiftSpark.initposition, //cargo ship cargo position
      28 + LiftSpark.initposition, //hatch 2 position
      49 + LiftSpark.initposition, //cargo 2 position
      50 + LiftSpark.initposition, //hatch 3 position
      69 + LiftSpark.initposition, //cargo 3 position
      71 + LiftSpark.initposition}; //MAX
    LiftSpark.maxposition = 71+LiftSpark.initposition;  
    Lift.height = LiftSpark.height;
    
    //LiftSpark.downToZero();
    SmartDashboard.putNumber("Initial Lift", LiftSpark.initposition);
    SmartDashboard.putString("Print statements", "reset lift hall sensors");
    */ }
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
