package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.subsystems.Collector;
import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import org.usfirst.frc.team2059.robot.subsystems.Elevator;
import org.usfirst.frc.team2059.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveBase driveBase;
	public static Elevator elevator;
	public static Collector collector;
	//public static Pneumatics pneumatics;
	
	public static void init() {
	    driveBase = new DriveBase();
	    elevator = new Elevator();
	    collector = new Collector();
	    //pneumatics = new Pneumatics();
	  }
}
