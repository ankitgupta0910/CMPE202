package com.uber.request;

public class RequestCompleted implements RequestState{

	RideRequestInterface request;
	
	public RequestCompleted(RideRequestInterface request){
		this.request=request;
		
	}
	
	@Override
	public String requestInQueue() {
		// TODO Auto-generated method stub
		return "Request Already Completed";
	}

	@Override
	public String requestCancelled() {
		// TODO Auto-generated method stub
		return "Request Already Completed";
		
	}

	@Override
	public String requestAccepted() {
		// TODO Auto-generated method stub
		return "Request Already Completed";
		
	}

	@Override
	public String requestCompleted() {
		// TODO Auto-generated method stub
		
		return "Request Completed Successfuly ! Enjoy Your Ride";
		
		
	}
	

}
