package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CargoIntake extends Subsystem {
    public static TalonSRX inTalon = new TalonSRX(5);
    public static TalonSRX backTalon = new TalonSRX(2);

    public static DoubleSolenoid backSol = new DoubleSolenoid(1, 2, 3);//RobotMap.cargoSol1, RobotMap.cargoSol2);

    public static boolean state = false;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void retract(){
    backSol.set(DoubleSolenoid.Value.kReverse);
    state = false;
  }
  public static void extend(){
    backSol.set(DoubleSolenoid.Value.kForward);
    state = true;
  }
  
  public static void intake(){
    if(state){
      backTalon.set(ControlMode.PercentOutput, 0.75);
    }
    else{
      inTalon.set(ControlMode.PercentOutput, 0.75);
      backTalon.set(ControlMode.PercentOutput, -0.75);
    }
    System.out.println("Intake");
  }
  public static void outtake(){
    if(state){
      backTalon.set(ControlMode.PercentOutput, -0.75);
    }
    else{
      inTalon.set(ControlMode.PercentOutput, -0.75);
      backTalon.set(ControlMode.PercentOutput, 0.75);
      System.out.println("Outtake");
    }
  }
  public static void stop(){
    backTalon.set(ControlMode.PercentOutput, 0.0);
    inTalon.set(ControlMode.PercentOutput, 0.0);
  }
  public static void outtakeZ(){
    backTalon.set(ControlMode.PercentOutput, -0.2);
  }
}