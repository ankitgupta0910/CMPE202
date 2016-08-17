package com.uber.ride;

public interface RideInterface {
	
	
	public void rideEnd(int driverId);
	public void rideInProgress();
	
	public RideState getState();
	public void setState(RideState s);
	public void rideStart(int driverId);

	

}
