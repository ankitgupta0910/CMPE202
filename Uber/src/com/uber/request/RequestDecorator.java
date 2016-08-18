package com.uber.request;

public abstract class RequestDecorator implements RideRequestInterface {

	protected RideRequestInterface request;
	
	public RequestDecorator(RideRequestInterface request){
		this.request = request;
	}


}