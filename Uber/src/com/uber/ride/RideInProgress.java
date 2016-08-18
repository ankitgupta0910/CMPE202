package com.uber.ride;

public class RideInProgress implements RideState {

	RideInterface request;
	public RideInProgress(RideInterface request){
		this.request=request;
		
	}
	@Override
	public void rideStart() {
		System.out.println("Ride Already Started");
	}
	@Override
	public void rideEnd(int driverId) {
		// TODO Auto-generated method stub
		System.out.println("Ride In Progress");
	}
	@Override
	public String rideInProgress() {
		// TODO Auto-generated method stub
		Ride ridde=(Ride)request;
		System.out.println("Ride in progress with RequestId: "+ridde.getRequest().getRequestId());
		request.setState(new RideCompleted(request));
		return ridde.getRequest().getRequestId()+"";
	}
	

}
