/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class KeepCascadeUp extends Command {
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, setpoint;
  public double time = 0.1; // 0.1 seconds = 100 milliseconds 
  
  public KeepCascadeUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.liftSpark);
    //LiftSpark.leftCasMotor.follow(LiftSpark.rightCasMotor);

    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = .25; 
    kMinOutput = 0;
    setpoint = -LiftSpark.height[LiftSpark.level];

    LiftSpark.controller.setP(kP);
    LiftSpark.controller.setI(kI);
    LiftSpark.controller.setD(kD);
    LiftSpark.controller.setIZone(kIz);
    LiftSpark.controller.setFF(kFF);
    LiftSpark.controller.setOutputRange(kMinOutput, kMaxOutput);

    // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
    SmartDashboard.putNumber("Set Rotations", setpoint);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (LiftSpark.moving){return;}
    // read PID coefficients from SmartDashboard
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    double setpoint = -LiftSpark.height[LiftSpark.level];
    //double rotations = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p != kP)) { LiftSpark.controller.setP(p); kP = p; }
    if((i != kI)) { LiftSpark.controller.setI(i); kI = i; }
    if((d != kD)) { LiftSpark.controller.setD(d); kD = d; }
    if((iz != kIz)) { LiftSpark.controller.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { LiftSpark.controller.setFF(ff); kFF = ff; }
    
    /*if((max != kMaxOutput) || (min != kMinOutput)) { 
      LiftSpark.controller.setOutputRange(min, max); 
      kMinOutput = min; kMaxOutput = max; 
    }*/

    /**
     * PIDController objects are commanded to a set point using the 
     * SetReference() method.
     * 
     * The first parameter is the value of the set point, whose units vary
     * depending on the control type set in the second parameter.
     * 
     * The second parameter is the control type can be set to one of four 
     * parameters:
     *  com.revrobotics.ControlType.kDutyCycle
     *  com.revrobotics.ControlType.kPosition
     *  com.revrobotics.ControlType.kVelocity
     *  com.revrobotics.ControlType.kVoltage
     */
    LiftSpark.controller.setReference(setpoint, ControlType.kPosition);
    
    SmartDashboard.putNumber("SetPoint", setpoint);
    SmartDashboard.putNumber("ProcessVariable", -LiftSpark.rightLiftHall.getPosition());

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
