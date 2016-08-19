package com.uber.members;

import java.util.HashMap;

public class LocationMapping {

	private static LocationMapping locationsObject;
	private HashMap<String, Location> locations = new HashMap<String, Location>();

	private LocationMapping() {
		getLocations().put("1 Washington Square , San Jose", new Location(2, 3));
		getLocations().put("1883 Agnew Road, Santa Clara", new Location(3, 5));
		getLocations().put("190 Ryland Street , Campbell", new Location(1, 2));
		getLocations().put("3481 S Bascom Ave, Fremont", new Location(1, 2));
		getLocations().put("14777 Los Gatos BLVD, Fremont", new Location(4,5));
		getLocations().put("1410 Camden Ave, Cupertino", new Location(3,4));
		getLocations().put("3025 Meridian Ave, Palo Alto", new Location(6,6));
	}

	public static LocationMapping getLocationObject() {
		if (locationsObject == null) {
			locationsObject = new LocationMapping();
		}
		return locationsObject;
	}

	public HashMap<String, Location> getLocations() {
		return locations;
	}

}
