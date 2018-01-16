package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

public class Elevator {
	Spark elevatorMotor1 = new Spark(RobotMap.elevatorMotor1);
	Spark elevatorMotor2 = new Spark(RobotMap.elevatorMotor2);
	
	DigitalInput hallEffect1 = new DigitalInput(RobotMap.hallEffect1);
	DigitalInput hallEffect2 = new DigitalInput(RobotMap.hallEffect2);
	
	Encoder elevatorEncoder = new Encoder(RobotMap.elevatorEncoder1, RobotMap.elevatorEncoder2);
	
	public void elevate(double s) {
		elevatorMotor1.set(s);
		elevatorMotor2.set(-s);
		
		if(hallEffect1.get() == true) {
			
		}
	}
	
	public void elevateEnd() {
		elevatorMotor1.set(0);
		elevatorMotor2.set(0);
	}
	
	public Encoder elevatorEncoder() {
		return elevatorEncoder;
	}

	public double getElecatorEncoder() {
		return elevatorEncoder.get();
	}
}
