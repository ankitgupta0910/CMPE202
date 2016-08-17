package com.uber.ride;

public interface RideState {
	
	public void rideStart();
	public void rideEnd(int driverId);
	public String rideInProgress();
	

}
