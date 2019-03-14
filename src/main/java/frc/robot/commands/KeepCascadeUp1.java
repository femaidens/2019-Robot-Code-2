/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LiftSpark;

public class KeepCascadeUp1 extends Command {
  public final static double Kp = 0.01;
  public final static double Ki = 0.0;
  public final static double Kd = 0.0;
  //public double distance, left_speed, right_speed;
  public double left_speed, right_speed;
  static double min_error = 0.1; //sets an error deadband/ minimum value
  static double min_command = 0.0;
  static double current_error = 0; 
  static double previous_error = 0;
  static double integral = 0;
  static double derivative = 0;
  static double adjust = 0;
  static double time = 0.1; // 0.1 seconds = 100 milliseconds 
  static double setpoint = -LiftSpark.height[LiftSpark.level];
  
  public KeepCascadeUp1() {
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
    previous_error = current_error;
    current_error = (-LiftSpark.rightLiftHall.getPosition())- setpoint;
    integral = (current_error+previous_error)/2*(time);
    derivative = (current_error-previous_error)/time;
    adjust = Kp*current_error + Ki*integral + Kd*derivative;

    if (current_error > min_error) adjust += min_command;
    else if (current_error < -min_error) adjust -= min_command;

    
    //DriveTrain.driveAuton(left_speed + adjust, right_speed - adjust);

    try {
      Thread.sleep((long)(time*1000));
    } catch(InterruptedException e){
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
