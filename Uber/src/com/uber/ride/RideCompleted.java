package com.uber.ride;

import com.uber.database.DBConnect;

public class RideCompleted implements RideState{

	RideInterface request;
	
	public RideCompleted(RideInterface request){
		this.request=request;
		
	}

	@Override
	public void rideStart() {
		// TODO Auto-generated method stub
		System.out.println("Ride already Ended");
	}

	@Override
	public void rideEnd(int driverId) {
		// TODO Auto-generated method stub
		Ride ride=(Ride)request;
		ride.setRideEndTime();
		new DBConnect().setRide(driverId, ride);
		System.out.println("Ride Ended! Have agood day");
		
	}

	@Override
	public String rideInProgress() {
		// TODO Auto-generated method stub
		System.out.println("Ride already Ended");
		return null;
	}


}
