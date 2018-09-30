package org.usfirst.frc.team2059.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team2059.robot.AutoPaths;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.CommandBase;

public class PathDrive extends Command {

	private Trajectory trajectory;
	private TankModifier modifier;
	private EncoderFollower left, right;
	private int count = 0;
	private double l, r, gyro_heading, desired_heading, angleDifference, turn;

	public PathDrive(Waypoint[] waypoints, Trajectory.Config t) {
		trajectory = Pathfinder.generate(waypoints, t);
		modifier = new TankModifier(trajectory).modify(23);

		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getRightTrajectory());
//        left.configureEncoder(0, 100, 6);
//        right.configureEncoder(0, 100, 6);
		left.configureEncoder(CommandBase.driveBase.getLeftEncoderRaw(), 128, 5.75);
		right.configureEncoder(CommandBase.driveBase.getRightEncoderRaw(), 128, 5.75);

		// The first argument is the proportional gain. Usually this will be quite high
		// The second argument is the integral gain. This is unused for motion profiling
		// The third argument is the derivative gain. Tweak this if you are unhappy with the tracking of the trajectory
		// The fourth argument is the velocity ratio. This is 1 over the maximum velocity you provided in the
		//      trajectory configuration (it translates m/s to a -1 to 1 scale that your motors can read)
		// The fifth argument is your acceleration gain. Tweak this if you want to get to a higher or lower speed quicker

		left.configurePIDVA(RobotMap.straightLineP, RobotMap.straightLineI, RobotMap.straightLineD, 1 / AutoPaths.maxVelocity, 0);

		right.configurePIDVA(RobotMap.straightLineP, RobotMap.straightLineI, RobotMap.straightLineD, 1 / AutoPaths.maxVelocity, 0);

	}

	@Override
	protected void initialize() {

		CommandBase.driveBase.setIsPID(true);
		CommandBase.driveBase.resetLeftEncoder();
		CommandBase.driveBase.resetRightEncoder();

	}

	@Override
	protected void execute() {
		Trajectory.Segment seg = trajectory.get(count);
//        System.out.printf("%f,%f,%f,%f,%f,%f,%f,%f\n",
//                seg.dt, seg.x, seg.y, seg.position, seg.velocity,
//                seg.acceleration, seg.jerk, Pathfinder.boundHalfDegrees(Pathfinder.r2d(seg.heading)));
//
//        System.out.printf("l: %f, r: %f", modifier.getLeftTrajectory().get(count).position,
//                modifier.getRightTrajectory().get(count).position);

		l = left.calculate(CommandBase.driveBase.getLeftEncoderRaw());
		r = right.calculate(CommandBase.driveBase.getRightEncoderRaw());

		gyro_heading = CommandBase.driveBase.getGyro();
		desired_heading = -Pathfinder.r2d(left.getHeading());  // Should also be in degrees

		angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
		turn = 4.0 * (1.0/80.0) * angleDifference;

		CommandBase.driveBase.driveBaseTank(l + turn, r - turn);

		count++;
		System.out.println("left: " + l + " right: " + r);
		System.out.println("Angle Difference: " + angleDifference);
		System.out.println("turn value " + turn);
	}

	@Override
	protected void end() {
		CommandBase.driveBase.setIsPID(false);
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return count >= trajectory.length();
	}
}