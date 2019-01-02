package trip_tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Driver {
	private String name;
	private ArrayList<Trip> trips = new ArrayList<Trip>();

	public Driver(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void assignTrip(Trip trip) {
		trips.add(trip);
	}

	public double getTotalDistance() {
		
		return 0;
	}


}
