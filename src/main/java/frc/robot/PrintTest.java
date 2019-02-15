/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrintTest extends Command {
  public PrintTest() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.drivetrain);
  }
/*
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }
//
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    System.out.println("velovity front:\t"+ DriveTrain.frontRightHall.getVelocity()+"\t"+DriveTrain.frontLeftHall.getVelocity()+"\n");
    //System.out.println("velovity back:\t"+ DriveTrain.rearRightHall.getVelocity()+"\t"+DriveTrain.rearLeftHall.getVelocity()+"\n");
    System.out.println("position:\t"+DriveTrain.frontRightHall.getPosition() + "\t" + DriveTrain.frontLeftHall.getPosition() + "\n");
    System.out.println("timer:\t"+Robot.timer.get()+"\n");
  }
*/
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }
/*
  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }*/
}
