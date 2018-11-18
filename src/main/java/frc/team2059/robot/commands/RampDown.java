package frc.team2059.robot.commands;

public class RampDown extends CommandBase{

	double speed;
	public RampDown(double s) {
		speed = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		ramps.RampDown(speed);
	}
	
	protected void end() {
		ramps.RampEnd();
	}

	protected void interrupted() {
	   end();
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
}
