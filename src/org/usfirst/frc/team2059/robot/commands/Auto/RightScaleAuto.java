package org.usfirst.frc.team2059.robot.commands.Auto;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightScaleAuto extends CommandGroup{

	public RightScaleAuto() {
		
		addSequential(new PIDElevate(RobotMap.ScaleHeight), 3);
		
		if (RobotMap.gameData.charAt(1) == 'R') {
			addSequential(new PIDDrive(360), 4);
			addSequential(new Intake(1,1), 1);
			
		} else if (RobotMap.gameData.charAt(0) == 'L') {
			addSequential(new PIDDrive(200), 3);
			addSequential(new PIDTurn(-90), 2);
			addSequential(new PIDDrive(200), 3);
			addSequential(new PIDTurn(0), 2);
			addSequential(new PIDDrive(160), 2);
			addSequential(new Intake(1,1), 1);
		}
		
	}
	
}
