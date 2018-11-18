package frc.team2059.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team2059.robot.subsystems.DriveBase;

import frc.team2059.robot.OI;
import frc.team2059.robot.Robot;
import frc.team2059.robot.commands.CommandBase;

public class Drive extends CommandBase{

	public Drive() {
		requires(driveBase);
	}
	
	protected void initialize() {
	}
	
	public void execute() {
		driveBase.drive(OI.getDriveJoystick().getRawAxis(0), -OI.getDriveJoystick().getRawAxis(1), OI.getDriveJoystick().getRawAxis(2));
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
}
