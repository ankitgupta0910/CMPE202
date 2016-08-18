package com.uber.dispatcher;


import java.util.Scanner;

import com.uber.constants.Constant;
import com.uber.database.DBConnect;
import com.uber.driverstate.DriverCurrentState;
import com.uber.fare.BasicCabFare;
import com.uber.fare.BidAmountFare;
import com.uber.fare.Fare;
import com.uber.fare.PremiumCabFare;
import com.uber.members.Driver;
import com.uber.members.UberStart;
import com.uber.request.Request;



public class DispatchDriver {
	
	public void dispatchRequest(Request request)

	{
		
		
		
		Scanner sc = new Scanner(System.in);
		DBConnect db=new DBConnect();
	 
		CabType cabType;
		//boolean cabType=true;
	
		// ************   BRIDGE PATTERN *************//
		
		AssignDriver assignDriver;
	
		
		if(request.getVechicleType().equalsIgnoreCase(Constant.BASIC))
		{
		assignDriver=new AssignBasicDriver();
		cabType=new BasicCab(assignDriver);
		
		}
		else 
		{
			assignDriver=new AssignBasicDriver();
			cabType=new PremiumCab(assignDriver);
		}
		
		Driver availableDriver = null;


	

		availableDriver =cabType.assignDrivers(request);

	
		if(availableDriver==null)
		{
			System.out.println("No Drivers Available. Kindly try after some time.");
			UberStart uberStart = new UberStart();
		}
		
		
		// ************   BRIDGE PATTERN ENDS *************//
		
	
			
			System.out.println("");
			System.out.println("");
			
	        	
	    		System.out.println("");
	    		System.out.println("Dear Customer your ride is confirmed. These are the details : :");
	    		System.out.println("Driver Name : "+availableDriver.getName());
	    		System.out.println("Vehicle Registeration : "+availableDriver.getVehicleRegNumber());
	    		System.out.println("Vehicle Color : "+availableDriver.getVehicleColor());
	    		System.out.println("Rating of Driver :" + availableDriver.getDriverRating());
	    		if(request.getBidFare()>0)
	    		{
	    			System.out.println("Fare Amount is: "+new Fare(new BidAmountFare()).fareCalculate(request));
	    		}
	    		else if(request.getVechicleType().equalsIgnoreCase("basic")){
	    			System.out.println("Fare Amount is: "+new Fare(new BasicCabFare()).fareCalculate(request));
	    		}
	    		else{
	    			System.out.println("Fare Amount is: "+new Fare(new PremiumCabFare()).fareCalculate(request));
	    		}
	    		DriverCurrentState.setCurrentDriver(availableDriver.getDriverId());
	    		
	    	
	    		
	        
	      


}
}