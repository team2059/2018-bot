package org.usfirst.frc.team2059.robot.subsystems;

import edu.wpi.first.networktables.*;

public class VisionHelper {
	
	NetworkTableInstance inst = NetworkTableInstance.getDefault();
	NetworkTable table = inst.getTable("dataTable");
	NetworkTableEntry robotState;
	NetworkTableEntry angleEntry = table.getEntry("");
	NetworkTableEntry distEntry = table.getEntry("dist");
	
	public void startVisionHelper() {
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
	
	public void setRobotState(String state) {
		robotState.forceSetString(state);
	}

}
