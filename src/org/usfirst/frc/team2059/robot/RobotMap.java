/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2059.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Drivetrain
	public static int LeftMotor1 = 0;
	public static int LeftMotor2 = 1;
	public static int RightMotor1 = 2;
	public static int RightMotor2 = 3;
	
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 1;
	public static int rightEncoder1 = 2;
	public static int rightEncoder2 = 3;
	
	public static int gyro = 1; 
	
	public static double correction = .1;
	public static double deadzone = .12;
	
	public static double Pconstant = 1;
	public static double Iconstant = 1;
	public static double Dconstant = 1;

	//Elevator
	public static int elevatorMotor1 = 4;
	public static int elevatorMotor2 = 5;
	
	//Collector
	public static int collectorMotor1 = 6;
	public static int collectorMotor2 = 7;
	
	//Vision
	public static int camera = 0;
}
