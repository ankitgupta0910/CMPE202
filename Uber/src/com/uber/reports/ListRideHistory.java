package com.uber.reports;

import java.sql.SQLException;

public class ListRideHistory extends Reports{

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		try{
			con = super.Connect();
			st = con.createStatement();
			
			//Change this for Ride Hoistory
			String stmt = "Select RideId, RideStartTime from ride;";
			rs=st.executeQuery(stmt);
			
		  	System.out.println("Id   StartTime");
		    System.out.println("-------------");
		    while (rs.next()) {
		        String RideId= rs.getString("RideId");
		        String RideStartTime = rs.getString("RideStartTime");
		        System.out.println(RideId+"   "+RideStartTime);
		        
		    }		
		}
		 catch(SQLException s){
			 System.out.println(s.getMessage());
			
		 			}
			finally{
				
			}
	}

}
