package org.usfirst.frc.team2059.robot.commands.Auto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Intake;
import org.usfirst.frc.team2059.robot.commands.PIDElevate;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.Drivetrain.PIDTurn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterAuto extends CommandGroup {

	public CenterAuto() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	
		
		try {
			System.out.println(RobotMap.gameData.charAt(0));
			
		} catch (Exception E) {
			System.out.println(E.toString());
//			try {
//				
////				BufferedWriter writer = new BufferedWriter(new FileWriter("/home/lvuser/"+ dateFormat.toString() + ".log"));
////				BufferedWriter writer = new BufferedWriter(new FileWriter(dateFormat.format(date)));
////				writer.write(E.toString());
////				writer.close();
//			
//			} catch (Exception D) {
//				System.out.println("cant make file");
//			}
		}
		
		
		try {
			
			addSequential(new PIDElevate(RobotMap.SwitchHeight), 2);
			addSequential(new PIDDrive(36), 1);
	
			if (RobotMap.gameData.charAt(0) == 'L') {
				addSequential(new PIDTurn(-90), 1.5);
				addSequential(new PIDDrive(36));
			} else if (RobotMap.gameData.charAt(0) == 'R') {
				addSequential(new PIDTurn(90), 1.5);
				addSequential(new PIDDrive(28));
			}
			
			addSequential(new PIDTurn(0), 2);
			addSequential(new PIDDrive(32), 2);
			addSequential(new Intake(1, 1), 1);
			addSequential(new PIDDrive(-40), 1);
			addSequential(new PIDElevate(0));
			
		}catch (Exception e) {
			System.out.println("ERROR: " + e.toString());
		}

	}

}
