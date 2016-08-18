package com.uber.reports;

import java.sql.SQLException;

public class ListRiders extends Reports {

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		try{
			con = super.Connect();
			st = con.createStatement();
			String stmt = "Select RiderName, Email from rider;";
			rs=st.executeQuery(stmt);
			
		  	System.out.println("Name      Email");
		    System.out.println("---------------");
		    while (rs.next()) {
		        String RiderName= rs.getString("RiderName");
		        String Email = rs.getString("Email");
		        System.out.println(RiderName+"   "+Email);
		        
		    }		
		}
		 catch(SQLException s){
			 System.out.println(s.getMessage());
			
		 			}
			finally{
				
			}
	}

}
