package com.uber.ride;



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
		System.out.println("Ride Not Started Yet s");
	}

	@Override
	public String rideInProgress() {
		// TODO Auto-generated method stub
		System.out.println("Ride Not Started Yet p");
		return null;
	}
	

	
}
