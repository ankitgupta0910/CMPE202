package com.uber.members;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

import com.uber.request.Request;

public class AdminSignin {
	Admin admin;
	public AdminSignin(){
		
	}
//	public static Rider currentRider(){
//		return currentRider;
//	}
	public Admin signIn(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Username: ");
		String user = sc.nextLine();
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		if (user == "admin" && pass == "password")
			{
				admin.setName("Admin");
			}
		return admin;
		
	}

	

}
