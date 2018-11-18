package frc.team2059.robot.commands.Drivetrain;

import hhCore.commands.drive.HHPIDDriveStraight;
import hhCore.subsystems.drive.HHSensorDrive;
import frc.team2059.robot.RobotMap;
import frc.team2059.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDDrive extends HHPIDDriveStraight {

	public PIDDrive(double inches) {
		super(inches, RobotMap.pDriveStraight, RobotMap.iDriveStraight, RobotMap.dDriveStraight);
		//super(inches, SmartDashboard.getNumber("pDriveStraight", 0), SmartDashboard.getNumber("iDriveStraight", 0), SmartDashboard.getNumber("dDriveStraight", 0));
		//System.out.println("kjh");
//		setMaxSpeed(.5);
	}

	@Override
	public HHSensorDrive getDriveBase() {
		return CommandBase.driveBase;
	}
}
