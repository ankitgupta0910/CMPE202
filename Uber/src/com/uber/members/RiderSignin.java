package com.uber.members;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

import com.uber.request.Request;

public class RiderSignin {
	Rider rider=new Rider();
	public static Rider currentRider;
	public RiderSignin(){
		
	}
	public static Rider currentRider(){
		return currentRider;
	}
	public Rider signIn(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Username/EmailId: ");
		String email = sc.nextLine();
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		
		return checkRider(email,pass);
		
	}

	public Rider checkRider(String email, String pass){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://spartanride.c1d5rowcx4kr.us-west-2.rds.amazonaws.com:3306/spartanride";
		String user = "spartanride";
		String password = "spartanride123";

		try {
			
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			
			String stmt = "select * from rider where Email = '"+email+"' and Password = '"+pass+"'";
			rs=st.executeQuery(stmt);

			while(rs.next()){
				
				rider.setRiderId(rs.getInt("RiderId"));
				rider.setAddress(rs.getString("Address"));
				rider.setDob(rs.getString("DOB"));
				rider.setEmail(rs.getString("Email"));
				rider.setCardNumber(rs.getString("CardNumber"));
				rider.setName(rs.getString("RiderName"));
				rider.setPass(rs.getString("Password"));
				rider.setPhone(rs.getString("Phone"));
				rider.setCvv(rs.getInt("CVV"));
				rider.setExpDate(rs.getString("CardExpDate"));
				currentRider = rider;
				return rider;
			}

		} catch (SQLException ex) {

			System.out.println("Error: "+ex.getMessage());

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}

				if (st != null) {
					st.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {

				System.out.println("Error: "+ex.getMessage());
			}
		}
		return null;
	}
	
	public Request requestACab() {
		Scanner sc = new Scanner(System.in);

		try {

			Request request = new Request();
			long time = System.currentTimeMillis();
			request.setRequestId(time);
			System.out.println();
			System.out.println("___________________________________________________________________");
			System.out.println("Request a ride ");
			System.out.println("___________________________________________________________________");
			System.out.println("Please Enter Ride Details: ");

		

			HashMap<String, Location> locations = LocationMapping
					.getLocationObject().getLocations();

			int count = 1;

			for (String string : locations.keySet()) {
				System.out.println(count++ + ". " + string);
			}

			System.out.println("Pick Up Location [pick from above list]: ");
			int index = Integer.parseInt(sc.nextLine());
			String selected = (String) (locations.keySet().toArray()[index - 1]);

			Location location1 = locations.get(selected);

			request.setPickX(location1.x);
			request.setPickY(location1.y);
			request.setPickUpLocation(selected);

			System.out.println("Destination [pick from above list]:  ");
			index = Integer.parseInt(sc.nextLine());
			selected = (String) (locations.keySet().toArray()[index - 1]);
			Location location2 = locations.get(selected);

			request.setDestX(location2.x);
			request.setDestY(location2.y);
			request.setDestination(selected);

			Date date = null;
			while (date == null) {
				date = getInputBookingDate();
				if (date == null) {
					System.out
							.println("Please enter the date in proper format.");
				}
			}
			
			request.setBookingDate(date);

			System.out.println("Enter Type [Basic/Luxury]: ");
			request.setVechicleType(sc.nextLine());

			System.out.println("Child Seat [Y/N]: ");
			request.setVechicleChild(sc.nextLine());

		

			System.out.println("Do you want to submit a request? [y/n]: ");
			if (sc.nextLine().equalsIgnoreCase("y")) {
				System.out
						.println("Your Request has been created. Please wait for connecting to drivers.");

				System.out.println(request.toString());

				// STATE PATTERN FOR DIFFERENT REQUEST STATES

				return request;

			} else {
				System.out
						.println("You cancelled the request. Please try again");
				return null;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Your request is not complete. Please try again.");
		return null;

	}

	private java.sql.Date getInputBookingDate() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Booking Date[MM/dd/yyyy hh:mm]: ");

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			java.util.Date parsed = (java.util.Date) format.parse(sc.nextLine());
			return new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
		}
		return null;
	}

}
