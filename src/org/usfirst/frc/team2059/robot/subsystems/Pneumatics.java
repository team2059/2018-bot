package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import hhCore.pneumatics.HHPneumatics;

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
		HHPneumatics.enableSolenoid(state, leftRamp);
	}
	
	public void setRightRampState(boolean state) {
		HHPneumatics.enableSolenoid(state, rightRamp);
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
