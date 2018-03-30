package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.AutoPaths;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PathDrive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup {

	public CenterAuto() {
		System.out.println(RobotMap.gameData.charAt(0));
		addParallel(new PIDElevate(RobotMap.SwitchHeight), 2);
		if (RobotMap.gameData.charAt(0) == 'L') {
			addSequential(new PathDrive(AutoPaths.toLeftSwitch), 7);
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			addSequential(new PathDrive(AutoPaths.toRightSwitch), 7);
		}
		addSequential(new Intake(1, 1), 1);
		addSequential(new PIDDrive(-30), 2);
		addSequential(new PIDElevate(0), 2);
	}

}