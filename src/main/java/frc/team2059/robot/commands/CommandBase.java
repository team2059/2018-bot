package frc.team2059.robot.commands;

import frc.team2059.robot.subsystems.Climber;
import frc.team2059.robot.subsystems.Collector;
import frc.team2059.robot.subsystems.DriveBase;
import frc.team2059.robot.subsystems.Elevator;
import frc.team2059.robot.subsystems.Pneumatics;
import frc.team2059.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveBase driveBase;
	public static Elevator elevator;
	public static Collector collector;
	public static Pneumatics pneumatics;
	public static Ramp ramps;
	public static Climber climber;
	
	public static void init() {
	    driveBase = new DriveBase();
	    elevator = new Elevator();
	    collector = new Collector();
	    pneumatics = new Pneumatics();
	    ramps = new Ramp();
	    climber = new Climber();
	  }
}
