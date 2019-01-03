package trip_tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InputProcessor {
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}



	public void processInput(String input){
		String[] splitString = input.split(" ");
		
		//if the first word is driver:
		if (splitString[0].equalsIgnoreCase("driver")) {
			Driver driver = new Driver(splitString[1]);
			drivers.add(driver);
		}
		
		//if the first word is trip:
		else if (splitString[0].equalsIgnoreCase("trip")) {
			Driver driver = findDriverByName(splitString[1]);
			Trip trip = new Trip(splitString[2], splitString[3], splitString[4]);
			driver.assignTrip(trip);
		}
		
		sortDriversByDistance();
	}

	
	private Driver findDriverByName(String name) {
		for(Driver driver : drivers) {
			if (driver.getName().equals(name)){
				return driver;
			}
		}
		return null;
	}
	
	private void sortDriversByDistance() {
		Collections.sort(drivers, new Comparator<Driver>() {
			public int compare(Driver o1, Driver o2) {
				return o2.getTotalDistance() - o1.getTotalDistance();
			}
		});

	}


}
