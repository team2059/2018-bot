package org.usfirst.frc.team2059.robot.subsystems;

import hhCore.drive.HHSensorDrive;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.Drive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends HHSensorDrive {

	Spark leftMotor1  = new Spark(RobotMap.LeftMotor1);
	Spark leftMotor2 = new Spark(RobotMap.LeftMotor2);
	Spark rightMotor1 = new Spark(RobotMap.RightMotor1);
	Spark rightMotor2 = new Spark(RobotMap.RightMotor2);
	
	Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
	Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
	
	AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
	//Ultrasonic ultrasonic1 = new Ultrasonic(RobotMap.ultrasonic1, RobotMap.ultrasonic1);
	//Ultrasonic ultrasonic2 = new Ultrasonic(RobotMap.ultrasonic2, RobotMap.ultrasonic2);
	//Ultrasonic ultrasonic3 = new Ultrasonic(RobotMap.ultrasonic3, RobotMap.ultrasonic3);

	
	SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2);
	SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1, rightMotor2);

	DifferentialDrive robotDrive = new DifferentialDrive(left, right);

	public DriveBase() {
		setCorrection(RobotMap.correction);
		setDeadzone(RobotMap.deadzone);
		setxSensitivity(0.0);
		setySensitivity(0.0);
		setzSensitivity(0.0);
		setxHighSpeed(.8);
		setyHighSpeed(.8);
		setzHighSpeed(.8);
		//ultrasonic1.setAutomaticMode(true);
		//ultrasonic2.setAutomaticMode(true);
		//ultrasonic3.setAutomaticMode(true);
	}

	@Override
	public AnalogGyro gyro() {
		return gyro;
	}

	@Override
	public Encoder leftEncoder() {
		return leftEncoder;
	}

	@Override
	public Encoder rightEncoder() {
		return rightEncoder;
	}

	@Override
	public double getLeftEncoder() {
		return leftEncoder.get();
	}

	@Override
	public double getRightEncoder() {
		return rightEncoder.get();
	}

	@Override
	public double getGyro() {
		return gyro.getAngle() % 360;
	}
	
//	public double getUltrasonic1() {
//		return ultrasonic1.getRangeInches();
//	}
//	
//	public double getUltrasonic2() {
//		return ultrasonic2.getRangeInches();
//	}
//	
//	public double getUltrasonic3() {
//		return ultrasonic3.getRangeInches();
//	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	@Override
	public void driveBase(double x, double y) {
		robotDrive.arcadeDrive(y, x);
	}
}
