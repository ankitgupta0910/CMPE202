package com.uber.members;
import java.sql.Connection;
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

		String url = "jdbc:mysql://spartanride.c1d5rowcx4kr.us-west-2.rds.amazonaws.com:3306/spartanride";
		String user = "spartanride";
		String password = "spartanride123";

		try {

			con = DriverManager.getConnection(url, user, password);
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
