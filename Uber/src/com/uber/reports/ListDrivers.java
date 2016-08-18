package com.uber.reports;

import java.sql.SQLException;


public class ListDrivers extends Reports{
	public void showReport(){
	try{
		con = super.Connect();
		st = con.createStatement();
		String stmt = "Select DriverName, DriverStatus from driver;";
		rs=st.executeQuery(stmt);
		
	  	System.out.println("Name   Status");
	    System.out.println("-------------");
	    while (rs.next()) {
	        String DriverName= rs.getString("DriverName");
	        String DriverStatus = rs.getString("DriverStatus");
	        System.out.println(DriverName+"   "+DriverStatus);
	        
	    }		
	}
	 catch(SQLException s){
		 System.out.println(s.getMessage());
		
	 			}
		finally{
			
		}
	}
	
}
