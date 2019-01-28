/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Practice extends Subsystem {
 public static TalonSRX frontRight = new TalonSRX(RobotMap.talonPort1);
 public static TalonSRX frontLeft = new TalonSRX(RobotMap.talonPort2);
 public static TalonSRX rearRight = new TalonSRX(RobotMap.talonPort3);
 public static TalonSRX rearLeft = new TalonSRX(RobotMap.talonPort4);

 public static Joystick joy = new Joystick(RobotMap.joyPort1);

 public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

 public static void driveTeleop() {
   double rightJoy = joy.getRawAxis (1);
   double leftJoy = joy.getRawAxis (2);

   frontRight.set(ControlMode.PercentOutput, rightJoy);
   frontLeft.set(ControlMode.PercentOutput, leftJoy);
   rearRight.set(ControlMode.PercentOutput, rightJoy);
   rearLeft.set(ControlMode.PercentOutput, leftJoy);
 }
 public static void driveAuton(double rightSpeed, double leftSpeed){
   frontRight.set(ControlMode.PercentOutput, rightSpeed);
   rearRight.set(ControlMode.PercentOutput,  rightSpeed);
   frontLeft.set(ControlMode.PercentOutput, leftSpeed);
   rearLeft.set(ControlMode.PercentOutput, leftSpeed);
 }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
