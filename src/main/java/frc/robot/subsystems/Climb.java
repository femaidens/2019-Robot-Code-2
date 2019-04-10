/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class Climb extends Subsystem {

  public static DoubleSolenoid frontPiston = new DoubleSolenoid(RobotMap.climbPcmPortf, RobotMap.climbFrontPort1, RobotMap.climbFrontPort2);
  //actual robot ports = 1, 4, 5
  //practice robot ports  = 3, 6, 7
  public static DoubleSolenoid rearPiston = new DoubleSolenoid(RobotMap.climbPcmPortr, RobotMap.climbRearPort1, RobotMap.climbRearPort2);
  //actual robot ports = 3, 6, 7
  //practice robot ports = 3, 4, 5

  public static boolean climbFront = false;
  public static boolean climbBack = false;

  @Override
  public void initDefaultCommand() {
  }
  
  public static void extendFront(){
    frontPiston.set(DoubleSolenoid.Value.kForward);
    climbFront = true;
    SmartDashboard.putBoolean("Front", climbFront);
  }
  public static void extendRear(){
    rearPiston.set(DoubleSolenoid.Value.kForward);
    climbBack = true;
    SmartDashboard.putBoolean("Back", climbBack);
  }
  public static void retractFront(){
    frontPiston.set(DoubleSolenoid.Value.kReverse);
    climbFront = false;
    SmartDashboard.putBoolean("Front", climbFront);
  }
  public static void retractRear(){
    rearPiston.set(DoubleSolenoid.Value.kReverse);
    climbBack = false;
    SmartDashboard.putBoolean("Back", climbBack);
  }
}
