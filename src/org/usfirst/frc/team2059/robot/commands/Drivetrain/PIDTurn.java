package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDTurn extends PIDCommand {

	public PIDTurn() {
		super(RobotMap.Pconstant, RobotMap.Iconstant, RobotMap.Dconstant);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return CommandBase.driveBase.getGyro();
	}

	@Override
	protected void usePIDOutput(double speed) {
		// TODO Auto-generated method stub
		CommandBase.driveBase.drive(speed, 0);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(getSetpoint()-getPosition()) < 1;
	}

}
