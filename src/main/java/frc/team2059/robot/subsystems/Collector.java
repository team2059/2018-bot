package frc.team2059.robot.subsystems;

import frc.team2059.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Collector extends Subsystem {

	WPI_VictorSPX collectorMotor1 = new WPI_VictorSPX(RobotMap.collectorMotor1);
	WPI_VictorSPX collectorMotor2 = new WPI_VictorSPX(RobotMap.collectorMotor2);
	
	public void Collect(double sL, double sR) {
		collectorMotor1.set(sL);
		collectorMotor2.set(-sR);
	}
	
	public void CollectEnd() {
		collectorMotor1.set(0);
		collectorMotor2.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
