package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;


public class PIDDrive extends PIDCommand {

	public PIDDrive(double inches) {
		super(RobotMap.Pconstant, RobotMap.Iconstant, RobotMap.Dconstant);
		
		setTimeout(inches/12);
		setSetpoint(inches);
	}
	
	protected void initialize() {
		CommandBase.driveBase.resetLeftEncoder();
		CommandBase.driveBase.resetRightEncoder();
	}
	
	@Override
	protected double returnPIDInput() {
		return CommandBase.driveBase.getLeftEncoder();
	}

	@Override
	protected void usePIDOutput(double speed) {
		CommandBase.driveBase.driveForward(speed);
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
