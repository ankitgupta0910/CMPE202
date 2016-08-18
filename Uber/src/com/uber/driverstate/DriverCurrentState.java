package com.uber.driverstate;

import com.uber.members.Driver;

public class DriverCurrentState implements DriverInterface {
	DriverState driverState;
	public static int currentDriver;
	public static void setCurrentDriver(int d)
	{
		currentDriver=d;
	}
	
	public DriverCurrentState(Driver driver){
		
		 driverState = new IsOnline(driver);
		
	}
	
	@Override
	public void isOnline() {
		// TODO Auto-generated method stub
		System.out.println(driverState.isOnline());
		
	}

	@Override
	public void isOffline() {
		// TODO Auto-generated method stub
		System.out.println(driverState.isOffline());
		
	}

	@Override
	public void inRide() {
		// TODO Auto-generated method stub
		System.out.println(driverState.inRide());
		
	}

	@Override
	public DriverState getDriverState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDriverState(DriverState driverState) {
		// TODO Auto-generated method stub
		
	}

}
