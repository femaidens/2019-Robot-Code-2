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
import java.lang.Double; 

/**
 * Add your docs here.
 */
public class Practice extends Subsystem {
 public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightTalon);
 /*public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftTalon);
 public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightTalon);
 public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftTalon);

*/ 
 public static edu.wpi.first.wpilibj.SerialPort serialPort;

 public Practice(){
      /*try {
        serialPort = new edu.wpi.first.wpilibj.SerialPort(9600, edu.wpi.first.wpilibj.SerialPort.Port.kUSB);
      }
      catch(Exception E){}*/
    }

 //public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

 public static void driveTeleop() {
   double rightJoy = OI.atkJoy1.getRawAxis(5);
   double leftJoy = OI.atkJoy1.getRawAxis(1);

   frontRight.set(ControlMode.PercentOutput, rightJoy);
   //frontLeft.set(ControlMode.PercentOutput, leftJoy);
   //rearRight.set(ControlMode.PercentOutput, rightJoy);
   //rearLeft.set(ControlMode.PercentOutput, leftJoy);
 }

 public static void driveAuton(double rightSpeed, double leftSpeed){
   frontRight.set(ControlMode.PercentOutput, rightSpeed);
   /*rearRight.set(ControlMode.PercentOutput,  rightSpeed);
   frontLeft.set(ControlMode.PercentOutput, leftSpeed);
   rearLeft.set(ControlMode.PercentOutput, leftSpeed);*/
 }

    public static void ultraSonic(){
      //System.out.println(serialPort.readString());
      //double d = Double.parseDouble(serialPort.readString());
      /*if (d > 10){
        //driveAuton(0.1, 0.1);
      }*/
      //System.out.println(d);
    }

    public static void infrared(){
      /*String state = serialPort.readString();
      if (!state.strip().equals("")) System.out.println(state); 
      if (state.toLowerCase().contains("middle")){
        System.out.println("Yay");
        
      }*/
    }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveTeleop());
  }
}
