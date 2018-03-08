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

	public static String gameData = "LLL";
	
	//Drivetrain
	public static int LeftMotor1 = 0;
	public static int LeftMotor2 = 1;
	public static int RightMotor1 = 2;
	public static int RightMotor2 = 3;
	
	public static int leftEncoder1 = 0;
	public static int leftEncoder2 = 1;
	public static int rightEncoder1 = 2;
	public static int rightEncoder2 = 3;
		
	public static double correction = .1;
	public static double deadzone = 0;
	
	public static double pDriveTurn = 0.0317;
	public static double iDriveTurn = 0.0;
	public static double dDriveTurn = 0.07;
	

	public static double pDriveStraight = 0.035;
	public static double iDriveStraight = 0.0;
	public static double dDriveStraight = 0.15;
	
	//Collector
	public static int collectorMotor1 = 4;
	public static int collectorMotor2 = 5;
	
	
	//Elevator
	public static int elevatorMotor1 = 6;
	public static int elevatorMotor2 = 7;
	
	public static int hallEffect1 = 4;
	public static int hallEffect2 = 5;
	
	public static int elevatorEncoder1 = 4;
	public static int elevatorEncoder2 = 5;
	
	public static double ElevatorP = .2;
	public static double ElevatorI = 0;
	public static double ElevatorD = 0;
	
	public static int SwitchHeight = 40;
	public static int ScaleHeight = 80;
	
	//Ramps
	public static int rampMotor = 8;
	
	//Vision
	public static int camera1 = 0;
	public static int camera2 = 1;
	
	//Pneumatics
	public static int compressor = 42;
	public static int spike = 0;
	
	public static int LeftRamp1 = 0;
	public static int LeftRamp2 = 1;
	public static int LeftRamp3 = 2;
	public static int LeftRamp4 = 3;

	public static int RightRamp1 = 4;
	public static int RightRamp2 = 5;
	public static int RightRamp3 = 6;
	public static int RightRamp4 = 7;
}
