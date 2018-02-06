package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDElevate extends PIDCommand{

	public PIDElevate(double inches) {
		super(RobotMap.ElevatorP, RobotMap.ElevatorI, RobotMap.ElevatorD);
		
		setTimeout(inches/12);
		setSetpoint(inches); 
	}
	
	protected void initialize() {
	}
	
	@Override
	protected double returnPIDInput() {
		return CommandBase.elevator.getElevatorEncoder();
	}

	@Override
	protected void usePIDOutput(double speed) {
		CommandBase.elevator.elevate(20);;
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut() || Math.abs(getSetpoint() - getPosition()) < 1;
	}
	
	protected void end() {
		setTimeout(0);
	}
	
	protected void interrupted() {
		end();
	}
}
