package org.usfirst.frc.team2059.robot.commands;

public class Elevate extends CommandBase{
	
	double speed;
	
	public Elevate(double s) {
		speed = s;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		elevator.elevate(speed);
	}
	
	protected void end() {
	    elevator.elevate(0);
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
