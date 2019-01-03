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
		if (trip.getSpeed() >= 5 && trip.getSpeed() <= 100) {
			trips.add(trip);
		}
	}

	public int getTotalDistance() {
		int totalDistance = 0;
		for (Trip trip : trips) {
			totalDistance += (int) Math.round(trip.getDistance());
		}
		return totalDistance;
	}

	public int getAverageSpeed() {
		int averageSpeed = 0;
		for (Trip trip : trips) {
			averageSpeed += (int) Math.round(trip.getSpeed());
		}
		if (trips.size() != 0) {
			averageSpeed = averageSpeed / trips.size();
			return averageSpeed;			
		}
		return 0;
	}

	public String getReport() {
		String report = "";
		report = name + ": " + getTotalDistance() + " miles @ " + getAverageSpeed() + " mph";
		return report;
	}


}
