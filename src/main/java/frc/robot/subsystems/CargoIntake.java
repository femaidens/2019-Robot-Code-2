package frc.robot.subsystems;

import frc.robot.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class CargoIntake extends Subsystem {
  public static TalonSRX inTalon = new TalonSRX(RobotMap.cargo1Port); //5
  public static TalonSRX backTalon = new TalonSRX(RobotMap.cargo2Port); //2

  public static DoubleSolenoid backSol = new DoubleSolenoid(RobotMap.cargoPcmPort, RobotMap.cargoSol1,RobotMap.cargoSol2);
  //actual robot ports = 1, 2, 3
  //practice robot ports = 2, 4, 5

  public static boolean state = false; //true if piston is extended
  //piston must be extended for cargo 1 to work

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void retract(){
    backSol.set(DoubleSolenoid.Value.kReverse);
    state = false;
    SmartDashboard.putBoolean("State", state);
  }
  public static void extend(){
    backSol.set(DoubleSolenoid.Value.kForward);
    state = true;
    SmartDashboard.putBoolean("State", state);
  }
  
  public static void intake(){ 
    double cargoVel = 0.75;
    if (LiftSpark.rightLiftHall.getPosition() > LiftSpark.height[0]) cargoVel = OI.atkJoy2.getRawAxis(5);
    if(state){
      backTalon.set(ControlMode.PercentOutput, -cargoVel);
    }
    else{
      inTalon.set(ControlMode.PercentOutput, cargoVel);
      backTalon.set(ControlMode.PercentOutput, -cargoVel);
    }
    System.out.println("Intake");
    SmartDashboard.putString("Cargo", "intake");
  }
  public static void outtake(){
    double cargoVel = 0.75;
    if (LiftSpark.rightLiftHall.getPosition() > LiftSpark.height[0]) cargoVel = -OI.atkJoy2.getRawAxis(5);    //if (LiftSpark.level == 3) cargoVel = 0.50;
    if(state){
      backTalon.set(ControlMode.PercentOutput, cargoVel);
    }
    else{
      inTalon.set(ControlMode.PercentOutput, -cargoVel);
      backTalon.set(ControlMode.PercentOutput, cargoVel);
    }
    System.out.println("Outtake");
    SmartDashboard.putString("Cargo", "outtake");
  }
  public static void stop(){
    backTalon.set(ControlMode.PercentOutput, 0.0);
    inTalon.set(ControlMode.PercentOutput, 0.0);
    SmartDashboard.putString("Cargo", "stop");
  }
}