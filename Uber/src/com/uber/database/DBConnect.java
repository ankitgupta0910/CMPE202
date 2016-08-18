package com.uber.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uber.constants.Constant;
import com.uber.members.Driver;
import com.uber.members.Rider;
import com.uber.request.Request;
import com.uber.ride.Ride;

public class DBConnect {
	

	Statement stmt = null;
	

	public void insertRequest(Request request, Rider rider) throws SQLException {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

       

        try {
            
            con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
            st = con.createStatement();
            
            String stmt = "Insert into request (RiderId,SourceAddress,DestAddress,RideTime,VehicleType,RequestType,ReqChildSeat,BidAmount,SourceLat,SourceLong,DestLat,DestLong,ReqState) values ('"+rider.getRiderId()+"','"
            										 +request.getPickUpLocation()+"','"
            										 +request.getDestination()+"','"
        
            										 +request.getBookingDate()+"','"
            										 +request.getVechicleType()+"','"
            										 +request.getRequestType()+"','"
                    								 +request.getChildSeat()+"','"
                    								 +request.getBidFare()+"','"
                    								 +request.getPickX()+"','"
                    								+request.getPickY()+"','"
                    								 +request.getDestX()+"','"
                    								+request.getDestY()+"','"
       												 +request.getState()+"')";
            										
            st.executeUpdate(stmt, Statement.RETURN_GENERATED_KEYS);
            	rs=st.getGeneratedKeys();
            	rs.next();
   	         request.setRequestId(rs.getInt(1));
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

	
	

	public ArrayList<Driver> fetchDriver(String cabType) throws SQLException {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Driver> driverList = new ArrayList<Driver>();
       

        try {
            
            con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
            st = con.createStatement();
            String stmt = "select * from driver where DriverStatus = 'online' and VehicleType='"+cabType+"'";
			rs=st.executeQuery(stmt);
			while(rs.next()){
				Driver newDriver = new Driver();
				newDriver.setDriverId(rs.getInt("DriverId"));
				newDriver.setEmail(rs.getString("Email"));
				
				newDriver.setName(rs.getString("DriverName"));
				newDriver.setDriverRating(rs.getString("DriverRating"));
				newDriver.setSourceLat(rs.getInt("SourceLat"));
				newDriver.setSourceLong(rs.getInt("SourceLong"));
				newDriver.setChildSeat(rs.getString("HasChildSeat"));
				newDriver.setPhone(rs.getString("Phone"));
				newDriver.setVehicleColor(rs.getString("VehicleColor"));
				newDriver.setVehicleRegNumber(rs.getString("VehicleRegNumber"));
				newDriver.setVehicleType(rs.getString("VehicleType"));
				driverList.add(newDriver);
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
		return driverList;

	}
public void setDriverOffline(Driver driver){
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String stm = "update Driver set DriverStatus='offline' where Email='"+driver.getEmail()+"'";
	try {
		st.executeUpdate(stm);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
        
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
public void setRide(int driverId,Ride ride){
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;

	  try {
          
          con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
          st = con.createStatement();
          
          String stmt = "Insert into ride (RequestId,DriverId,RideStartTime,Fare,RideEndTime) values ('"+ride.getRequest().getRequestId()+"','"
          										 +driverId+"','"
          					
          										 
          										 +ride.getRideStartTime()+"','"
          												+ride.getFare()+"','"
          										 +ride.getRideEndTime()+"')";
          										
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
