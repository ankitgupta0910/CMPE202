package com.uber.dispatcher;



import com.uber.members.Driver;
import com.uber.request.Request;


public abstract class CabType {
	
	protected AssignDriver assignDriver;
	public abstract Driver assignDrivers(Request request);
	
	public CabType(AssignDriver assignDriver)
	{
		this.assignDriver=assignDriver;
	}
	 
	protected Driver assigningDrivers(Request request)
	{
		return assignDriver.fetchingDriver(request);
	}

}
