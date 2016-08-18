package com.uber.members;

import com.uber.database.DBConnect;
import com.uber.ride.Ride;

public class DriverRating {
	Ride ride;
	public void rateDriver(Ride ride,int rating){
		int driver=new DBConnect().getDriverRide(ride);
		System.out.println(driver+"r");
		int driverRating=new DBConnect().getDriverRating(driver);
		System.out.println(driverRating+"d");
		int newRating=(driverRating+rating)/2;
		new DBConnect().setDriverRating(driver,newRating);
		
	}

}
