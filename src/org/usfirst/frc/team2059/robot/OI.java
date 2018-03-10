/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2059.robot;

import org.usfirst.frc.team2059.robot.commands.Elevate;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.RampDown;
import org.usfirst.frc.team2059.robot.commands.SetLeftRampState;
import org.usfirst.frc.team2059.robot.commands.SetRightRampState;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private static Joystick box = new Joystick(2);
	
	JoystickButton button1d = new JoystickButton(driveJoystick, 1);
	JoystickButton button2d = new JoystickButton(driveJoystick, 2);

	
	JoystickButton button1 = new JoystickButton(auxJoystick, 1);
	JoystickButton button2 = new JoystickButton(auxJoystick, 2);
	JoystickButton button3 = new JoystickButton(auxJoystick, 3);
	JoystickButton button4 = new JoystickButton(auxJoystick, 4);
	JoystickButton button5 = new JoystickButton(auxJoystick, 5);
	JoystickButton button6 = new JoystickButton(auxJoystick, 6);
	JoystickButton button7 = new JoystickButton(auxJoystick, 7);
	JoystickButton button8 = new JoystickButton(auxJoystick, 8);
	JoystickButton button9 = new JoystickButton(auxJoystick, 9);
	JoystickButton button11 = new JoystickButton(auxJoystick, 11);
	JoystickButton button12 = new JoystickButton(auxJoystick, 12);

	JoystickButton button1b = new JoystickButton(box, 1);
	JoystickButton button2b = new JoystickButton(box, 2);
	JoystickButton button3b = new JoystickButton(box, 3);
	JoystickButton button4b = new JoystickButton(box, 4);
	
	public static Joystick getDriveJoystick() {
		return driveJoystick;
	}
	
	public static Joystick getBoxJoystic() {
		return box;
	}
	
	
	public OI() {

		button1.whileHeld(new Intake(1, 1));
		button3.whileHeld(new Intake(-1.0, -0.4));
		button4.whileHeld(new Intake(-0.4, -1.0));
		
		button6.whileHeld(new Elevate(1.0)); //Up
		button5.whileHeld(new Elevate(-1.0)); //Down

		//button7.whenPressed(new SetLeftRampState(true));
		//button8.whenPressed(new SetLeftRampState(false));
		button7.whileHeld(new RampDown(.5));
		button8.whileHeld(new RampDown(-.5));
		
		button1b.whenPressed(new SetRightRampState(true));
		button2b.whenPressed(new SetRightRampState(false));
		button3b.whenPressed(new SetLeftRampState(true));
		button4b.whenPressed(new SetLeftRampState(false));
		
		//button9.whenPressed(new SetRightRampState(true));
		//button12.whenPressed(new SetRightRampState(false));
		
		//button12.whenPressed(new PIDDrive(60));
		//button11.whenPressed(new PIDTurn(-90));
		
		button11.whenPressed(new PIDElevate(0));
		button12.whenPressed(new PIDElevate(40));
		button2.whenPressed(new PIDElevate(70));
		//button12.whenPressed(new PIDElevate(71));
		
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
