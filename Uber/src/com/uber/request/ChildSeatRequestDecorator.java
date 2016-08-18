package com.uber.request;

public class ChildSeatRequestDecorator extends RequestDecorator{
	public ChildSeatRequestDecorator(RideRequestInterface request) {
		super(request);
	}
	
	
	public void addCarSeat(){
		request.setChildSeatFlag(true);
		
	}




	@Override
	public void requestCompleted() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public RequestState getState() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setState(RequestState s) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void requestInQueue() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void requestCancelled() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void requestAccepted() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setChildSeatFlag(boolean b) {
		// TODO Auto-generated method stub
		addCarSeat();
	}


	
	
	
}