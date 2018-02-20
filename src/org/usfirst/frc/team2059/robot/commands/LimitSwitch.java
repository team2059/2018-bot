package org.usfirst.frc.team2059.robot.commands;

import org.usfirst.frc.team2059.robot.commands.CommandBase;


public class LimitSwitch extends CommandBase{
	
	public LimitSwitch() {
		requires(elevator);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	public void execute() {
		if(elevator.getHallEffectBottom() == true) {
			elevator.setElevatorEncoder(0);
		}
//		if(elevator.getHallEffectTop() == true) {
//			elevator.setElevatorEncoder(75);
//		}
	}

}
