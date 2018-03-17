package org.usfirst.frc.team2059.robot.commands.Auto;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScaleAuto extends CommandGroup{

	public LeftScaleAuto() {
		
		addSequential(new PIDElevate(RobotMap.ScaleHeight), 3);
		
		if (RobotMap.gameData.charAt(1) == 'L') {
			
			addSequential(new PIDDrive(298), 4);
			addSequential(new Intake(1,1), 1);
			addSequential(new PIDDrive(-20), 1);
			addSequential(new PIDElevate(0));
			
		} else if (RobotMap.gameData.charAt(1) == 'R') {
			
			addSequential(new PIDDrive(215), 3);
			addSequential(new PIDTurn(90), 2);
			addSequential(new PIDDrive(190), 3);			
			addSequential(new PIDTurn(0), 2);
			addSequential(new PIDDrive(83), 2);
			addSequential(new Intake(1,1), 1);
			addSequential(new PIDDrive(-20), 1);
			addSequential(new PIDElevate(0));
			
		}
	}
}
