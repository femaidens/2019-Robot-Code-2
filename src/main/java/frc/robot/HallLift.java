/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HallLift extends Subsystem {
  public static CANSparkMax sparkLeft = new CANSparkMax(5, MotorType.kBrushless);
  public static CANSparkMax sparkRight = new CANSparkMax(7, MotorType.kBrushless);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Counter leftHall = new Counter(1);
  public static Counter rightHall = new Counter(2);

  public static int index1 = 0;

  public static double[] level = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0}; 
    //0.0 will be ground state and 1.0 will be first hatch

  public static double rocket(int index){
    return level[index];
  }
  
  @Override
  public void initDefaultCommand() {
  }
  
  /*public static void liftUp(){
    double distance = rocket(index1);
    while (leftHall.get() < distance && rightHall.get() < distance){
      sparkLeft.set(0.65);
      sparkRight.set(0.65);
    }
  }

  public static void liftDown(){
    double distance = rocket(index1);
    while (leftHall.get() > distance && rightHall.get() > distance){
      sparkLeft.set(-0.65);
      sparkRight.set(-0.65);
     }
  }*/
}
