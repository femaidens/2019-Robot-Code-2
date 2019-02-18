/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Climb extends Subsystem {

  public static DoubleSolenoid frontPiston = new DoubleSolenoid(1, 6, 7);//RobotMap.solenoidPort3, RobotMap.solenoidPort4);
  public static DoubleSolenoid rearPiston = new DoubleSolenoid(1, 4, 5);//RobotMap.solenoidPort5, RobotMap.solenoidPort6);

  public static boolean climbFront = false;
  public static boolean climbBack = false;

  @Override
  public void initDefaultCommand() {
  }
  public static void extendFront(){
    frontPiston.set(DoubleSolenoid.Value.kForward);
    climbFront = true;
  }
  public static void extendRear(){
    rearPiston.set(DoubleSolenoid.Value.kForward);
    climbBack = true;
  }
  public static void retractFront(){
    frontPiston.set(DoubleSolenoid.Value.kReverse);
    climbFront = false;
  }
  public static void retractRear(){
    rearPiston.set(DoubleSolenoid.Value.kReverse);
    climbBack = false;
  }
}
