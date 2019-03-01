/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchIntake extends Subsystem {
  public static DoubleSolenoid sol1 = new DoubleSolenoid(RobotMap.hatchPcmPort1, RobotMap.solChannel1, RobotMap.solChannel2);
  //actual robot ports = 1, 0, 1
  //practice robot ports = 2, 0 ,1
  public static DoubleSolenoid sol2 = new DoubleSolenoid(RobotMap.hatchPcmPort2, RobotMap.solChannel3, RobotMap.solChannel4);
  //actual robot ports = 2, 2, 3
  //practice robot ports = 2, 2, 3

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static boolean hatchState ; //true if already extended
  public static boolean hatchState2; 
//
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public static void extend(){
    sol1.set(DoubleSolenoid.Value.kForward);
    hatchState = true;
  }
  
  public static void retract(){
    sol1.set(DoubleSolenoid.Value.kReverse);
    hatchState = false;
  }

  public static void extend2(){
    sol2.set(DoubleSolenoid.Value.kForward);
    hatchState2 = true;
  }
  
  public static void retract2(){
    sol2.set(DoubleSolenoid.Value.kReverse);
    hatchState2 = false;
  }
   
}
