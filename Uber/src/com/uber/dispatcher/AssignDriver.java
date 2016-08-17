package com.uber.dispatcher;


import com.uber.members.Driver;
import com.uber.request.Request;

public abstract  class AssignDriver {

	

		
		abstract public Driver fetchingDriver(Request request);

	
}
