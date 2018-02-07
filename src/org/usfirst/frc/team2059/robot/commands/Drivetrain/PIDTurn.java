package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import hhCore.commands.drive.HHPIDDriveTurn;
import hhCore.subsystems.drive.HHSensorDrive;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;

public class PIDTurn extends HHPIDDriveTurn {

	PIDTurn(double angle) {
		super(angle, RobotMap.pDriveTurn, RobotMap.iDriveTurn, RobotMap.dDriveTurn);
	}

	@Override
	public HHSensorDrive getDriveBase() {
		return CommandBase.driveBase;
	}
}
