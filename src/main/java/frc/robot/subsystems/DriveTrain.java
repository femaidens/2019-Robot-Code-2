/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;

//import org.graalvm.compiler.nodes.calc.RightShiftNode;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class DriveTrain extends Subsystem {

  public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);//12
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);//1
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);//14
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);//4
  public static CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);//2
  public static CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);//11

  public int currentLimit = 40;
  public static double minOutput = 0.1;
  public static double midOuput = 0.15;
  public static double beforeLeftVel = 0;
  public static double beforeRightVel = 0;
  public static Timer timerLeft = new Timer();
  public static Timer timerRight = new Timer();
  
  public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static CANEncoder frontRightHall = frontRight.getEncoder();
  public static CANEncoder rearRightHall = rearRight.getEncoder();
  public static CANEncoder frontLeftHall = frontLeft.getEncoder();
  public static CANEncoder rearLeftHall = rearLeft.getEncoder();
  public static CANEncoder middleLeftHall = middleLeft.getEncoder();
  public static CANEncoder middleRightHall = middleRight.getEncoder();

  public DriveTrain(){
    frontLeft.setSmartCurrentLimit(currentLimit);
    frontRight.setSmartCurrentLimit(currentLimit);
    rearLeft.setSmartCurrentLimit(currentLimit);
    rearRight.setSmartCurrentLimit(currentLimit);
    middleLeft.setSmartCurrentLimit(currentLimit);
    middleRight.setSmartCurrentLimit(currentLimit);
  }

  @Override
  public void initDefaultCommand() { 
    setDefaultCommand(new DriveTeleop());
    SmartDashboard.putString("Print statements", "default command");
  }

  
  public static void driveTeleop(){
    double rightJoy = OI.atkJoy1.getRawAxis(5);
    double leftJoy = -OI.atkJoy1.getRawAxis(1);
/*
    if (Math.abs(rightJoy) > .05+beforeRightVel || Math.abs(rightJoy) < beforeRightVel-0.5){
      timerRight.stop();
      timerRight.reset();
      timerRight.start();
    }
*/
    frontLeft.setClosedLoopRampRate(3.0);
    frontRight.setClosedLoopRampRate(3.0);
    System.out.println(frontRight.setClosedLoopRampRate(3.0));

    if (Math.abs(rightJoy) < minOutput) rightJoy = 0;
    //else if (Math.abs(rightJoy)<midOuput) rightJoy *= .75;
    if (Math.abs(leftJoy) < minOutput) leftJoy = 0;
    //else if (Math.abs(leftJoy)<midOuput) leftJoy *= .75;

    if (-Math.max(LiftSpark.leftLiftHall.getPosition(), LiftSpark.rightLiftHall.getPosition()) > LiftSpark.height[2]){
      rightJoy *= 0.75;
      leftJoy *= 0.75;
    }

    frontLeft.set(leftJoy);
    frontRight.set(rightJoy);

    /*
    middleLeft.set(leftJoy);
    middleRight.set(rightJoy);
    rearLeft.set(leftJoy);
    rearRight.set(rightJoy);
    */

    SmartDashboard.putNumber("Left motor speed", DriveTrain.frontLeft.get());
    SmartDashboard.putNumber("Right motor speed", -DriveTrain.frontRight.get());
  }
  
  public static void driveAuton(double rightSpeed, double leftSpeed){
    frontRight.set(-rightSpeed);
    frontLeft.set(leftSpeed);
    /*
    rearRight.set(rightSpeed);
    rearLeft.set(leftSpeed);
    middleLeft.set(leftSpeed);
    middleRight.set(rightSpeed);
    */
    SmartDashboard.putNumber("Left motor speed", DriveTrain.frontLeft.get());
    SmartDashboard.putNumber("Right motor speed", DriveTrain.frontRight.get());
  }
  
  public static void turnDegrees(double angle) {
    if (angle > 180) {
      angle = -(360-angle);
    }
    while (gyro.getAngle()!= angle) {
      if (angle <0){
        driveAuton (-1.0,1.0);
      }
      else {
        driveAuton(1.0, -1.0);
      }
    }
  }
  
}
