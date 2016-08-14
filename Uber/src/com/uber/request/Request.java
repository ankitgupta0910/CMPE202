package com.uber.request;

import java.util.Date;

public class Request implements RideRequestInterface {
	

	private long requestId;
	RequestState requestState;
	private String requestType="normal";

	private String pickUpLocation;
	private String destination;

	private int pickX, pickY;
	private int destX, destY;

	private Date bookingDate;
	private String vechicleType;
	private String vehicleChild;
	private double FareEstimation;
	

	
	public int getPickX() {
		return pickX;
	}

	public void setPickX(int pickX) {
		this.pickX = pickX;
	}

	public int getPickY() {
		return pickY;
	}

	public void setPickY(int pickY) {
		this.pickY = pickY;
	}

	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}

	
	public Request() {
		requestState = new RequestInQueue(this);
	}

	

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long time) {
		this.requestId = time;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFareEstimation() {
		return FareEstimation;
	}

	public void setFareEstimation(double avg) {
		FareEstimation = avg;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Request:");
		sb.append("\n___________________________________");
		sb.append("\nType of request: " + requestType);
		sb.append("\nPickup Location: " + pickUpLocation + " [" + pickX + ","
				+ pickY + "]");
		sb.append("\nDestination: " + destination + " [" + destX + "," + destY
				+ "]");
		sb.append("\nBooking Date: " + bookingDate);
		sb.append("\nCar Type: " + vechicleType);
	
		sb.append("\nEstimated Fare: " + FareEstimation);
		

		String string = sb.toString();

		return string;
	}
	@Override
	public void requestInQueue() {
		// TODO Auto-generated method stub
		System.out.println(requestState.requestInQueue());
		
	}

	@Override
	public void requestCancelled() {
		// TODO Auto-generated method stub
		System.out.println(requestState.requestCancelled());
		
	}

	@Override
	public void requestAccepted() {
		// TODO Auto-generated method stub
		System.out.println(requestState.requestAccepted());
		
	}

	
	@Override
	public void requestCompleted() {
		// TODO Auto-generated method stub
		System.out.println(requestState.requestCompleted());
		
	}
	@Override
	public RequestState getState() {
		// TODO Auto-generated method stub
		return requestState;
	}
	@Override
	public void setState(RequestState requestState) {
		// TODO Auto-generated method stub
		this.requestState=requestState;
		
	}

	public String getVechicleType() {
		return vechicleType;
	}

	public void setVechicleType(String vechicleType) {
		this.vechicleType = vechicleType;
	}

	public String getVechicleChild() {
		return vehicleChild;
	}

	public void setVechicleChild(String vechicleChild) {
		this.vehicleChild = vechicleChild;
	}
}
