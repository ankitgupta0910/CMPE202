package uber.dispatch.driver;

import com.uber.members.Driver;

public class IsOffline implements DriverState{

	Driver driver;
	public IsOffline (Driver driver){
		this.driver = driver;
	}
	@Override
	public String isOnline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isOffline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inRide() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
