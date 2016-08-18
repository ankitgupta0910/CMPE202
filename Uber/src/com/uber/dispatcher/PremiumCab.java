package com.uber.dispatcher;


import com.uber.members.Driver;
import com.uber.request.Request;

public class PremiumCab extends CabType{

	public PremiumCab(AssignDriver assignDriver) {
		super(assignDriver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Driver assignDrivers(Request request) {
		// TODO Auto-generated method stub
		return assigningDrivers(request);
	}
}


