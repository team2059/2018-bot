package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.Drive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveBase extends Subsystem{

	Spark leftMotor1  = new Spark(RobotMap.LeftMotor1);
	Spark leftMotor2 = new Spark(RobotMap.LeftMotor2);
	Spark rightMotor1 = new Spark(RobotMap.RightMotor1);
	Spark rightMotor2 = new Spark(RobotMap.RightMotor2);
	
	Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
	Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
	
	AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
	SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2);
	SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1, rightMotor2);

	DifferentialDrive robotDrive = new DifferentialDrive(left, right);
	
	public void resetLeftEncoder() {
		leftEncoder.reset();
	}
	
	public void resetRightEncoder() {
		rightEncoder.reset();
	}
	
	public void resetGyro() {
	    gyro.reset();
	}
	
	public double getLeftEncoder() {
		return leftEncoder.get();
	}
	
	public double getRightEncoder() {
		return rightEncoder.get();
	}
	
	public double getGyro() {
		return gyro.getAngle();
	}
	
	public void drive(double x, double y, double z) {
		drive(x + z, y);
	}
	
	public void drive(double x, double y) {
		robotDrive.arcadeDrive(y * .8, x * .8);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	public void deadzoneDrive(double x, double y, double z) {
		if (Math.abs(x) < RobotMap.deadzone || Math.abs(y) < RobotMap.deadzone) {
			drive(0, 0, 0);
		}else {
			drive(x , y, z);
		}
	}
	
	public void driveForward(double speed) {
		if (getRightEncoder() - getLeftEncoder() > 1)
		{
			drive(RobotMap.correction, speed);
		}
		else if (getLeftEncoder() - getRightEncoder() > 1) 
		{
			drive(-RobotMap.correction, speed);
		}
		else
		{
			drive(0, speed);
		}
	}

}
