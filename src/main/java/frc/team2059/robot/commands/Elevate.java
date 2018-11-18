package frc.team2059.robot.commands;

import frc.team2059.robot.OI;
import frc.team2059.robot.RobotMap;

public class Elevate extends CommandBase{
	
	double speed;
	
	public Elevate() {
		requires(elevator);
	}
	
	protected void initialize() {
		RobotMap.pidElevatorValue = false;
	}
	
	protected void execute() {
		
		if(elevator.getHallEffectBottom() == true) {
			elevator.setElevatorEncoder(0);
		}
		
		//System.out.println("Elevator Joystick: " + OI.getAuxJoystick().getRawAxis(1));
		elevator.elevate(-OI.getAuxJoystick().getRawAxis(1));
	}
	
	protected void end() {
	    elevator.elevate(0);
	  }

	 protected void interrupted() {
	   end();
	 }
	 
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
