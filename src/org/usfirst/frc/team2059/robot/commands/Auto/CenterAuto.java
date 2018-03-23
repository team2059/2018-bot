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
		//addSequential(new PIDDrive(36), 1);

		if (RobotMap.gameData.charAt(0) == 'L') {
			
			//addSequential(new PIDTurn(-90), 1.5);
			addSequential(new PathDrive(AutoPaths.toLeftSwitch));
			
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			
			addSequential(new PathDrive(AutoPaths.toRightSwitch));
			
		}

		//addSequential(new PIDDrive(32), 2);
		//addSequential(new PIDTurn(0), 2);
		//addSequential(new PIDDrive(32), 2);
		//addSequential(null, .3);
		
		addSequential(new Intake(-1, -1), 1);
		
		//addSequential(new PathDrive(AutoPaths.back));
		
		//addSequential(new PIDElevate(0), 2);
	}

}
