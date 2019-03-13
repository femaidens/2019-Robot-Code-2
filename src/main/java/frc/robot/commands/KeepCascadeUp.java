package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;

public class KeepCascadeUp extends Command {
  public static final double Kp = 0.1;
  public static final double Ki = 0;
  public static final double Kd = 0;
  
  static double min_error = 0.1;
  static double min_command = 0.0;
  static double set;
  private double current_error =0;
  private double previous_error;
  private double integral;
  private double derivative;
  private double adjust;
  static double time = 0.1;

  public KeepCascadeUp() {}
    /*
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.liftSpark);
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    set = LiftSpark.height[level];
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (!LiftSpark.moving){
      previous_error = current_error;
      //current_error = 
    }
  }
*/
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