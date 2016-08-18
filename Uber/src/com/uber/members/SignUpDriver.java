package com.uber.members;

import java.util.Date;
import java.util.Scanner;

public class SignUpDriver {

	Driver driver;
	Scanner sc;
	
	public SignUpDriver(){
		driver = new Driver();
		sc = new Scanner(System.in);
		setName();
		setAddress();
		setPhone();
		setDob();
		setEmail();
		setPassword();
		setLicenseNumber();
		setVehicleType();
		setVehicleColor();
		setChildSeat();
		storeData();
		setSourceLat();
		setSourceLong();
		


		
	}
	
	public void setName(){
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		driver.setName(name);
	}
	
	public void setAddress(){
		System.out.println("Enter your address: ");
		String address = sc.nextLine();
		driver.setAddress(address);
	}
	
	public void setPhone(){
		System.out.println("Enter your Phone number: ");
		String phone = sc.nextLine();
		driver.setPhone(phone);
	}
	
	public void setDob(){
		System.out.println("Enter your DOB (mm/dd/yyyy): ");
		String dob = sc.nextLine();
		driver.setDob(dob);
	}

	public void setEmail(){
		System.out.println("Enter your Email ID: ");
		String email = sc.nextLine();
		driver.setEmail(email);
	}
	
	public void setPassword(){
		System.out.println("Enter your password: ");
		String pass=sc.nextLine();
		driver.setPass(pass);
	}
	
	public void setLicenseNumber(){
		System.out.println("Please Enter you Diriving License Number");
		String license = sc.nextLine();
		driver.setLicenseNumber(license);
	}
	
	public void setVehicleRegNum(){
		System.out.println("Vehicle registration Number: ");
		String num = sc.nextLine();
		driver.setVehicleRegNumber(num);
	}
	
	public void setVehicleType(){
		System.out.println("Please enter the number of Seats of your Vehicle: ");
		int n =Integer.parseInt(sc.nextLine());
		if(n<=5){
			driver.setVehicleType("Basic");
		}
		else{
			driver.setVehicleType("Premium");
		}
	}
	
	public void setVehicleColor(){
		System.out.println("What color is your Vehicle?");
		String color = sc.nextLine();
		driver.setVehicleColor(color);
	}
	
	public void setChildSeat(){
		System.out.println("Do you have Child seat?");
		String child = sc.nextLine();
		driver.setVehicleChild(child);
	}
	
	public void storeData(){
		new StoreDriverData(driver);
	}
	public void setSourceLat(){
	
		driver.setSourceLat(1);
	}
	public void setSourceLong(){
		driver.setSourceLong(1);
	}
	
	
}
