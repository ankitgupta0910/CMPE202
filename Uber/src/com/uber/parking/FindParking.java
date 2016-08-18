package com.uber.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.uber.members.*;


public class FindParking {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String location;
	
	String url = "jdbc:mysql://spartanride.c1d5rowcx4kr.us-west-2.rds.amazonaws.com:3306/spartanride";
	String user = "spartanride";
	String password = "spartanride123";

	public void Parking()
	{
		List<String> garageList = new ArrayList<String>();  
		garageList.add("Almaden/Woz Lot");
		garageList.add("Almaden/Balbach Lot");
		garageList.add("City Hall Garage");
		garageList.add("Convention Center");
		garageList.add("Fourth Street Garage");
		garageList.add("South Hall Lot");
		garageList.add("Third and Santa Clara Garage");
		garageList.add("Third Street Garage");
		garageList.add("Second & San Carlos Street Garage");
		garageList.add("Fourth/St. John Garage");
		for(int i=0;i<garageList.size(); i++){
			System.out.println(i+1 + ". " +  garageList.get(i));
		}
	}
	
	public void GetParking(Integer DriverId){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a Location ");
		Integer option  =Integer.parseInt(sc.nextLine());
		switch (option) {
		case 1:
			location = "Almaden/Woz Lot";
			break;
		case 2:
			location = "Almaden/Balbach Lot";
			break;
		case 3:
			location = "City Hall Garage";
			break;
		case 4:
			location = "Convention Center";
			break;
		case 5:
			location = "Fourth Street Garage";
			break;
		case 6:
			location = "South Hall Lot";
			break;
		case 7:
			location = "Third and Santa Clara Garage";
			break;
		case 8:
			location = "Third Street Garage";
			break;
		case 9:
			location = "Second & San Carlos Street Garage";
			break;
		case 10:
			location = "Fourth/St. John Garage";
			break;
		}
		try{
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		String stmt ="Insert into parking(ParkingLocation,DriverId,Date) values('"+location+"',"+DriverId+",NOW())";
		st.executeUpdate(stmt);
		System.out.println("Garage Alloted:"+location);
		
	}
		catch(SQLException s){
			System.out.println(s.getMessage());
		
		}
		
		
	}
	

}
