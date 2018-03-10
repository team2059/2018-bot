package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup {

	public CenterAuto() {
		System.out.println(RobotMap.gameData.charAt(0));
		addParallel(new PIDElevate(RobotMap.SwitchHeight), 2);
	 	addParallel(new AutoStartup(RobotMap.SwitchHeight));
		addSequential(new PIDDrive(36), 2);

		if (RobotMap.gameData.charAt(0) == 'L') {
			addSequential(new PIDTurn(-90), 1.5);
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			addSequential(new PIDTurn(90), 1.5);
		}

		addSequential(new PIDDrive(32), 2);
		addSequential(new PIDTurn(0), 2);
		addSequential(new PIDDrive(32), 2);
		addSequential(new Intake(1, 1), 1);
	}

}
