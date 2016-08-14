package com.uber.members;

public class Driver extends Member{
	
	private String licenseNumber;
	private String vehicleRegNumber;
	private String vehicleType;
	private String vehicleColor;
	private String vehicleChild;
	private int driverId;
	
	
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
}
