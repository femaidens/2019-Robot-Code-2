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

  public static CANSparkMax frontRight = new CANSparkMax(14, MotorType.kBrushless);
  //public static CANSparkMax frontLeft = new CANSparkMax(15, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(15, MotorType.kBrushless);
  //public static CANSparkMax rearLeft = new CANSparkMax(12, MotorType.kBrushless);
  //public static CANSparkMax middleLeft = new CANSparkMax(10, MotorType.kBrushless);
  //public static CANSparkMax middleRight = new CANSparkMax(18, MotorType.kBrushless);

//
  public static double initial, initial2;
  public static double max = -40;
  //public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static CANEncoder frontRightHall = frontRight.getEncoder();
  public static CANEncoder rearRightHall = rearRight.getEncoder();
  /*public static CANEncoder frontLeftHall = frontLeft.getEncoder();
  public static CANEncoder rearLeftHall = rearLeft.getEncoder();
  public static CANEncoder middleLeftHall = middleLeft.getEncoder();
  public static CANEncoder middleRightHall = middleRight.getEncoder();
  //1 revolution is approximately 0.  
  */
  //public static TalonSRX frontRight = new TalonSRX(1);

  public DriveTrain(){
    frontRightHall.setPosition(0.0);
    rearRightHall.setPosition(0.0);
    initial = frontRightHall.getPosition();
    initial2 = rearRightHall.getPosition();
  }

  @Override
  public void initDefaultCommand() { 
    setDefaultCommand(new DriveTeleop());
    System.out.println("defaultcommand");
  }

  
  public static void driveTeleop(){//cascade
    //everything is mechanically backwards

    //make joystick value positive, pos is up, neg is down
    double rightJoy = -OI.atkJoy1.getRawAxis(5);
    
    //initials are the physical mins, but code max
    //max is the code min, but physical max height
    if (frontRightHall.getPosition() < initial && rearRightHall.getPosition() < initial2 
    && frontRightHall.getPosition() > max && rearRightHall.getPosition() > max){
      //in usable range, so go wherever
      frontRight.set(rightJoy);
      rearRight.set(rightJoy);
      System.out.println(rightJoy);
    }
    else if ((frontRightHall.getPosition() >= initial || rearRightHall.getPosition() >= initial2) && rightJoy > 0){
      //at/past physical min(code max) and trying to go up, so go up)
      frontRight.set(rightJoy);
      rearRight.set(rightJoy);
    }
    else if ((frontRightHall.getPosition() <= max || rearRightHall.getPosition() <= max) && rightJoy < 0){
      //at/past physical max(code min) and trying to go down, so go down)
      frontRight.set(rightJoy);
      rearRight.set(rightJoy);
    }
    else{//anything other cases will stop the cascade
      frontRight.set(0.0);
      rearRight.set(0.0);
      System.out.println("no");
    }
    //frontLeft.set(rightJoy);
    //rearLeft.set(leftJoy);
    //middleLeft.set(leftJoy);
    //middleRight.set(rightJoy);   
    ///System.out.println(DriveTrain.frontLeftHall.getPosition() + "/t" + DriveTrain.frontRightHall.getPosition() + "/t" + DriveTrain.rearLeftHall.getPosition() + "/t" + DriveTrain.rearRightHall.getPosition());  
  }
  
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
    //frontLeft.set(leftSpeed);
    //rearLeft.set(leftSpeed);
    //middleLeft.set(leftSpeed);
    //middleRight.set(rightSpeed);
  }
  

  public static void infrared(){
  }
  /*public static void turnDegrees(int angle) {
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
  }*/
}
