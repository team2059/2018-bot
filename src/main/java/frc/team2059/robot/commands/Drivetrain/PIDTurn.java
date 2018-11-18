package frc.team2059.robot.commands.Drivetrain;

import hhCore.commands.drive.HHPIDDriveTurn;
import hhCore.subsystems.drive.HHSensorDrive;
import frc.team2059.robot.RobotMap;
import frc.team2059.robot.commands.CommandBase;

public class PIDTurn extends HHPIDDriveTurn {

	public PIDTurn(double angle) {
		super(angle, RobotMap.pDriveTurn, RobotMap.iDriveTurn, RobotMap.dDriveTurn);
		//System.out.println("PID Turn is activating");
	}
	
	public PIDTurn(double angle, String s) {
		super(angle, RobotMap.pDriveTurn, RobotMap.iDriveTurn, RobotMap.dDriveTurn);
		//System.out.println("PID Turn is activating");
	}

	@Override
	public HHSensorDrive getDriveBase() {
		return CommandBase.driveBase;
	}
}
