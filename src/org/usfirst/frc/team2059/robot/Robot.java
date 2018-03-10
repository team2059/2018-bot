/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2059.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.Auto.CenterAuto;
import org.usfirst.frc.team2059.robot.commands.Auto.DriveStraingAuto;
import org.usfirst.frc.team2059.robot.commands.Auto.LeftAuto;
import org.usfirst.frc.team2059.robot.commands.Auto.RightAuto;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	
	Command m_autonomousCommand;
	SendableChooser<RobotMap.Auto> m_chooser = new SendableChooser<>();
	
	public static UsbCamera camera1;
	public static UsbCamera camera2;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialgization code.
	 */
	@Override
	public void robotInit() {
		
		CommandBase.init();
		
		CommandBase.driveBase.resetLeftEncoder();
		CommandBase.driveBase.resetRightEncoder();	
		
		camera1 = CameraServer.getInstance().startAutomaticCapture("Camera1", RobotMap.camera1);
		camera1.setBrightness(50);
		camera2 = CameraServer.getInstance().startAutomaticCapture("Camera2", RobotMap.camera2);
		camera2.setBrightness(50);
		
		oi = new OI();
		m_chooser.addDefault("Default", RobotMap.Auto.DONOTHING);
		m_chooser.addObject("Drive Straight", RobotMap.Auto.DRIVESTRAIGHT);
		m_chooser.addObject("Left Auto", RobotMap.Auto.LEFT);
		m_chooser.addObject("Right Auto", RobotMap.Auto.RIGHT);
		m_chooser.addObject("Center Auto", RobotMap.Auto.CENTER);
		SmartDashboard.putData("Auto mode", m_chooser);
 	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		CommandBase.driveBase.resetGyro();
		try {
			RobotMap.gameData = DriverStation.getInstance().getGameSpecificMessage();
		} catch (Exception exception) {
			System.out.println("Game Data not available!");
		}
		CommandBase.elevator.setElevatorEncoder(0);

		switch (m_chooser.getSelected()) {
			case DRIVESTRAIGHT:
				m_autonomousCommand = new DriveStraingAuto();
				break;
			case LEFT:
				m_autonomousCommand = new LeftAuto();
				break;
			case CENTER:
				m_autonomousCommand = new CenterAuto();
				break;
			case RIGHT:
				m_autonomousCommand = new RightAuto();
				break;
			case DONOTHING:
			default:
				m_autonomousCommand = null;
				break;
		}


		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder Value", CommandBase.driveBase.getLeftEncoder());
		SmartDashboard.putNumber("Right Encoder Value", CommandBase.driveBase.getRightEncoder());
		SmartDashboard.putNumber("Gyro Angle", CommandBase.driveBase.getGyro());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		CommandBase.pneumatics.setCompressorEnabled(true);
		
		CommandBase.driveBase.setIsPID(false);		
		CommandBase.driveBase.resetLeftEncoder();
		CommandBase.driveBase.resetRightEncoder();
		CommandBase.driveBase.resetGyro();
		//CommandBase.elevator.resetElevatorEncoder();
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
		SmartDashboard.putNumber("CollectorRight", 0);
		SmartDashboard.putNumber("CollectorLeft", 0);
//		SmartDashboard.putNumber("pDriveStraight", RobotMap.pDriveStraight);
//		SmartDashboard.putNumber("iDriveStraight", RobotMap.iDriveStraight);
//		SmartDashboard.putNumber("dDriveStraight", RobotMap.dDriveStraight);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Left Encoder Value", CommandBase.driveBase.getLeftEncoder());
		SmartDashboard.putNumber("Right Encoder Value", CommandBase.driveBase.getRightEncoder());
		SmartDashboard.putNumber("Gyro Angle", CommandBase.driveBase.getGyro());
		SmartDashboard.putBoolean("Hall Effect Bottom", CommandBase.elevator.getHallEffectBottom());
		SmartDashboard.putBoolean("Hall Effect Top", CommandBase.elevator.getHallEffectTop());
		//SmartDashboard.putBoolean("Hall Effect 2", CommandBase.elevator.getHallEffect2());
		SmartDashboard.putNumber("Elevator Encoder Value", CommandBase.elevator.getElevatorEncoder());
		SmartDashboard.putBoolean("Compressor", CommandBase.pneumatics.getCompressorEnabled());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
