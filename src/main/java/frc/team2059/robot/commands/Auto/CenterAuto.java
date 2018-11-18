package frc.team2059.robot.commands.Auto;

import frc.team2059.robot.AutoPaths;
import frc.team2059.robot.RobotMap;
import frc.team2059.robot.commands.Intake;
import frc.team2059.robot.commands.PIDElevate;
import frc.team2059.robot.commands.Drivetrain.PIDDrive;
import frc.team2059.robot.commands.Drivetrain.PIDTurn;
import frc.team2059.robot.commands.Drivetrain.PathDrive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup {

	public CenterAuto() {
		System.out.println(RobotMap.gameData.charAt(0));
		addParallel(new PIDElevate(RobotMap.SwitchHeight), 2);

		if (RobotMap.gameData.charAt(0) == 'L') {
			
			addSequential(new PathDrive(AutoPaths.toLeftSwitch, AutoPaths.configFast), 7);
			
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			
			addSequential(new PathDrive(AutoPaths.toRightSwitch, AutoPaths.configFast), 7);
		}
		
		addSequential(new Intake(1, 1), 1);
		addSequential(new PIDDrive(-60), 2.5);
		addSequential(new PIDElevate(0), 2);
		
		if (RobotMap.gameData.charAt(0) == 'L') {
			addParallel(new Intake(-1, -1), 5);
			addSequential(new PathDrive(AutoPaths.LeftToCubes, AutoPaths.configSlow), 3);
			
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			addParallel(new Intake(-1, -1), 5);
			addSequential(new PathDrive(AutoPaths.RightToCubes, AutoPaths.configSlow), 3);
		}
		
	}

}
