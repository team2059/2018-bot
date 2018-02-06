package org.usfirst.frc.team2059.robot.commands;

public class Intake extends CommandBase {

	double speed;
	public Intake(double s) {
		speed = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		collector.Collect(speed);
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
