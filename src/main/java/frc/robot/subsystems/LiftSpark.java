package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.*;

import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class LiftSpark extends Subsystem {

  public static boolean moving;
  
  public static double[] height;// = {0.0, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0};
  public static CANSparkMax leftCasMotor = new CANSparkMax(RobotMap.frontPort, MotorType.kBrushless);//3
  public static CANSparkMax rightCasMotor = new CANSparkMax(RobotMap.rearPort, MotorType.kBrushless);//15
 
  //for the hall sensors
  public static CANEncoder leftLiftHall = leftCasMotor.getEncoder();
  public static CANEncoder rightLiftHall = rightCasMotor.getEncoder();
  public static CANPIDController controller = rightCasMotor.getPIDController();
  //The motors turn the negative direction for the cascade to go up --> hall sensor positions become more negative as the cascade goes higher
  public static int level = 0;
  public static double initposition;
  public static double maxposition;
  public static double safety = 2.5;

  public LiftSpark(){
    //leftCasMotor.follow(rightCasMotor);
  }

  // Put methods for controlling this subsystem here. 
  // Call these from Commands.
  public static void downToZero(){
    double downVel = 0.1;
    moving = true;
    while(-leftLiftHall.getPosition() > initposition+safety || -rightLiftHall.getPosition() > initposition+safety){
      //leftCasMotor.set(downVel);
      rightCasMotor.set(downVel);
    }
    //leftCasMotor.set(0.0);
    rightCasMotor.set(0.0);
    initposition = Math.min(-leftLiftHall.getPosition(), -rightLiftHall.getPosition());
    height = new double[] {
      initposition, //starting position
      //6 + initposition, //hatch 1 position
      19 + initposition, //cargo 1 position
      23 + initposition, //cargo ship cargo position
      28 + initposition, //hatch 2 position
      35 + initposition, //cargo 2 position
      50 + initposition, //hatch 3 position
      69 + initposition}; //cargo 3 position
    level = 0;
    moving = false;
  }

  public static void up(){
    double upVel = 0.25;
    moving = true;
    if(level < 6){
      System.out.println("going up");
      while((-leftLiftHall.getPosition() < height[level + 1] && -rightLiftHall.getPosition() < height[level + 1]) && Math.max(-leftLiftHall.getPosition(), -rightLiftHall.getPosition()) < maxposition) {
        //leftCasMotor.set(-upVel);
        rightCasMotor.set(-upVel);
      }
      //leftCasMotor.set(0);
      rightCasMotor.set(0);
      level++;
    }
    System.out.println("level: " + level);
    System.out.println("position: " + leftLiftHall.getPosition());
    moving = false;
  }

  public static void down(){
    double downVel = .1;
    moving = true;
    if (level > 0){
      System.out.println("going down");
      while((-leftLiftHall.getPosition() > height[level - 1] && -rightLiftHall.getPosition() > height[level-1]) && Math.min(-leftLiftHall.getPosition(),-rightLiftHall.getPosition()) > initposition+2.5) {
        //leftCasMotor.set(downVel);
        rightCasMotor.set(downVel);
      }
      //leftCasMotor.set(0);
      rightCasMotor.set(0);
      level--;
    }
    System.out.println("level: " + level);
    System.out.println("position: " + leftLiftHall.getPosition());
    moving = false;
  }

  public static void printPosition(){
    System.out.println("position: " + leftLiftHall.getPosition());
    //System.out.println("position variable: " + position);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new KeepCascadeUp());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}