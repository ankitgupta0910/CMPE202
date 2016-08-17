package com.uber.ride;

import com.uber.database.DBConnect;

public class RideStarted implements RideState {

	
	RideInterface ride;
	
	public RideStarted(RideInterface ride){
		this.ride=ride;
		
	}

	@Override
	public void rideStart() {
		// TODO Auto-generated method stub
		System.out.println("Your Ride Started! Enjoy");
		ride.setState(new RideInProgress(ride));
	}
	

	@Override
	public void rideEnd(int driverId) {
		// TODO Auto-generated method stub
		System.out.println("Ride Not Started Yet");
	}

	@Override
	public String rideInProgress() {
		// TODO Auto-generated method stub
		System.out.println("Ride Not Started Yet");
		return null;
	}
	

	
}
