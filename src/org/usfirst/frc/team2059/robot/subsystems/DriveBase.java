package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;


public class DriveBase{

	VictorSP LeftMotor1  = new VictorSP(RobotMap.LeftMotor1);
	VictorSP LeftMotor2 = new VictorSP(RobotMap.LeftMotor2);
	VictorSP RightMotor1 = new VictorSP(RobotMap.RightMotor1);
	VictorSP RightMotor2 = new VictorSP(RobotMap.RightMotor2);

	
	public void drive(double x, double y, double z) {
		drive(x + z, y);
	}
	
	public void drive(double x, double y) {
		LeftMotor1.set(-y + x);
		LeftMotor2.set(-y + x);
		
		RightMotor1.set(y + x);
		RightMotor2.set(y + x);
	}
}
