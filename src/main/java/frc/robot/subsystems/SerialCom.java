/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SerialCom extends Subsystem {
  public static edu.wpi.first.wpilibj.SerialPort serialPort;
  public SerialCom(){
      try {
        serialPort = new edu.wpi.first.wpilibj.SerialPort(9600, edu.wpi.first.wpilibj.SerialPort.Port.kUSB);
      }
      catch(Exception E){}
    }
  
  @Override
  public void initDefaultCommand() {
  
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static String receive(){
    String pls = serialPort.readString();
    return pls;
    /*for (SerialPort.Port c : SerialPort.Port.values())
    System.out.println(c);*/
  }
}//
