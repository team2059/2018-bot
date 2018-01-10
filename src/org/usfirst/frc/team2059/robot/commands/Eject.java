package org.usfirst.frc.team2059.robot.commands;

public class Eject extends CommandBase {

	double s;
	public Eject(double speed) {
		speed = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		collector.Collect(s);
	}
	
	protected void end() {
		collector.CollectEnd();
	}

	protected void interrupted() {
	  end();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
