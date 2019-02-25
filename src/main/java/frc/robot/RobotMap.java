/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class RobotMap {
    
    //Joystick ports
    public static int joyPort1 = 0;
    //public static int joyPort2 = 4;

    //PCM ports
    public static int pcmPort1 = 1; //PCM Name = Dodo
    public static int pcmPort2 = 2; //PCM Name = Spring

    //Hatch- baby piston ports (PCM-2)
    public static int solChannel1 = 0; 
    public static int solChannel2 = 1;

    //Hatch- out piston ports (PCM-2)
    public static int solChannel3 = 2;
    public static int solChannel4 = 3;

    //Cargo Piston ports (PCM- 0)
    public static int cargoSol1 = 2;
    public static int cargoSol2 = 3;

    //Climb Piston ports (PCM- 0)
    public static int climbFrontPort1 = 6;
    public static int climbFrontPort2 = 7;
    public static int cilmbRearPort1 = 4;
    public static int climbRearPort2 = 5;

    //Drivetrain SparkMax ports
    public static int frontRightPort = 0;
    public static int frontLeftPort = 0;
    public static int middleRightPort = 0;
    public static int middleLeftPort = 0;
    public static int rearRightPort = 0;
    public static int rearLeftPort = 0;


    //public static int rearLeftTalon = 3; //rearLeft
    //public static int frontLeftTalon = 4; //frontLeft
   // public static int rearRightTalon = 1; //rearRight
    public static int frontRightTalon = 5; //frontRight
    public static int encPort1 = 9;
    public static int encPort2 = 10;
    public static int encPort3 = 11;
    public static int encPort4 = 12;

    public static int cargoTalonPortfr = 2; //frontright
    public static int cargoTalonPortfl = 4; //frontleft
    public static int cargoTalonPortrl = 3; //rearLeft
    public static int cargoTalonPortrr = 1; //rearRight

    public static int gyroPort = 29;
    //public static int I2Cport = 30;
}
