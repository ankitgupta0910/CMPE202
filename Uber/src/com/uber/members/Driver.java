package com.uber.members;

public class Driver extends Member{
	
	private String licenseNumber;
	private String vehicleRegNumber;
	private String vehicleType;
	private String vehicleColor;
	private String vehicleChild;
	private int driverId;
	private String driverRating;
	private int sourceLat;
	private int sourceLong;
	private String childSeat;
	
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}
	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getVehicleChild() {
		return vehicleChild;
	}
	public void setVehicleChild(String vehicleChild) {
		this.vehicleChild = vehicleChild;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(String driverRating) {
		this.driverRating = driverRating;
	}
	public int getSourceLong() {
		return sourceLong;
	}
	public void setSourceLong(int sourceLong) {
		this.sourceLong = sourceLong;
	}
	public int getSourceLat() {
		return sourceLat;
	}
	public void setSourceLat(int sourceLat) {
		this.sourceLat = sourceLat;
	}
	public String getChildSeat() {
		return childSeat;
	}
	public void setChildSeat(String childSeat) {
		this.childSeat = childSeat;
	}
}
