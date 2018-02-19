package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.LimitSwitch;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Elevator extends Subsystem{
	//WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(RobotMap.elevatorMotor1);
	TalonSRX elevatorMotor = new TalonSRX(RobotMap.elevatorMotor1);
	
	DigitalInput hallEffectBottom = new DigitalInput(RobotMap.hallEffect1);
//	DigitalInput hallEffect2 = new DigitalInput(RobotMap.hallEffect2);
	
	//ElevatorEncoder elevatorEncoder = new ElevatorEncoder(RobotMap.elevatorEncoder1, RobotMap.elevatorEncoder2);
	
	public void elevate(double s) {
		elevatorMotor.set(ControlMode.PercentOutput, s);
	}
	
	public void elevateEnd() {
		elevatorMotor.set(ControlMode.PercentOutput, 0);
	}
	
	//public Encoder elevatorEncoder() {
	//	return elevatorEncoder;
	//}
	
	//public void resetElevatorEncoder() {
	//	elevatorEncoder.reset();
	//}

	public double getElevatorEncoder() {
		return elevatorMotor.getSelectedSensorPosition(0);
	}
	
	public void setElevatorEncoder(int d) {
		elevatorMotor.setSelectedSensorPosition(d, 0, 0);
	}
	
	public boolean getHallEffectBottom() {
		return !hallEffectBottom.get();
	}
//	
//	public boolean getHallEffect2() {
//		return hallEffect2.get();
//	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LimitSwitch());
	}
	
}
