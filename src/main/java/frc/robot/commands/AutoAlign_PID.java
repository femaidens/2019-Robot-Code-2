/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.command.Command;

public class AutoAlign_PID extends Command {
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
  
  public AutoAlign_PID() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    left_speed = frc.robot.OI.atkJoy1.getRawAxis(1);
    right_speed = frc.robot.OI.atkJoy1.getRawAxis(5);
  }

  public AutoAlign_PID(double l, double r){
    left_speed = l;
    right_speed = r;
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Limelight.setLiveStream(0);
    Limelight.setLEDMode(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("holy shit");
    //Robot.drivetrain.turnDegrees(Robot.limelight.getTx());
    if (!Limelight.objectSighted()) return;

    previous_error = current_error;
    current_error = Limelight.getTx();
    integral = (current_error+previous_error)/2*(time);
    derivative = (current_error-previous_error)/time;
    adjust = Kp*current_error + Ki*integral + Kd*derivative;

    if (current_error > min_error) adjust += min_command;
    else if (current_error < -min_error) adjust -= min_command;

    
    DriveTrain.driveAuton(left_speed + adjust, right_speed - adjust);

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
