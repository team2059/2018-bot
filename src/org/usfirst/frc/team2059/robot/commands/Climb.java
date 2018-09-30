package org.usfirst.frc.team2059.robot.commands;

public class Climb extends CommandBase{

	double speed;
	
	public Climb(double s) {
		speed = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		climber.Climb(speed);
	}
	
	protected void end() {
		climber.ClimbEnd();
	}

	protected void interrupted() {
	   end();
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

}
