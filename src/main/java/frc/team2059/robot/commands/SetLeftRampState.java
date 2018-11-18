package frc.team2059.robot.commands;

public class SetLeftRampState extends CommandBase{

	boolean state;
	public SetLeftRampState(boolean s) {
		state = s;
	}
	
	protected void initialize() {
	}
	
//	protected void execute() {
//		pneumatics.setLeftRampState(state);
//	}
//	
//	protected void end() {
//		pneumatics.setLeftRampState(!state);
//	}
//	
	protected void interrupted() {
		end();
	}
	@Override
	protected boolean isFinished() {
		return true;
	}

}
