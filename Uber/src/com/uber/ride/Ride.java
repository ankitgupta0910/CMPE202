package com.uber.ride;


import com.uber.request.Request;

public class Ride implements RideInterface {
	
	private Request request;
	private int rideId;
    private String rideStartTime;
    private String rideEndTime;
    private int fare;
	
	RideState rideState;
	
	public Ride() {
		rideState = new RideStarted(this);
	}
	
	
	@Override
	public void rideStart(int driverId) {
		// TODO Auto-generated method stub
		rideState.rideStart();
	}
	@Override
	public void rideEnd(int driverID) {
		// TODO Auto-generated method stub
		rideState.rideEnd(driverID);
	}
	@Override
	public void rideInProgress() {
		// TODO Auto-generated method stub
		rideState.rideInProgress();
	}
	@Override
	public RideState getState() {
		// TODO Auto-generated method stub
		return rideState;
	}
	@Override
	public void setState(RideState rideState) {
		// TODO Auto-generated method stub
		this.rideState=rideState;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getRideEndTime() {
		return rideEndTime;
	}

	public void setRideEndTime() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 rideEndTime = sdf.format(dt);
		
	}

	public String getRideStartTime() {
		return rideStartTime;
	}

	public void setRideStartTime() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 rideStartTime = sdf.format(dt);
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	public int getRideId() {
		return rideId;
	}


	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	

}
