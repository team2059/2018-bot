package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {

	WPI_VictorSPX collectorMotor1 = new WPI_VictorSPX(RobotMap.collectorMotor1);
	WPI_VictorSPX collectorMotor2 = new WPI_VictorSPX(RobotMap.collectorMotor2);
	
	public void Collect(double s) {
		collectorMotor1.set(s);
		collectorMotor2.set(-s*.8);
	}
	
	public void CollectEnd() {
		collectorMotor1.set(0);
		collectorMotor2.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
