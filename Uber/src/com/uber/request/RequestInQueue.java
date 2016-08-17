package com.uber.request;

import java.sql.SQLException;

import com.uber.database.DBConnect;
import com.uber.members.RiderSignin;

public class RequestInQueue implements RequestState {
	
	RideRequestInterface request;
	
	public RequestInQueue(RideRequestInterface request){
		this.request=request;
		
	}

	@Override
	public String requestInQueue() {
		// TODO Auto-generated method stub
		Request req = (Request)request;
		try {
			new DBConnect().insertRequest(req, RiderSignin.currentRider());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in inserting customer request");
		}
	
		request.setState(new RequestAccepted(request));
		return "Request Is In Queue";
		
	}

	@Override
	public String requestCancelled() {
		// TODO Auto-generated method stub
		return "Need to submit a Request First";
		
	}

	@Override
	public String requestAccepted() {
		// TODO Auto-generated method stub
		return "Need to submit a Request First";
		
	}

	
	@Override
	public String requestCompleted() {
		// TODO Auto-generated method stub
		return "Need to submit a Request First";
		
	}
	public String toString(){
		return "InQueue";
		
	}

}
