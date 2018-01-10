package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem {

	Spark collectorMotor1 = new Spark(RobotMap.collectorMotor1);
	Spark collectorMotor2 = new Spark(RobotMap.collectorMotor2);
	
	public void Collect(double s) {
		collectorMotor1.set(s);
		collectorMotor2.set(s);
	}
	
	public void CollectEnd() {
		collectorMotor1.set(0);
		collectorMotor1.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
