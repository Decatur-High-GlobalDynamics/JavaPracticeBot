package org.usfirst.frc.team4026.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Jaguar;

//import Subsystem.java;

public class Drivetrain extends Subsystem {
	
	private static final int FRONT_LEFT = 0;
	private static final int FRONT_RIGHT = 1;
	private static final int REAR_LEFT = 2;
	private static final int REAR_RIGHT = 3;
	
	private static final int GYRO_PORT = 0;
	
	
	public Jaguar FrontLeft;
	public Jaguar FrontRight;
	public Jaguar RearLeft;
	public Jaguar RearRight;
	
	private AnalogGyro Gyro;
	boolean isInitialized = false;
	
	public int init(){
		if(!isInitialized){
		FrontLeft = new Jaguar(FRONT_LEFT);
		FrontRight = new Jaguar(FRONT_RIGHT);
		RearLeft = new Jaguar (REAR_LEFT);
		RearRight = new Jaguar (REAR_RIGHT);
		
		Gyro = new AnalogGyro(GYRO_PORT);
		
		isInitialized = true;
		return 0;
		}
		//Return 1 if tries to reinit
		return 1;
	}
	
	public int act(Robot robot){
		double left = -robot.controller.getLeft();
		double right = robot.controller.getRight();
		FrontLeft.set(left); 
		RearLeft.set(left);
		FrontRight.set(right);
		RearRight.set(right);
		return 0;
		
		
	}
	
	public double getGyroHeading(){
		return Gyro.getAngle();
	}
	public int shutdown(){
		stopDrive();
		return 1;
	}
	
	private void stopDrive(){
		FrontLeft.set(0);
		FrontRight.set(0);
		RearLeft.set(0);
		RearRight.set(0);
	}
	
}
