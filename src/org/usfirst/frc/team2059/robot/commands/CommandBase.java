package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static DriveBase driveBase;
	
	public static void init() {
	    driveBase = new DriveBase();
	    
	  }
}
