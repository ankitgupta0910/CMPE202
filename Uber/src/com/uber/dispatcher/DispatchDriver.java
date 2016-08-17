package com.uber.dispatcher;


import java.util.Scanner;

import com.uber.constants.Constant;
import com.uber.database.DBConnect;
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
			System.out.println("Driver No "+ availableDriver.getDriverId()+" do you want to accept this Ride? [Y/N]");
			System.out.println("");
	        String s = sc.nextLine();
	        if(s.equalsIgnoreCase("Y"))
	        {
	        	
	    		System.out.println("");
	    		System.out.println("Dear Customer your ride is confirmed. These are the details : :");
	    		System.out.println("Driver Name : "+availableDriver.getName());
	    		System.out.println("Vehicle Registeration : "+availableDriver.getVehicleRegNumber());
	    		System.out.println("Vehicle Color : "+availableDriver.getVehicleColor());
	    		System.out.println("Rating of Driver :" + availableDriver.getDriverRating());
	    		System.out.println("Estimated Fare :" );
	    		
	    	
	    		
	        }
	        else{
	        	db.setDriverOffline(availableDriver);
	        	
	        	
	        	request.requestAccepted();
	        	
	        }
	       
		
//		
//	
//		
//		
//		do
//		{
//			System.out.println("");
//			
//    		System.out.println("*****For Driver*******");
//    		System.out.println(" 1 : Start Ride");
//    		System.out.println(" 2 : End Ride");
//    		System.out.println(" 3 : Report Issue");
//    		System.out.println("");
//    		System.out.println("******For User******");
//    		System.out.println(" 4 : Cancel Ride");
//    		
//    		int option =Integer.parseInt(sc.nextLine());
//    		if(s.equals("1") && !is_start)
//    		{
//    			is_start=true;
//    			ride.rideStart();
//    		}
//    		else if(s.equals("1") && is_start)
//    		{
//    			System.out.println("Ride is already started.");
//    		}
//    		
//    		else if(s.equals("2") && !is_start)
//    		{
//    			System.out.println("Ride is not even started.");
//    		
//    		}
//    		else if(s.equals("3") && !is_start)
//    		{
//    			System.out.println("Dear Customer your ride have some issues");
//    		}
//    		else if(s.equals("3") && is_start)
//    		{
//    			System.out.println("Ride is already started. Cant delay it. Invalid selection");
//    		}
//    		else
//    		{
//    			if(s.equals("4"))
//    				cancel_ride=true;
//    			rideClass.modifyRide(s);
//    			command="-2";
//    		}
//		}
//		while(!command.equals("-2"));
//		
//		
//		///if ride is cancelledd
//		
//		if(cancel_ride)
//		{
//			System.out.println("Your Ride is cancelled.");
//			MainMenu mainMenu = new MainMenu();
//		}
//		
//		
//		
///
//		
//		rideClass.setRequest_id(request.getRequestId());
//		rideClass.setDriver_id(confirmedDriver.getId());
//		rideClass.setStart_time(new java.util.Date());
//		rideClass.setEnd_time(new java.util.Date());
//		rideClass.setFare(request.getFareEstimation());
//		
//		rideClass.setDriver_rating(0);
//		rideClass.setUser_rating(0);
//		rideClass.setStatus("Completed");
//		
//		rideClass.makePayment(rideClass);
//		
//		
//	}
//		catch(Exception e)
//		{e.printStackTrace();}
//	}

}
}