package com.uber.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Reports {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://spartanride.c1d5rowcx4kr.us-west-2.rds.amazonaws.com:3306/spartanride";
		String user = "spartanride";
		String password = "spartanride123";
		public String reportDetails;
		public String typeOfReport;
		public abstract void showReport();
		
		public Connection Connect(){
			try{
			con = DriverManager.getConnection(url, user, password);
			
		}
			catch(SQLException s){
				System.out.println(s.getMessage());
				
			}
			return con;
			
		}
		
/***		public static void main(String args[]){
			Reports rp = new ListRideHistory() ;
				
			rp.showReport();
			
		}***/
}

