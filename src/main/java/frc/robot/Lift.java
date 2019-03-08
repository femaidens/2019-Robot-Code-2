package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
  /*public static TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftTalon);
  public static TalonSRX frontRight = new TalonSRX(RobotMap.frontRightTalon);
  public static TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftTalon);
  public static TalonSRX rearRight = new TalonSRX(RobotMap.rearRightTalon);
*/
  /*public static Encoder encLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2);
  public static Encoder encRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4);
*/
  public static int index1 = 0;

  public static double[] level = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0}; 
    //0.0 will be ground state and 1.0 will be first hatch

  public static double rocket(int index){
    return level[index];
  }
  
  @Override
  public void initDefaultCommand() {
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
}