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
  public static boolean hatchState; //true if baby piston extended
  public static boolean hatchState2; //true if mama piston extended

  // Put methods for controlling this subsystem here. 
  //Call these from Commands.
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public static void extendBaby(){
    sol1.set(DoubleSolenoid.Value.kForward);
    hatchState = true;
    SmartDashboard.putBoolean("Baby piston", hatchState);
  }
  
  public static void retractBaby(){
    sol1.set(DoubleSolenoid.Value.kReverse);
    hatchState = false;
    SmartDashboard.putBoolean("Baby piston", hatchState);
  }

  public static void extendMama(){
    sol2.set(DoubleSolenoid.Value.kForward);
    hatchState2 = true;
    SmartDashboard.putBoolean("Mama piston", hatchState2);
  }
  
  public static void retractMama(){
    sol2.set(DoubleSolenoid.Value.kReverse);
    hatchState2 = false;
    SmartDashboard.putBoolean("Mama piston", hatchState2);
  }
   
}
