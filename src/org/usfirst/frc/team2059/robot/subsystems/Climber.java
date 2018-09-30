package org.usfirst.frc.team2059.robot.subsystems;

import org.usfirst.frc.team2059.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{

WPI_VictorSPX climberMotor1 = new WPI_VictorSPX(RobotMap.climberMotor1);
WPI_VictorSPX climberMotor2 = new WPI_VictorSPX(RobotMap.climberMotor2);
	

	public void Climb(double s) {
		climberMotor1.set(s);
		climberMotor2.set(-s);
	}
	
	public void ClimbEnd() {
		climberMotor1.set(0);
		climberMotor2.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
