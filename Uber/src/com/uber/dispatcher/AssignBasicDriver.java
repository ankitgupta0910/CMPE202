package com.uber.dispatcher;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;

import com.uber.request.Request;
import com.uber.database.DBConnect;
import com.uber.members.Driver;

public class AssignBasicDriver extends AssignDriver {

	@Override	
	public Driver fetchingDriver(Request request) {

        
		
		DBConnect db = new DBConnect();
		try{
        ArrayList<Driver> availableDrivers=db.fetchDriver(request.getVechicleType());
		
		
        HashMap<Driver,Integer> driverDistance = new HashMap<Driver,Integer>();
		
		
		int r1=request.getPickX();
		int r2=request.getPickY();
		
		for(int i=0;i<availableDrivers.size();i++)
		{
			
			Driver driver=(Driver)availableDrivers.get(i);
			int d1=driver.getSourceLat();
			int d2=driver.getSourceLong();
			int distance=(int)Math.sqrt(  ((d1-r1)*(d1-r1))    +       ((d2-r2)*(d2-r2))   );
 			driverDistance.put(driver, distance);
		}
		int min=Integer.MAX_VALUE;
		Driver nearDriver=null;
		for(Driver driver: driverDistance.keySet()){
			if(driverDistance.get(driver)<min){
				min=driverDistance.get(driver);
				nearDriver=driver;
			}
		}
		return nearDriver;}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
     }
	
	
		
	

}
