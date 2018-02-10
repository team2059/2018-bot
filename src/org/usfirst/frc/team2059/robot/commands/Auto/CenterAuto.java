package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Elevate;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup{
	
	public CenterAuto() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		addParallel(new Elevate(RobotMap.SwitchHeight));
		addSequential(new PIDDrive(30));
		
		if (gameData.charAt(0) == 'L') {
			addSequential(new PIDTurn(270));
		}
		else if (gameData.charAt(0) == 'R') {
			addSequential(new PIDTurn(90));
		}
		
		addSequential(new PIDDrive(20));
		addSequential(new PIDTurn(0));
		addSequential(new PIDDrive(20));
		addSequential(new Intake(-1));
	}

}
