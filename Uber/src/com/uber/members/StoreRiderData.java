package com.uber.members;
import java.sql.Connection;
import com.uber.constants.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class StoreRiderData {

	Rider rider;

	public StoreRiderData(Rider rider){
		this.rider=rider;
		connect();
	}

	public void connect(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		

		try {

			con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
			st = con.createStatement();

			String stmt = "Insert into rider (RiderName,Address,Phone,DOB,CardNumber,CardExpDate,CVV,Email,Password) values ('"+rider.getName()+"','"
					+rider.getAddress()+"','"
					+rider.getPhone()+"','"
					+rider.getDob()+"','"
					+rider.getCardNumber()+"','"
					+rider.getExpDate()+"',"
					+rider.getCvv()+",'"
					+rider.getEmail()+"','"
					+rider.getPass()+"')";
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
