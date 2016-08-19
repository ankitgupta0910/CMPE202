package com.uber.driverstate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uber.constants.Constant;
import com.uber.members.Driver;

public class IsOnline implements DriverState{

	Driver driver;
	public IsOnline(Driver driver){
		this.driver = driver;
	}
	@Override
	public String isOnline() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
			st = con.createStatement();
			String stm = "update driver set DriverStatus='online' where DriverName='"+driver.getName()+"'";			
			st.executeUpdate(stm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Driver is online";
	}

	@Override
	public String isOffline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inRide() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
