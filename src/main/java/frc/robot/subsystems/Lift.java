package frc.robot.subsystems;
import frc.robot.*;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift extends Subsystem {
  public static CANSparkMax frontLeft = LiftSpark.leftCasMotor;// new CANSparkMax(RobotMap.frontPort, MotorType.kBrushless);//3
  public static CANSparkMax rearLeft = LiftSpark.rightCasMotor;//new CANSparkMax(RobotMap.rearPort, MotorType.kBrushless);//15

  /*public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftTalon);
  public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightTalon);
  public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftTalon);
  public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightTalon);
  */
    
  public static CANEncoder frontHall = LiftSpark.leftLiftHall;//.getEncoder();
  public static CANEncoder rearHall = LiftSpark.rightLiftHall;//.getEncoder();
  //public static Encoder encLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2);
  //public static Encoder encRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4);

  public static int index1 = 0;
  public static  double initial;
  public static double initial2;
  public static double max  = 71;

  public static double[] height; //{0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0}; 
  public static String[] printOuts = {"Starting Position (Hatch 1)","Cargo 1","Cargo Ship", "Hatch 2", "Cargo 2", "Hatch 3", "Cargo 3", "MAX"};
    //0.0 will be ground state and 1.0 will be first hatch
//
public Lift(){
  /*
  frontHall.setPosition(0.0);
  rearHall.setPosition(0.0);
  initial = frontHall.getPosition();
  initial2 = rearHall.getPosition();
  */
} /*
  public static double rocket(int index){
    return height[index];
  }
  */
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftTeleop());
  }

  public static void liftTeleop(){
    System.out.println("joystick value:"+ (-OI.atkJoy2.getRawAxis(1)));
     double rightSpeed = -OI.atkJoy2.getRawAxis(1);
     if (Math.abs(rightSpeed) < 0.075) rightSpeed = 0;
     else if (rightSpeed < 0) rightSpeed *= .15;
     //else if (-LiftSpark.rightLiftHall.getPosition() > LiftSpark.height[2]) rightSpeed *= .5;
     double currentRear = -rearHall.getPosition();
     double currentFront = -frontHall.getPosition();

     if ((currentRear <= initial2+2.5 || currentFront <= initial+2.5) && rightSpeed < 0){//min limit
      //frontLeft.set(0.0);
      rearLeft.set(0.0);
      System.out.println("too low");
    }
    /*
    else if ((rearHall.getPosition() >= max || frontHall.getPosition() >= max) && rightSpeed > 0){//max limit
      frontLeft.set(0.0);
      rearLeft.set(0.0);
      System.out.println("too high");
    }
    */
    else{
      //frontLeft.set(-rightSpeed);
      rearLeft.set(-rightSpeed);
      //System.out.println("ok");
    }
    SmartDashboard.putNumber("Front Hall", currentFront);
    SmartDashboard.putNumber("Rear Hall", currentRear);
    SmartDashboard.putNumber("Joystick", rightSpeed);

  }

  }
  /*
  public static void liftUp(){
    double distance = rocket(index1);
    while (encLeft.get() < distance && encRight.get() < distance){
      frontLeft.set(ControlMode.PercentOutput, 0.02);
      frontRight.set(ControlMode.PercentOutput, 0.02);
      rearLeft.set(ControlMode.PercentOutput, 0.02);
      rearRight.set(ControlMode.PercentOutput, 0.02);
    }
  }

  public static void liftDown(){
    double distance = rocket(index1);
    while (encLeft.get() > distance && encRight.get() > distance){
      frontLeft.set(ControlMode.PercentOutput, -0.02);
      frontRight.set(ControlMode.PercentOutput, -0.02);
      rearLeft.set(ControlMode.PercentOutput, -0.02);
      rearRight.set(ControlMode.PercentOutput, -0.02);
    }
  }*/
