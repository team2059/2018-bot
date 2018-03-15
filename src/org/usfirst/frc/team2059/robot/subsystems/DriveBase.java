package org.usfirst.frc.team2059.robot.subsystems;

import hhCore.subsystems.drive.HHSensorDrive;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends HHSensorDrive {
	
	WPI_VictorSPX leftMotor1  = new WPI_VictorSPX(RobotMap.LeftMotor1);
	WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(RobotMap.LeftMotor2);
	WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(RobotMap.RightMotor1);
	WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(RobotMap.RightMotor2);
	
	Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
	Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
	
	//AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
	ADXRS450_Gyro gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
	
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
		gyro.calibrate();
	}

	@Override
	public ADXRS450_Gyro gyro() {
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
		return leftEncoder.get() / 6.88;
	}

	@Override
	public double getRightEncoder() {
		return -rightEncoder.get() / 6.88;
	}

	public int getLeftEncoderRaw() {
		return leftEncoder.get();
	}

	public int getRightEncoderRaw() {
		return -rightEncoder.get();
	}

	@Override
	public double getGyro() {
		return gyro.getAngle() % 360;
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	@Override
	public void driveBase(double x, double y) {
		robotDrive.arcadeDrive(y, x);
	}

	public void driveBaseTank(double left, double right) {
		if (isPID()) {
			robotDrive.tankDrive(left, right);
		}
	}
	
}
