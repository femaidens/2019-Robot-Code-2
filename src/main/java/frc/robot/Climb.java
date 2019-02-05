/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Climb extends Subsystem {
  public static DoubleSolenoid frontRightPiston = new DoubleSolenoid(RobotMap.solenoidPort1, RobotMap.solenoidPort2);
  public static DoubleSolenoid frontLeftPiston = new DoubleSolenoid(RobotMap.solenoidPort3, RobotMap.solenoidPort4);
  public static DoubleSolenoid rearRightPiston = new DoubleSolenoid(RobotMap.solenoidPort5, RobotMap.solenoidPort6);
  public static DoubleSolenoid rearLeftPiston = new DoubleSolenoid(RobotMap.solenoidPort7, RobotMap.solenoidPort8);

  public static boolean climbFront = false;
  public static boolean climbBack = false;

  @Override
  public void initDefaultCommand() {
  }
  public static void extendFront(){
    frontRightPiston.set(DoubleSolenoid.Value.kForward);
    frontLeftPiston.set(DoubleSolenoid.Value.kForward);
    climbFront = true;
  }
  public static void extendRear(){
    rearRightPiston.set(DoubleSolenoid.Value.kForward);
    rearLeftPiston.set(DoubleSolenoid.Value.kForward);
    climbBack = true;
  }
  public static void retractFront(){
    frontRightPiston.set(DoubleSolenoid.Value.kReverse);
    frontLeftPiston.set(DoubleSolenoid.Value.kReverse);
    climbFront = false;
  }
  public static void retractRear(){
    rearRightPiston.set(DoubleSolenoid.Value.kReverse);
    rearLeftPiston.set(DoubleSolenoid.Value.kReverse);
    climbBack = false;
  }
}
