/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.Elevate;
import org.usfirst.frc.team2059.robot.commands.Intake;
//import org.usfirst.frc.team2059.robot.commands.SetRampState;
import org.usfirst.frc.team2059.robot.commands.RampDown;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	private static Joystick driveJoystick = new Joystick(0);
	private static Joystick auxJoystick = new Joystick(1);
	
	JoystickButton button1 = new JoystickButton(driveJoystick, 1);
	JoystickButton button2 = new JoystickButton(driveJoystick, 2);
	JoystickButton button3 = new JoystickButton(driveJoystick, 3);
	JoystickButton button4 = new JoystickButton(driveJoystick, 4);
	JoystickButton button5 = new JoystickButton(driveJoystick, 5);
	JoystickButton button6 = new JoystickButton(driveJoystick, 6);
	JoystickButton button7 = new JoystickButton(driveJoystick, 7);
	JoystickButton button8 = new JoystickButton(driveJoystick, 8);
	
	public static Joystick getDriveJoystick() {
		return driveJoystick;
	}
	
	
	public OI() {
		button3.whileHeld(new Elevate(1));
		button4.whileHeld(new Elevate(-1));
		button1.whileHeld(new Intake(-1));
		button2.whileHeld(new Intake(1));
		button5.whileHeld(new RampDown(1));
		//button6.whileHeld(new SetRampState(true));
	}
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
