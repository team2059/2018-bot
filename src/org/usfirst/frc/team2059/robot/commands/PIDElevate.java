package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDElevate extends PIDCommand{

	public PIDElevate(double inches) {
		super(RobotMap.ElevatorP, RobotMap.ElevatorI, RobotMap.ElevatorD);
		
		setTimeout(inches*2000);
		setSetpoint(inches); 
		System.out.println(inches);
	}
	
	protected void initialize() {
		System.out.println("Started");
	}
	
	@Override
	protected double returnPIDInput() {
		return CommandBase.elevator.getElevatorEncoder();
	}

	@Override
	protected void usePIDOutput(double speed) {
//		CommandBase.elevator.elevate(speed);
	}

	@Override
	protected boolean isFinished() {
		System.out.println(Math.abs(getSetpoint() - getPosition()));
		
		return Math.abs(getSetpoint() - getPosition()) < .1;
	}
	
	protected void end() {
		System.out.println("ended");
		setTimeout(0);
	}
	
	protected void interrupted() {
		end();
	}
}
