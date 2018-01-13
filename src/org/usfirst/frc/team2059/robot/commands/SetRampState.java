package org.usfirst.frc.team2059.robot.commands;

public class SetRampState extends CommandBase{

	boolean state;
	public SetRampState(boolean s) {
		state = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		pneumatics.setRightRampState(state);
		pneumatics.setLeftRampState(state);
	}
	
	protected void end() {
		pneumatics.setRightRampState(!state);
		pneumatics.setLeftRampState(!state);
	}
	
	protected void interrupted() {
		end();
	}
	@Override
	protected boolean isFinished() {
		return false;
	}

}
