package com.uber.fare;

import com.uber.request.Request;

public class Fare {
	private FareCalculator fareCalculator;
	
	public Fare(FareCalculator fareCalculator){
		this.fareCalculator=fareCalculator;
	}
	public int fareCalculate(Request req)
	{
		return fareCalculator.calcualteFare(req);
	}

}
