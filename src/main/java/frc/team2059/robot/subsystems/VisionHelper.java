package frc.team2059.robot.subsystems;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionHelper extends Subsystem{
	
	NetworkTableInstance inst = NetworkTableInstance.getDefault();
	NetworkTable table = inst.getTable("dataTable");
	NetworkTableEntry angleEntry = table.getEntry("");
	NetworkTableEntry distEntry = table.getEntry("");
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public VisionHelper() {
		inst.startClientTeam(2059);
		inst.startDSClient();
		
	}
	
	
	
	public double getAngle() {
		return angleEntry.getDouble(0.0);
	}
	
	public double getDistance() {
		return distEntry.getDouble(0.0);
	}
	
	public double getDistanceFromStop() {
		return 1;
	}

}
