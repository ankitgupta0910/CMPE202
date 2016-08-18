package com.uber.fare;

import com.uber.request.Request;

public class PremiumCabFare implements FareCalculator{
	private int premiumFare=8;

	@Override
	public int calcualteFare(Request req) {
		int px=req.getPickX();
		int py=req.getPickY();
		int dx=req.getDestX();
		int dy=req.getDestY();
		int f=(dx-px)+(dy-py);
		if(f<0)
			f*=(-1);
		int fare = BASEFARE+premiumFare+f;
		return fare;
	}
	

}
