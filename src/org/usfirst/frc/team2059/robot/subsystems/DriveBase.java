package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveBase extends Subsystem{

	Spark LeftMotor1  = new Spark(RobotMap.LeftMotor1);
	Spark LeftMotor2 = new Spark(RobotMap.LeftMotor2);
	Spark RightMotor1 = new Spark(RobotMap.RightMotor1);
	Spark RightMotor2 = new Spark(RobotMap.RightMotor2);
	
	Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
	Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
	
	AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
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
		LeftMotor1.set(-y + x);
		LeftMotor2.set(-y + x);
		
		RightMotor1.set(y + x);
		RightMotor2.set(y + x);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
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
