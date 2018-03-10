package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraingAuto extends CommandGroup {

	public DriveStraingAuto() {
		
		addSequential(new PIDDrive(120), 2);
		
	}
	
}
