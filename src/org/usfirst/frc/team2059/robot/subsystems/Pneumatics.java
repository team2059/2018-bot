package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	Compressor compressor = new Compressor(RobotMap.compressor);
	DoubleSolenoid leftRamp = new DoubleSolenoid(RobotMap.compressor, RobotMap.LeftRamp1, RobotMap.LeftRamp2);
	DoubleSolenoid rightRamp = new DoubleSolenoid(RobotMap.compressor, RobotMap.RightRamp1, RobotMap.RightRamp2);
	
	boolean leftState, rightState;
	
	@Override
	protected void initDefaultCommand() {		
	}
	
	public void setCompressorEnabled(boolean state) {
		compressor.setClosedLoopControl(state);
	}
	
	public void setLeftRampState(boolean state) {
		if (leftState == true)
		{
			leftRamp.set(DoubleSolenoid.Value.kForward);
		}
		else
		{
			leftRamp.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void setRightRampState(boolean state) {
		if (rightState == true)
		{
			rightRamp.set(DoubleSolenoid.Value.kForward);
		}
		else
		{
			rightRamp.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public boolean getLeftRampState() {
		return leftState;
	}
	
	public boolean getRightRampState() {
		return rightState;
	}
	
	public boolean getCompressorEnabled() {
		return compressor.enabled();
	}
}
