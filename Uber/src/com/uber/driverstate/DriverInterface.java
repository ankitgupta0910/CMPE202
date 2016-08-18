package com.uber.driverstate;

public interface DriverInterface {
	public void isOnline();
	public void isOffline();
	public void inRide();
	public DriverState getDriverState();
	public void setDriverState(DriverState driverState);

}
