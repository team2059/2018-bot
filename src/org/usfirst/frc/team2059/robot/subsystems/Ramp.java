package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Ramp {

	WPI_VictorSPX rampMotor = new WPI_VictorSPX(RobotMap.rampMotor);
	
	public void RampDown(double s) {
		rampMotor.set(s);
	}
	
	public void RampEnd() {
		rampMotor.set(0);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
