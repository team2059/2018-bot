package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class Elevator {
	WPI_VictorSPX elevatorMotor1 = new WPI_VictorSPX(RobotMap.elevatorMotor1);
	WPI_VictorSPX elevatorMotor2 = new WPI_VictorSPX(RobotMap.elevatorMotor2);
	
	//DigitalInput hallEffect1 = new DigitalInput(RobotMap.hallEffect1);
	//DigitalInput hallEffect2 = new DigitalInput(RobotMap.hallEffect2);
	
	Encoder elevatorEncoder = new Encoder(RobotMap.elevatorEncoder1, RobotMap.elevatorEncoder2);
	
	public void elevate(double s) {
		elevatorMotor1.set(s);
		elevatorMotor2.set(-s);
		
		//if(hallEffect1.get() == true) {
		//	
		//}
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
