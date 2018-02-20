package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import hhCore.pneumatics.HHPneumatics;

public class Pneumatics extends Subsystem {
	
	Compressor compressor = new Compressor(RobotMap.compressor);
	DoubleSolenoid leftRamp1 = new DoubleSolenoid(RobotMap.compressor, RobotMap.LeftRamp1, RobotMap.LeftRamp2);
	DoubleSolenoid leftRamp2 = new DoubleSolenoid(RobotMap.compressor, RobotMap.LeftRamp3, RobotMap.LeftRamp4);
	DoubleSolenoid rightRamp1 = new DoubleSolenoid(RobotMap.compressor, RobotMap.RightRamp1, RobotMap.RightRamp2);
	DoubleSolenoid rightRamp2 = new DoubleSolenoid(RobotMap.compressor, RobotMap.RightRamp3, RobotMap.RightRamp4);
	Relay spike = new Relay(RobotMap.spike);
	
	boolean leftState, rightState;
	
	@Override
	protected void initDefaultCommand() {		
	}
	
	public void setCompressorEnabled(boolean state) {
//		spike.set(Relay.Value.kForward);
		compressor.setClosedLoopControl(state);
		compressor.start();

//		if (compressor.getPressureSwitchValue() == true) {
//			
//		} else {
//			spike.set(Relay.Value.kOff);
//		}
	}
	
	public void setLeftRampState(boolean state) {
		HHPneumatics.enableSolenoid(state, leftRamp1);
		HHPneumatics.enableSolenoid(state, leftRamp2);
	}
	
	public void setRightRampState(boolean state) {
		HHPneumatics.enableSolenoid(state, rightRamp1);
		HHPneumatics.enableSolenoid(state, rightRamp2);
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
