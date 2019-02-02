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
    public static TalonSRX talonLevel1 = new TalonSRX(RobotMap.cargoTalonPortLevel1);
    public static TalonSRX talonLevel2 = new TalonSRX(RobotMap.cargoTalonPortLevel2);

    //public static DoubleSolenoid backSol = new DoubleSolenoid(RobotMap.cargoSol1, RobotMap.cargoSol2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
/*
  public static void retract(){
    backSol.set(DoubleSolenoid.Value.kReverse);
  }
  public static void extend(){
    backSol.set(DoubleSolenoid.Value.kForward);
  }
  */
  public static void intake(){
    talonLevel2.set(ControlMode.PercentOutput, -0.2);
    talonLevel1.set(ControlMode.PercentOutput, 0.2);
    //System.out.println("Intake");
  }
  public static void outtake(){
    talonLevel2.set(ControlMode.PercentOutput, 0.2);
    //System.out.println("Outtake");
  }
  public static void stop(){
    talonLevel2.set(ControlMode.PercentOutput, 0.0);
    talonLevel1.set(ControlMode.PercentOutput, 0.0);
    //System.out.println("Stop taking");
  }

}
