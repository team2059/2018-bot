package org.usfirst.frc.team2059.robot.commands.Drivetrain;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.OI;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.commands.CommandBase;

public class Drive extends CommandBase{

	public Drive() {
		requires(driveBase);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
