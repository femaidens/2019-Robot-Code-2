/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem {

  /*public static CANSparkMax frontRight = new CANSparkMax(0, MotorType.kBrushless);
  public static CANSparkMax frontLeft = new CANSparkMax(15, MotorType.kBrushless);
  public static CANSparkMax rearRight = new CANSparkMax(2, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(12, MotorType.kBrushless);
  public static CANSparkMax middleLeft = new CANSparkMax(10, MotorType.kBrushless);
  public static CANSparkMax middleRight = new CANSparkMax(18, MotorType.kBrushless);

  public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);

  public static CANEncoder frontRightHall = frontRight.getEncoder();
  public static CANEncoder rearRightHall = rearRight.getEncoder();
  public static CANEncoder frontLeftHall = frontLeft.getEncoder();
  public static CANEncoder rearLeftHall = rearLeft.getEncoder();
  public static CANEncoder middleLeftHall = middleLeft.getEncoder();
  public static CANEncoder middleRightHall = middleRight.getEncoder();
  //1 revolution is approximately 0.  
  */
  public static byte[] num = new byte[32];
  
  

  
  /*public static byte[] middle = new byte[1];
  public static byte[] right = new byte[1];
  public static byte[] ultrasonic = new byte[1];
  */
  public DriveTrain(){
    
  }

  @Override
  public void initDefaultCommand() { 
    //setDefaultCommand(new DriveTeleop());
    //System.out.println("defaultcommand");
  }
  public static void driveTeleop(){
    //double leftJoy = OI.atkJoy1.getRawAxis(1);
    //double rightJoy = OI.atkJoy1.getRawAxis(5);
    /*double leftJoy = 0.02;
    double rightJoy  = 0.02;
    frontRight.set(rightJoy);
    rearRight.set(rightJoy);
    frontLeft.set(leftJoy);
    rearLeft.set(leftJoy);
    middleLeft.set(leftJoy);
    middleRight.set(rightJoy);   
    *///System.out.println(DriveTrain.frontLeftHall.getPosition() + "/t" + DriveTrain.frontRightHall.getPosition() + "/t" + DriveTrain.rearLeftHall.getPosition() + "/t" + DriveTrain.rearRightHall.getPosition());  
  }

  /*public static void driveAuton(double rightSpeed, double leftSpeed){
    frontRight.set(rightSpeed);
    rearRight.set(rightSpeed);
    frontLeft.set(leftSpeed);
    rearLeft.set(leftSpeed);
    middleLeft.set(leftSpeed);
    middleRight.set(rightSpeed);
  }*/

  public static void infrared(){
    for(int i = 0; i<num.length; i++){
      num[i] = 1;
    }
    for(int i = 0; i<num.length;i++){
      System.out.print(num[i]+" ");
    }
    System.out.println();
    
    //Robot.i2c.read(2, 1, middle); //9 is the port
    //Robot.i2c.read(3, 1, right);
    //Robot.i2c.readOnly(num, 36);
    Robot.i2c.transaction(new byte[0], 0, num, 36);
    Robot.i2c.read(4, 32, num); //second parameter is int count. idk what it is.
    /*while(num[0] != 1){ 
      while(num[0] == 0){
        driveAuton(0.2, 0.5);
        System.out.println("yooooo");

      }
      while(num[0] == 2){
        driveAuton(0.5, 0.2);

      }
    }
    if(num[0] == 1){
      System.out.println("yooooo");
    }else{
      System.out.println("Yikes");
    }*/
    /*String output = new String(num);//create a string from the byte array
    int pt = output.indexOf((char)255);
    String wow = new String(num);
    System.out.println(pt);*/
    
    for(int i = 0; i<num.length;i++){
      System.out.print(num[i]+" ");
    }
    System.out.println();
    //System.out.println(wow);
    //return (String) output.subSequence(0, pt < 0 ? 0 : pt);
  }
  public static void Pls(){
    Robot.i2c.read(4, 32, num);
    String output = new String(num);
    int pt = output.indexOf((char)255);
    System.out.println("Printing data");
    for (int i = 0; i < 32; i++) {
      System.out.print(num[i]+" ");
    }
    System.out.println("Done");
    //System.out.println((String) output.subSequence(0, pt < 0 ? 0 : pt));
   
    /*char[] CharArray = input.toCharArray();//creates a char array from the input string
			byte[] WriteData = new byte[CharArray.length];//creates a byte array from the char array
			for (int i = 0; i < CharArray.length; i++) {//writes each byte to the arduino
				WriteData[i] = (byte) CharArray[i];//adds the char elements to the byte array 
			}
			Robot.i2c.transaction(WriteData, WriteData.length, null, 0);//sends each byte to arduino
    *///System.out.print(infrared());
    //String output = new String(num);
    //System.out.println(output);
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
