/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchIntake extends Subsystem {
  public static DoubleSolenoid sol1 = new DoubleSolenoid(RobotMap.solChannel1, RobotMap.solChannel2);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static boolean hatchState ; //true if already extended

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

   
}
