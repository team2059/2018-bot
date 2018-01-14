package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDTurn extends PIDCommand {

	public PIDTurn(double angle) {
		super(RobotMap.Pconstant + 1, RobotMap.Iconstant + 1, RobotMap.Dconstant + 1);

		setTimeout(angle/30);
		setSetpoint(angle);
	}
	
	@Override
	protected double returnPIDInput() {
		return CommandBase.driveBase.getGyro();
	}

	@Override
	protected void usePIDOutput(double speed) {
		CommandBase.driveBase.drive(speed, 0);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(getSetpoint()-getPosition()) < 1 || isTimedOut();
	}

}
