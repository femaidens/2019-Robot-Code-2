/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {

  public DriveTrain(){
  }

  public static CANSparkMax frontRight = new CANSparkMax(0, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(15, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(2, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(12, MotorType.kBrushless);

  //public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static Counter frontRightHall = new Counter(0);
  public static Counter rearRightHall = new Counter(2);
  public static Counter frontLeftHall = new Counter(15);
  public static Counter rearLeftHall = new Counter(12);

  @Override
  public void initDefaultCommand() { 
    setDefaultCommand(new DriveTeleop());
    System.out.println("defaultcommand");
  }
  public static void driveTeleop(){
    double leftJoy = OI.atkJoy1.getRawAxis(1);
    double rightJoy = OI.atkJoy1.getRawAxis(5);
    frontRight.set(rightJoy);
    rearRight.set(rightJoy);
    frontLeft.set(leftJoy);
    rearLeft.set(leftJoy);
    System.out.println(frontLeftHall.get() + frontRightHall.get() + rearLeftHall.get() + rearRightHall.get());
  }
  public static void driveAuton(double rightSpeed, double leftSpeed){
    frontRight.set(rightSpeed);
    rearRight.set(rightSpeed);
    frontLeft.set(leftSpeed);
    rearLeft.set(leftSpeed);
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
  }*/
}
