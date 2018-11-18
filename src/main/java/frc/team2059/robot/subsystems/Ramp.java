package frc.team2059.robot.subsystems;

import frc.team2059.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem{

	WPI_VictorSPX rampMotor = new WPI_VictorSPX(RobotMap.rampMotor);
	
	public void RampDown(double s) {
		rampMotor.set(s);
	}
	
	public void RampEnd() {
		rampMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
