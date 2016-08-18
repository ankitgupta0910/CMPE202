package com.uber.fare;

import com.uber.request.Request;

public class BidAmountFare implements FareCalculator{

	@Override
	public int calcualteFare(Request req) {
		// TODO Auto-generated method stub
		return req.getBidFare();
	}

}
