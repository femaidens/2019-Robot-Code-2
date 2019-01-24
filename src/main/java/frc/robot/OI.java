/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * Add your docs here.
 */
public class OI {
    public static Joystick atkJoy1 = new Joystick(RobotMap.joyPort1);
    
    //public static Joystick atkJoy2 = new Joystick(RobotMap.joyPort2);

    public static Button hatch = new JoystickButton(atkJoy1, 3);
    public static Button testCounter = new JoystickButton(atkJoy1, 5);

    //public static Button cargoIn = new JoystickButton(atkJoy1, 5);
    /*public static Button cargoOut = new JoystickButton(atkJoy1, 6);

    public static Button cargoPiston = new JoystickButton(atkJoy1, 7);

    public static Button liftUp = new JoystickButton(atkJoy1, 8);
    public static Button liftDown = new JoystickButton(atkJoy1, 9);

    public static Button frontClimb = new JoystickButton(atkJoy1, 10);
    public static Button rearClimb = new JoystickButton(atkJoy1, 11);
*/

    public static void bindButtons(){
        //hatch.whenPressed(new HatchIntakeCom());
        testCounter.whenPressed(new PrintTest());
        
        //cargoIn.whileHeld(new CargoIn());
        /*cargoOut.whileHeld(new CargoOut());
        cargoPiston.whenPressed(new CargoPiston());

        liftUp.whenPressed(new RocketUp());
        liftDown.whenPressed(new RocketDown());

        frontClimb.whenPressed(new FrontClimb());
        rearClimb.whenPressed(new RearClimb());
        */
    } 
}
