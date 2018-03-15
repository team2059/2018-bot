package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.RobotMap;

public class Elevate extends CommandBase{
	
	double speed;
	
	public Elevate(double s) {
		speed = s;
	}
	
	protected void initialize() {
		RobotMap.pidElevatorValue = false;
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
		return false;
	}
	
}
