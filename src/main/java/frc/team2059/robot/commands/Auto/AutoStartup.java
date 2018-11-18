package frc.team2059.robot.commands.Auto;

import frc.team2059.robot.RobotMap;
import frc.team2059.robot.commands.RampDown;
import frc.team2059.robot.commands.CommandBase;
import frc.team2059.robot.commands.PIDElevate;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStartup extends CommandGroup {

	public AutoStartup(double elevatorHeight) {
		addSequential(new RampDown(0.2), 0.1);
		addSequential(new PIDElevate(elevatorHeight), 2);
		CommandBase.driveBase.resetGyro();
	}
}
