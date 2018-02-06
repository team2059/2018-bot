package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import hhCore.sensors.ElevatorEncoder;


public class Elevator {
	WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(RobotMap.elevatorMotor1);
	
	//DigitalInput hallEffect1 = new DigitalInput(RobotMap.hallEffect1);
	//DigitalInput hallEffect2 = new DigitalInput(RobotMap.hallEffect2);
	
	ElevatorEncoder elevatorEncoder = new ElevatorEncoder(RobotMap.elevatorEncoder1, RobotMap.elevatorEncoder2);
	
	public void elevate(double s) {
		elevatorMotor.set(s);
		
//		if(hallEffect1.get() == true) {
//			elevatorEncoder.setPosition(12);
//		}
//		
//		if(hallEffect2.get() == true) {
//			elevatorEncoder.setPosition(48);
//		}
	}
	
	public void elevateEnd() {
		elevatorMotor.set(0);
	}
	
	public Encoder elevatorEncoder() {
		return elevatorEncoder;
	}

	public double getElevatorEncoder() {
		return elevatorEncoder.get();
	}
	
}
