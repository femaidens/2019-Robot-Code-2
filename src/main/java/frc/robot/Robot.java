/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import org.opencv.imgcodecs.Imgcodecs;
import java.util.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;

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
  //public static DriveTrain drivetrain;
  public static CvSink cvSink;
  public static CvSource outputStream; 
  //Command autonomousCommand;
  public static Timer timer;
  
  //public static HallLift hallLift;
  //public static I2C i2c;
  //public static SerialCom serialCom;
  //public static Practice practice;
  
  /*public static Climb climb;
  public static Compressor compress;
  public static HatchIntake hatchIntake;
  public static CargoIntake cargoIntake;
  public static Lift lift;
   */
  //public static DriveTrain drivetrain;
  
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    System.load("C:\\Users\\Robotics\\Desktop\\frc\\opencv\\build\\java\\x64\\opencv_java400.dll");
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

    //drivetrain = new DriveTrain();

    //stuff with pneumatics
    
    /*hatchIntake = new HatchIntake();
    cargoIntake = new CargoIntake();
    lift = new Lift();
    climb = new Climb();
    compress = new Compressor();
  */

    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 480);
    camera.setBrightness(0);
    outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
    cvSink = CameraServer.getInstance().getVideo();

    new Thread(() -> {
      System.load("C:\\Users\\Robotics\\Desktop\\frc\\opencv\\build\\java\\x64\\opencv_java400.dll");
      Mat img1 = new Mat();
      //img1 = Imgcodecs.imread("C:\\Users\\Robotics\\Desktop\\pastedimage0.png");
      Mat img2 = new Mat();
      //Core.inRange(img1, new Scalar(0, 155, 0), new Scalar(15, 255, 15), img2);
      if (!Thread.interrupted()){
        cvSink.grabFrame(img1);
        Core.inRange(img1, new Scalar(0, 75, 0), new Scalar(75, 255, 10), img2);
        List<MatOfPoint> contours = new ArrayList<>();
        MatOfPoint2f approxCurve = new MatOfPoint2f();
        Imgproc.findContours(img2, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);  
        Imgproc.cvtColor(img2, img2, Imgproc.COLOR_GRAY2BGR);
        Imgproc.drawContours(img2, contours, -1, new Scalar (0,255,0), 3);

        for (int i = 0; i<contours.size(); i++) {
          Imgproc.drawContours(img1, contours, i, new Scalar (255,255,0), 5);
          MatOfPoint2f contours2f = new MatOfPoint2f(contours.get(i).toArray());
          double approxDistance = Imgproc.arcLength(contours2f, true)*0.03;
          Imgproc.approxPolyDP(contours2f, approxCurve, approxDistance, true);
          MatOfPoint points = new MatOfPoint(approxCurve.toArray());
          Rect rect = Imgproc.boundingRect(points);
          Imgproc.rectangle(img2, new Point(rect.x,rect.y), new Point(rect.x+rect.width, rect.y+rect.height), new Scalar(255,0,255), 3);
        }

        //outputStream.putFrame(img2);
       // Imgcodecs.imwrite("C:\\Users\\Robotics\\Desktop\\final1.png", img2); 
      }
    }).start();
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
    /*
    Lift.frontHall.setPosition(0.0);
    Lift.rearHall.setPosition(0.0);
    Lift.initial = Lift.frontHall.getPosition();
    Lift.initial2 = Lift.rearHall.getPosition();
    */
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

