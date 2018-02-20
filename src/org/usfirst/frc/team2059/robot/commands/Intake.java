package org.usfirst.frc.team2059.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends CommandBase {

	double speedL;
	double speedR;
	public Intake(double sL, double sR) {
		speedL = sL;
		speedR = sR;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		collector.Collect(speedL, speedR);
	}
	
	protected void end() {
		collector.CollectEnd();
	}

	protected void interrupted() {
	   end();
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

}
