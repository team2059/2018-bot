package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import hhCore.commands.drive.HHPIDDriveStraight;
import hhCore.subsystems.drive.HHSensorDrive;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;

public class PIDDrive extends HHPIDDriveStraight {

	public PIDDrive(double inches) {
		super(inches, RobotMap.pDriveStraight, RobotMap.iDriveStraight, RobotMap.dDriveStraight);
		System.out.println("kjh");
	}

	@Override
	public HHSensorDrive getDriveBase() {
		return CommandBase.driveBase;
	}
}
