package com.uber.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DriverSignin {
	Driver driver;
	public DriverSignin(){
		signIn();
	}

	public Driver signIn(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Username/EmailId: ");
		String email = sc.nextLine();
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		return checkDriver(email,pass);
	}

	public Driver checkDriver(String email, String pass){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://spartanride.c1d5rowcx4kr.us-west-2.rds.amazonaws.com:3306/spartanride";
		String user = "spartanride";
		String password = "spartanride123";

		try {

			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			
			String stmt = "Select * from driver where Email = '"+email+"' and Password = '"+pass+"'";
			rs=st.executeQuery(stmt);
			System.out.println(rs.toString());

			if(rs.next()){
				
				driver.setDriverId(rs.getInt("DriverId"));
				driver.setAddress(rs.getString("Address"));
				driver.setDob(rs.getString("DOB"));
				driver.setEmail(rs.getString("Email"));
				driver.setLicenseNumber(rs.getString("DriverLicenseNumber"));
				driver.setName(rs.getString("DriverName"));
				driver.setPass(rs.getString("Password"));
				driver.setPhone(rs.getString("Phone"));
				driver.setVehicleColor(rs.getString("VehicleColor"));
				driver.setVehicleRegNumber(rs.getString("VehicleRegNumber"));
				driver.setVehicleType(rs.getString("VehicleType"));

				String stm = "update Driver set DriverStatus='online' where Email='"+email+"'";
				st.executeUpdate(stm);
				return driver;
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
	
	

}
