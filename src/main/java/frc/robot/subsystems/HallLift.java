/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HallLift extends Subsystem {
  public static CANSparkMax sparkLeft = new CANSparkMax(RobotMap.frontPort, MotorType.kBrushless);//3
  public static CANSparkMax sparkRight = new CANSparkMax(RobotMap.rearPort, MotorType.kBrushless);//15

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static CANEncoder leftHall = sparkLeft.getEncoder();
  public static CANEncoder rightHall = sparkRight.getEncoder();

  public static CANPIDController controller;

  public static int index1 = 0;

  public static double[] level = {0.0, 5.0, 11.0, 18.0, 27.0, 37.0, 48.0}; 
    //0.0 will be ground state and 1.0 will be first hatch

  public static double distance, initDistance;
//
  public HallLift()
  {
    //leftHall.setPosition(0.0);
    //rightHall.setPosition(0.0);
    controller = sparkRight.getPIDController();
    //sparkRight.follow(sparkLeft);//left leads
  }

  public static double rocket(int index){
    return level[index];
  }
  
  @Override
  public void initDefaultCommand() {
   //setDefaultCommand(new maintainHeight()); 
  }
  
  public static void liftUp(){
    System.out.println("Level: " + HallLift.index1);
    System.out.println(leftHall.getPosition());
    if (HallLift.index1 >= HallLift.level.length-1){
      System.out.println(" Where are you trying to go? To the sky?");
    }else{
      distance = rocket(index1+1)-rocket(index1);
      initDistance = leftHall.getPosition();
      //while ((leftHall.getPosition() < rocket(index1+1))){//&& Math.abs(rightHall.getPosition() - initDistance) < distance){
      while (leftHall.getPosition()-initDistance < distance) {
        sparkLeft.set(0.05);
        sparkRight.set(0.05);
      //System.out.println("Level: " + index1);
      }
      sparkLeft.set(0.0);
      sparkRight.set(0.0);
      index1++;
      System.out.println("Level: " + HallLift.index1);
    }
  }

  public static void liftDown(){
    System.out.println("Level: " + index1);
    System.out.println(leftHall.getPosition());
    if(HallLift.index1 <= 0){
      System.out.println(" Where are you trying to go? The mantle?");
    } else{
      distance = rocket(index1)-rocket(index1-1);
      initDistance = leftHall.getPosition();
      while (Math.abs(leftHall.getPosition()-initDistance) < distance){// && Math.abs(rightHall.getPosition() - initDistance) < distance){
        sparkLeft.set(-0.05);
        sparkRight.set(-0.05);
        //System.out.println("Level: " + index1);
      }
      sparkLeft.set(0.0);
      sparkRight.set(0.0);
      index1--;
      System.out.println("Level: " + HallLift.index1);
    }
  }

  public static void setVelocity(double v)
  {
    sparkLeft.set(v);
    sparkRight.set(v);
  }

}
