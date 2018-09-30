package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Elevate;
import org.usfirst.frc.team2059.robot.commands.LimitSwitch;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Elevator extends Subsystem{
	TalonSRX elevatorMotor = new TalonSRX(RobotMap.elevatorMotor1);
	TalonSRX elevatorMotor2 = new TalonSRX(RobotMap.elevatorMotor2);
	
	DigitalInput hallEffectBottom = new DigitalInput(RobotMap.hallEffect1);
	DigitalInput hallEffectTop = new DigitalInput(RobotMap.hallEffect2);
		
	public void elevate(double s) {
		//System.out.println(s);
		
		//System.out.println(getHallEffectBottom() == true && s < 0);
		
		if (getHallEffectBottom() == true && s < 0) {
			
			elevatorMotor.set(ControlMode.PercentOutput, 0);
			elevatorMotor2.set(ControlMode.PercentOutput, 0);
			
		} else if (getHallEffectTop() == true && s > 0) {
			
			elevatorMotor.set(ControlMode.PercentOutput, 0);
			elevatorMotor2.set(ControlMode.PercentOutput, 0);
		}
		else {
			
			elevatorMotor.set(ControlMode.PercentOutput, -s);
			elevatorMotor2.set(ControlMode.PercentOutput, -s);
		}
	}
	
	public void elevateEnd() {
		elevatorMotor.set(ControlMode.PercentOutput, 0);
	}

	public double getElevatorEncoder() {
		return elevatorMotor.getSelectedSensorPosition(0) / 20204.2775;
	}
	
	public void setElevatorEncoder(int d) {
		elevatorMotor.setSelectedSensorPosition( (int) (d/.000047472), 0, 0);
	}
	
	public boolean getHallEffectBottom() {
		return !hallEffectBottom.get();
	}
	
	public boolean getHallEffectTop() {
		return !hallEffectTop.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new Elevate());
		//setDefaultCommand(new LimitSwitch());
	}
	
}
