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
			new Waypoint(108, 48, Pathfinder.d2r(0))
	};

	public static Waypoint[] toRightSwitch = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(50, -55, Pathfinder.d2r(0)),
			new Waypoint(108, -52, Pathfinder.d2r(0))
	};
	
	public static Waypoint[] RightToCubes = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(72, 80, Pathfinder.d2r(40))
	};
	
	public static Waypoint[] LeftToCubes = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(72, -70, Pathfinder.d2r(-40))
	};
	
	public static Waypoint[] RightToRightScale = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(298, 0, Pathfinder.d2r(0)),
	};
	
	public static Waypoint[] RightToLeftScale = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(215, 0, Pathfinder.d2r(0)),
			new Waypoint(290, 190, Pathfinder.d2r(0))
	};
	
	public static Waypoint[] LeftToLeftScale = new Waypoint[] {
			new Waypoint(0, 0, Pathfinder.d2r(0)),
			new Waypoint(220, 0, Pathfinder.d2r(0)),
	};

//	public static Waypoint[] back = new Waypoint[] {
//			new Waypoint(0, 0, Pathfinder.d2r(0)),
//			new Waypoint(0, -20, Pathfinder.d2r(0))
//	};

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
	public static Trajectory.Config configFast = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
			Trajectory.Config.SAMPLES_FAST, 0.02, maxVelocity, 600, 1000.0);
	
	public static Trajectory.Config configSlow = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
			Trajectory.Config.SAMPLES_FAST, 0.02, maxVelocity, 400, 600.0);
	
}
