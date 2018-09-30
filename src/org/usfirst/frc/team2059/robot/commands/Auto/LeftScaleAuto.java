package org.usfirst.frc.team2059.robot.commands.Auto;
import org.usfirst.frc.team2059.robot.AutoPaths;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PathDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScaleAuto extends CommandGroup{

	public LeftScaleAuto() {
		
		addParallel(new PIDElevate(RobotMap.SwitchHeight), 3);
		
		if (RobotMap.gameData.charAt(1) == 'L') {
			
			addSequential(new PathDrive(AutoPaths.LeftToLeftScale, AutoPaths.configSlow), 7);
			addSequential(new PIDElevate(RobotMap.ScaleHeight), 1);
			addSequential(new PIDTurn(45));
			addSequential(new Intake(1, 1), 2);

			//addSequential(new Intake(1,1), 1);
			//addSequential(new PIDDrive(-20), 1);
			//addSequential(new PIDElevate(0));
			
		} else if (RobotMap.gameData.charAt(0) == 'R') {
			
			
			//addSequential(new PathDrive(AutoPaths.RightToLeftScale, AutoPaths.configSlow));
			
			//addSequential(new Intake(1,1), 1);
			//addSequential(new PIDDrive(-20), 1);
			//addSequential(new PIDElevate(0));
		}
	}
}
