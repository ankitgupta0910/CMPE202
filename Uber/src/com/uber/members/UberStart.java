package com.uber.members;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.uber.request.*;
import com.uber.ride.Ride;

import uber.dispatch.driver.DriverCurrentState;


public class UberStart {

	private Rider rider;
	private Request request;
	
	private Driver driver;
	private RiderSignin riderSignin;
	boolean is_start=false;
	boolean cancel_ride=false;
	boolean rideOn=true;
	Ride ride = new Ride();

	public UberStart() {
		while (true)
			displayOptions();
	}
	Scanner sc = new Scanner(System.in);
	private void displayOptions() {
		System.out.println();
		System.out.println("***************************");
		System.out.println("1. Rider Options");
		System.out.println("2. Driver Options");

		System.out.println("0. Exit");
		System.out.println("Please Enter you Option: ");
		String read = sc.nextLine();
		if (read.isEmpty() || read.length() >= 2) {
			System.out.println("Please Enter correct Input!");
			displayOptions();
		} else {
			int option = Integer.parseInt(read);
			switch (option) {
			case 0:
				System.out
						.println("You are logging out. Have a nice day!! :)");
				System.exit(0);
				break;
			case 1:
				displayRiderOptions();
				break;
			case 2:
				displayDriverOptions();
				break;
			
			}
		}
	}

	

	private void displayDriverOptions() {
		while (true) {

		
			System.out.println();
			System.out.println("Driver Menu____________________________________");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			System.out.println("0. Go to Main Options");
			System.out.println("Please Enter you Option: ");
			String line = sc.nextLine();
			if (line.isEmpty() || line.length() >= 2) {
				System.out.println("Wrong Input. Please enter again.");
				displayOptions();
			} else {
				int option = Integer.parseInt(line);
				switch (option) {
				case 0:
					break;
				case 1:
					new SignUpDriver();
					break;
				case 2:
					driver=new DriverSignin().signIn();
					DriverCurrentState driverState=new DriverCurrentState(driver);
					break;
				
				}
				if (option == 0) {
					break;
				}
			}
		}
	}

	private void displayRiderOptions() {

		while (true) {
			System.out.println();
			System.out.println("Rider Options____________________________________");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			System.out.println("3. Request A Cab");
			
			System.out.println("0. Go to Main Menu");
			System.out.println("Please Enter you Option: ");
			String line = sc.nextLine();
			if (line.isEmpty() || line.length() >= 2) {
				System.out.println("Wrong Input. Please enter again.");
				displayOptions();
			} else {
				
				int option = Integer.parseInt(line);
				switch (option) {
				case 0:
					break;
				case 1:
					new SignUpRider();
					break;
				case 2:
				riderSignin =new RiderSignin();
				rider=riderSignin.signIn();
					break;
				case 3:
					if (RiderSignin.currentRider() != null) {
						request = riderSignin.requestACab();
						
						if (request != null) {
							request.requestInQueue();
							request.requestAccepted();
							request.requestCompleted();
							
							while(rideOn)
							{
								System.out.println("");
								
					    		System.out.println("*****For Driver*******");
					    		System.out.println(" 1 : Start Ride");
					    		System.out.println(" 2 : End Ride");
					    		System.out.println(" 3 : Report Issue");
					    		System.out.println("");
					    	
					    		
					    		
					    		int opt =Integer.parseInt(sc.nextLine());
					    		if(opt==1 && !is_start)
					    		{
					    			is_start=true;
					    			ride.setRequest(request);
					    			ride.setRideStartTime();
					    			ride.rideStart(driver.getDriverId());
					    			
					    		}
					    		else if(opt == 1 && is_start)
					    		{
					    			System.out.println("Ride is already started.");
					    		}
					    		
					    		else if(opt==2 && !is_start)
					    		{
					    			System.out.println("Ride is not even started.");
					    		
					    		}
					    		else if(opt==3 && !is_start)
					    		{
					    			System.out.println("Dear Customer your ride have some issues");
					    		}
					    		else if(opt==3 && is_start)
					    		{
					    			System.out.println("Ride is already started. Cant delay it. Invalid selection");
					    		}
					    		else
					    		{
					    			
					    				
					    			ride.rideEnd(driver.getDriverId());
					    			rideOn=false;
					    			
					    		}
							}
							
							
						
							
							
							
						}
						
						}
					
					 else {
						System.out.println("Please login first");

						
					}
			

					break;
				}
					if (option == 0) {
						break;
					}
				}

			}
	}
public static void main(String[] args) {
	UberStart uberStart = new UberStart();

	
}


}
