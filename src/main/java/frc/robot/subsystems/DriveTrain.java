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

//import org.graalvm.compiler.nodes.calc.RightShiftNode;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;



public class DriveTrain extends Subsystem {

  public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, MotorType.kBrushless);//12
  public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, MotorType.kBrushless);//1
  public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, MotorType.kBrushless);//14
  public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, MotorType.kBrushless);//4
  public static CANSparkMax middleLeft = new CANSparkMax(RobotMap.middleLeftPort, MotorType.kBrushless);//2
  public static CANSparkMax middleRight = new CANSparkMax(RobotMap.middleRightPort, MotorType.kBrushless);//11

//
  public static double initial, initial2;
  public static double max = 30;
  //public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static CANEncoder frontRightHall = frontRight.getEncoder();
  public static CANEncoder rearRightHall = rearRight.getEncoder();
  public static CANEncoder frontLeftHall = frontLeft.getEncoder();
  public static CANEncoder rearLeftHall = rearLeft.getEncoder();
  public static CANEncoder middleLeftHall = middleLeft.getEncoder();
  public static CANEncoder middleRightHall = middleRight.getEncoder();
  //1 revolution is approximately 0.  
  
  //public static TalonSRX frontRight = new TalonSRX(1);

  public DriveTrain(){
    /*frontRightHall.setPosition(0.0);
    rearRightHall.setPosition(0.0);
    initial = frontRightHall.getPosition();
    initial2 = rearRightHall.getPosition();
  */}

  @Override
  public void initDefaultCommand() { 
    setDefaultCommand(new DriveTeleop());
    System.out.println("defaultcommand");
  }

  
  public static void driveTeleop(){//cascade

    //make joystick value positive, pos is up, neg is down
    double rightJoy = OI.atkJoy1.getRawAxis(5);
    double leftJoy = -OI.atkJoy1.getRawAxis(1);
    
    frontLeft.set(leftJoy);
    frontRight.set(rightJoy);
    middleLeft.set(leftJoy);
    middleRight.set(rightJoy);
    rearLeft.set(leftJoy);
    rearRight.set(rightJoy);
  }
      //System.out.println("joy" + rightJoy);
      

    /*if ((rearRightHall.getPosition() <= initial2 || frontRightHall.getPosition() <= initial) && rightJoy < 0){//min limit
      frontRight.set(0.0);
      rearRight.set(0.0);
      System.out.println("too low");
    }
    
    else if ((rearRightHall.getPosition() >= max || frontRightHall.getPosition() >= max) && rightJoy > 0){//max limit
      frontRight.set(0.0);
      rearRight.set(0.0);
      System.out.println("too high");
    }
    
    else{
      frontRight.set(rightJoy);
      //rearRight.follow(frontRight);
      rearRight.set(rightJoy);
      System.out.println("ok");
    }
    */
  
  
  
/*
  public static void driveTeleop(){//cargo
    //double leftJoy = OI.atkJoy1.getRawAxis(1);
    double rightJoy = OI.atkJoy1.getRawAxis(5);

    //frontRight.set(ControlMode.PercentOutput, rightJoy);
    frontRight.set(rightJoy);
    frontLeft.set(rightJoy);
  }
*/
  public static void driveAuton(double rightSpeed, double leftSpeed){
    frontRight.set(rightSpeed);
    rearRight.set(rightSpeed);
    frontLeft.set(leftSpeed);
    rearLeft.set(leftSpeed);
    middleLeft.set(leftSpeed);
    middleRight.set(rightSpeed);
  }
  

  public static void infrared(){
  }
  /*
  public static void turnDegrees(int angle) {
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
  */
}
