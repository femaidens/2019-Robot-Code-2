/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //private static final String kDefaultAuto = "Default";
  //private static final String kCustomAuto = "My Auto";
  //private String m_autoSelected;
  public static OI m_oi;
  //private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static DriveTrain drivetrain;
  public static Limelight limelight;
  
  //Command autonomousCommand;
  public static Timer timer;
  
  //public static HallLift hallLift;
  //public static I2C i2c;
  //public static SerialCom serialCom;
  //public static Practice practice;
  
  public static Climb climb;
  public static Compressor compress;
  public static HatchIntake hatchIntake;
  public static CargoIntake cargoIntake;
  public static Lift lift;
  //public static DriveTrain drivetrain;
  
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi=new OI();
    //m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
   // m_chooser.addOption("My Auto", kCustomAuto);
    //SmartDashboard.putData("Auto choices", m_chooser);
   // autonomousCommand = new AutonomousDrive();
    m_oi.bindButtons();
    //timer = new Timer();
    //serialCom = new SerialCom();
    //practice = new Practice();
    //hallLift = new HallLift();
    
    //timer.start();

    drivetrain = new DriveTrain();
    limelight = new Limelight();

    //stuff with pneumatics
    
    hatchIntake = new HatchIntake();
    cargoIntake = new CargoIntake();
    lift = new Lift();
    climb = new Climb();
    compress = new Compressor();
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
    Lift.frontHall.setPosition(0.0);
    Lift.rearHall.setPosition(0.0);
    Lift.initial = Lift.frontHall.getPosition();
    Lift.initial2 = Lift.rearHall.getPosition();
    System.out.println("initial:\t"+Lift.initial);
    System.out.println("initial2:\t"+ Lift.initial2);
  }

  @Override
  public void disabledPeriodic() {
    //Scheduler.getInstance().run();
  }

  

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */

  @Override
  public void autonomousInit() {
    //m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    //System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    /*switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }*/
  }

  @Override
  public void teleopInit() {
    /*if (autonomousCommand != null){
      autonomousCommand.cancel();
    }*/
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
