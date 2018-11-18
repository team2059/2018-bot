package frc.team2059.robot.commands;

public class SetRightRampState extends CommandBase{

	boolean state;
	public SetRightRampState(boolean s) {
		state = s;
	}
	
	protected void initialize() {
	}
	
//	protected void execute() {
//		pneumatics.setRightRampState(state);
//	}
//	
//	protected void end() {
//		pneumatics.setRightRampState(!state);
//	}
	
	protected void interrupted() {
		end();
	}
	@Override
	protected boolean isFinished() {
		return true;
	}
}
