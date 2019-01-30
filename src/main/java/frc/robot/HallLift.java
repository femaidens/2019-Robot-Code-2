/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HallLift extends Subsystem {
  public static CANSparkMax sparkLeft = new CANSparkMax(12, MotorType.kBrushless);
  public static CANSparkMax sparkRight = new CANSparkMax(15, MotorType.kBrushless);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANEncoder leftHall = sparkLeft.getEncoder();
  public static CANEncoder rightHall = sparkRight.getEncoder();

  public static int index1 = 0;

  public static double[] level = {0.0, 5.0, 11.0, 18.0, 27.0, 37.0, 48.0}; 
    //0.0 will be ground state and 1.0 will be first hatch

  public static double rocket(int index){
    return level[index];
  }
  
  @Override
  public void initDefaultCommand() {
  }
  
  public static void liftUp(){
    double distance = rocket(index1+1)-rocket(index1);
    double initDistance = leftHall.getPosition();
    while (Math.abs(leftHall.getPosition() - initDistance) < distance){//&& Math.abs(rightHall.getPosition() - initDistance) < distance){
      sparkLeft.set(0.05);
      sparkRight.set(0.05);
      //System.out.println("Level: " + index1);
    }
    sparkLeft.set(0.0);
    sparkRight.set(0.0);
  }

  public static void liftDown(){
    double distance = rocket(index1)-rocket(index1-1);
    double initDistance = leftHall.getPosition();
    while (Math.abs(leftHall.getPosition() - initDistance) < distance){// && Math.abs(rightHall.getPosition() - initDistance) < distance){
      sparkLeft.set(-0.05);
      sparkRight.set(-0.05);
      //System.out.println("Level: " + index1);
    }
    sparkLeft.set(0.0);
    sparkRight.set(0.0);
  }
}
