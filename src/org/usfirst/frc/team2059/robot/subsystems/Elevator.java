package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

public class Elevator {
	VictorSP elevatorMotor1 = new VictorSP(RobotMap.elevatorMotor1);
	VictorSP elevatorMotor2 = new VictorSP(RobotMap.elevatorMotor2);
	
	public void elevate(double s) {
		elevatorMotor1.set(s);
		elevatorMotor2.set(-s);
	}
	
	public void elevateEnd() {
		elevatorMotor1.set(0);
		elevatorMotor2.set(0);
	}
}
