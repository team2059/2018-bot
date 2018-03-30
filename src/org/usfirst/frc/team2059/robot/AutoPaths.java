package org.usfirst.frc.team2059.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;


public class AutoPaths {

	public static int maxVelocity = 100;

	public static Waypoint[] driveForward = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(60, 0, Pathfinder.d2r(0))
	};

	public static Waypoint[] toLeftSwitch = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(50, 48, Pathfinder.d2r(0)),
			new Waypoint(95, 48, Pathfinder.d2r(0))
	};

	public static Waypoint[] toRightSwitch = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(50, -52, Pathfinder.d2r(0)),
			new Waypoint(95, -52, Pathfinder.d2r(0))
	};

	public static Waypoint[] back = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(0, -20, Pathfinder.d2r(0))
	};

	// Create the Trajectory Configuration
	//
	// Arguments:
	// Fit Method:          HERMITE_CUBIC or HERMITE_QUINTIC
	// Sample Count:        SAMPLES_HIGH (100 000)
	//                      SAMPLES_LOW  (10 000)
	//                      SAMPLES_FAST (1 000)
	// Time Step:           0.05 Seconds
	// Max Velocity:        1.7 in/s
	// Max Acceleration:    2.0 in/s/s
	// Max Jerk:            60.0 in/s/s/s
	public static Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
			Trajectory.Config.SAMPLES_FAST, 0.02, maxVelocity, 400, 500.0);
}