package com.uber.members;


import java.util.Scanner;

import com.uber.driverstate.DriverCurrentState;
import com.uber.fare.BasicCabFare;
import com.uber.fare.BidAmountFare;
import com.uber.fare.Fare;
import com.uber.fare.PremiumCabFare;
import com.uber.parking.FindParking;
import com.uber.payments.CashPaymentStrategy;
import com.uber.payments.CreditCardPaymentStrategy;
import com.uber.payments.DebitCardPaymentStrategy;
import com.uber.payments.PaymentContext;
import com.uber.request.*;
import com.uber.ride.Ride;
import com.uber.reports.*;


public class UberStart {

	private Rider rider;
	private Request request;
	
	private Driver driver;
	private RiderSignin riderSignin;
	private AdminSignin adminSignin;
	boolean is_start=false;
	boolean cancel_ride=false;
	boolean displayRider=true;
	boolean rideOn=true;
	Ride ride = new Ride();
	int fare;
	

	public UberStart() {
		while (true)
			displayOptions();
	}
	Scanner sc = new Scanner(System.in);
	public void setDriver(Driver driver){
		this.driver=driver;
	}
	public Driver getDriver(){
		return driver;
	}
	private void displayOptions() {
		System.out.println();
		System.out.println("***************************");
		System.out.println("1. Rider Options");
		System.out.println("2. Driver Options");
		System.out.println("3. Admin");
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
			case 3:
				displayAdminOptions();
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
			System.out.println("3. Parking");
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
				case 3:
					FindParking fp = new FindParking();
					fp.Parking();
					fp.GetParking(driver.getDriverId());
					break;	
				
				}
				if (option == 0) {
					break;
				}
			}
		}
	}

	private void displayRiderOptions() {

		while (displayRider) {
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
					displayRider=false;
					break;
					
				case 1:
					new SignUpRider();
					break;
				case 2:
				riderSignin =new RiderSignin();
				rider=riderSignin.signIn();
					break;
				case 3:
					rideOn=true;
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
					    			ride.rideStart(DriverCurrentState.currentDriver);
					    			ride.rideInProgress();
					    			
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
					    			
					    			if(request.getBidFare()>0)
						    		{fare=new Fare(new BidAmountFare()).fareCalculate(request);
						    			ride.setFare(fare);
						    		}
						    		else if(request.getVechicleType().equalsIgnoreCase("basic")){
						    			fare=new Fare(new BasicCabFare()).fareCalculate(request);
						    			ride.setFare(fare);
						    		}
						    		else{
						    			fare=new Fare(new PremiumCabFare()).fareCalculate(request);
						    			ride.setFare(fare);
						    		}
					    			ride.rideEnd(DriverCurrentState.currentDriver);
					    			System.out.println();
					    			System.out.println();
					    			System.out.println("**********Rate Driver******");
					    			System.out.println("Do you want to Rate Driver");
					    			if(sc.nextLine().equalsIgnoreCase("y")){
					    			System.out.println("Rate Driver out of 5: ");
					    			int rating =Integer.parseInt(sc.nextLine());
					    			DriverRating driverRating=new DriverRating();
					    			driverRating.rateDriver(ride,rating);
					    			}
					    			
					    			System.out.println();
					    			System.out.println();
					    			System.out.println("***********Make Payment******");
					    			System.out.println("How you are going to pay");
					    			System.out.println("1. Cash");
					    			System.out.println("2. DebitCard");
					    			System.out.println("3. CreditCard ");
					    			int paymentOption=Integer.parseInt(sc.nextLine());
					    			if(paymentOption==1){
					    				PaymentContext payMethod =new PaymentContext();
					    				payMethod.setPaymentStrategy(new CashPaymentStrategy());
					    				payMethod.pay(fare);
					    			}
					    			else if(paymentOption==2){
					    				PaymentContext payMethod =new PaymentContext();
					    				payMethod.setPaymentStrategy(new DebitCardPaymentStrategy());
					    				payMethod.pay(fare);
					    			}
					    			else{
					    				PaymentContext payMethod =new PaymentContext();
					    				payMethod.setPaymentStrategy(new CreditCardPaymentStrategy());
					    				payMethod.pay(fare);
					    			}
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

			}}
	}
	private void displayAdminOptions() {

		try {
			while (true) {
				System.out.println();
				System.out.println("Admin Options____________________________________");
				System.out.println("1. List Driver");
				System.out.println("2. List Riders");
				System.out.println("3. List Ride History");
				
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
						new ListDrivers().showReport();;
						break;
					case 2:
						new ListRiders().showReport();;
						break;
					case 3:
						new ListRideHistory().showReport();;
						break;
						}
						if (option == 0) {
							break;
						}
					}

				}

		} finally{}
	}
	
	
public static void main(String[] args) {
	UberStart uberStart = new UberStart();

	
}


}
