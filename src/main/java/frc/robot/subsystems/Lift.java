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

public class Lift extends Subsystem {
  public static CANSparkMax frontLeft = new CANSparkMax(3, MotorType.kBrushless);
  public static CANSparkMax rearLeft = new CANSparkMax(15, MotorType.kBrushless);

  /*public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftTalon);
  public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightTalon);
  public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftTalon);
  public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightTalon);
*/
  public static CANEncoder frontHall = frontLeft.getEncoder();
  public static CANEncoder rearHall = rearLeft.getEncoder();
  //public static Encoder encLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2);
  //public static Encoder encRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4);

  public static int index1 = 0;
  public static  double initial;
  public static double initial2;
  public static double max  = 71;

  public static double[] level = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0}; 
    //0.0 will be ground state and 1.0 will be first hatch
//
public Lift(){
  /*
  frontHall.setPosition(0.0);
  rearHall.setPosition(0.0);
  initial = frontHall.getPosition();
  initial2 = rearHall.getPosition();
  */
}
  public static double rocket(int index){
    return level[index];
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftTeleop());
  }

  public static void liftTeleop(){
     double rightSpeed = - OI.atkJoy2.getRawAxis(5);

     if ((rearHall.getPosition() <= initial2 || frontHall.getPosition() <= initial) && rightSpeed < 0){//min limit
      frontLeft.set(0.0);
      rearLeft.set(0.0);
      System.out.println("too low");
    }
    
    else if ((rearHall.getPosition() >= max || frontHall.getPosition() >= max) && rightSpeed > 0){//max limit
      frontLeft.set(0.0);
      rearLeft.set(0.0);
      System.out.println("too high");
    }
    
    else{
      frontLeft.set(rightSpeed);
      //rearRight.follow(frontRight);
      rearLeft.set(rightSpeed);
      //System.out.println("ok");
    }
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
