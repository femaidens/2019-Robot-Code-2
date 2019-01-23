/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CargoIntake extends Subsystem {
    public static TalonSRX inTalon = new TalonSRX(RobotMap.cargoTalonPort1);
    public static TalonSRX backTalon1 = new TalonSRX(RobotMap.cargoTalonPort2);
    public static TalonSRX backTalon2 = new TalonSRX(RobotMap.cargoTalonPort3);

    public static DoubleSolenoid backSol1 = new DoubleSolenoid(RobotMap.cargoSol1, RobotMap.cargoSol2);
    public static DoubleSolenoid backSol2 = new DoubleSolenoid(RobotMap.cargoSol3, RobotMap.cargoSol4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /*public static void retract(){
    backSol1.set(DoubleSolenoid.Value.kReverse);
    backSol2.set(DoubleSolenoid.Value.kReverse);
  }
  public static void extend(){
    backSol1.set(DoubleSolenoid.Value.kForward);
    backSol2.set(DoubleSolenoid.Value.kForward);
  }
  public static void intake(){
    inTalon.set(ControlMode.PercentOutput, -0.75);
    backTalon1.set(ControlMode.PercentOutput, -0.75);
    backTalon2.set(ControlMode.PercentOutput, -0.75);
  }
  public static void outtake(){
    backTalon1.set(ControlMode.PercentOutput, 0.75);
    backTalon2.set(ControlMode.PercentOutput, 0.75);
  }*/
}
