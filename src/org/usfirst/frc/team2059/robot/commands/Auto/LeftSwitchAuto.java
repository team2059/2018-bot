package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitchAuto extends CommandGroup{
	
	public LeftSwitchAuto() {
			
		if (RobotMap.gameData.charAt(0) == 'R') {
			
			addSequential(new PIDDrive(120), 2);
			
		} else if (RobotMap.gameData.charAt(0) == 'L') {
			
			addParallel(new PIDElevate(RobotMap.SwitchHeight));
			addSequential(new PIDDrive(80), 2);
			addSequential(new PIDTurn(90), 1.5);
			addSequential(new PIDDrive(20));
			addSequential(new Intake(1, 1), 1);
		}
		
	}

}
