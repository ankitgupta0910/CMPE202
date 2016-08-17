package com.uber.members;

import java.sql.Connection;
import com.uber.constants.*;

import uber.dispatch.driver.DriverCurrentState;
import uber.dispatch.driver.IsOnline;

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
		
		
		driver=checkDriver(email,pass);
		DriverCurrentState dS=new DriverCurrentState(driver);
		dS.setDriverState(new IsOnline(driver));
		return driver;
		
	}

	public Driver checkDriver(String email, String pass){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		

		try {

			con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
			st = con.createStatement();
			
			String stmt = "Select * from driver where Email = '"+email+"' and Password = '"+pass+"'";
			rs=st.executeQuery(stmt);
		

			while(rs.next()){
				
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
