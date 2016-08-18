package com.uber.members;

import java.sql.Connection;
import com.uber.constants.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreDriverData {
	
	Driver driver;
	
	public StoreDriverData(Driver driver){
		this.driver = driver;
		connect();
	}
	
	public void connect(){
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            
            con = DriverManager.getConnection(Constant.URL,Constant.USERNAME, Constant.PASSWORD);
            st = con.createStatement();

            String stmt = "Insert into driver (DriverName,Address,Phone,SourceLat,SourceLong,DOB,DriverLicenseNumber,VehicleColor,VehicleRegNumber,VehicleType,Email,Password,HasChildSeat,DriverRating,DriverStatus) values ('"+driver.getName()+"','"
            										 +driver.getAddress()+"','"
            										 +driver.getPhone()+"','"
            										 +driver.getSourceLat()+"','"
            										 +driver.getSourceLong()+"','"
            										 +driver.getDob()+"','"
            										 +driver.getLicenseNumber()+"','"
            										 +driver.getVehicleColor()+"','"
            										 +driver.getVehicleRegNumber()+"','"
       												 +driver.getVehicleType()+"','"
            										 +driver.getEmail()+"','"
    												 +driver.getPass()+"','"
            										 +driver.getVehicleChild()+"','0','offline')";
            st.executeUpdate(stmt);

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

	}

}
