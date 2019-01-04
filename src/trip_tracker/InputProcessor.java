package trip_tracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		
		//otherwise, assume the user is typing a file name to be read
		else {
			readDriverFile(input);
		}
	}

	
	private Driver findDriverByName(String name) {
		for(Driver driver : drivers) {
			if (driver.getName().equals(name)){
				return driver;
			}
		}
		return null;
	}
	
	public void sortDriversByDistance() {
		Collections.sort(drivers, new Comparator<Driver>() {
			public int compare(Driver o1, Driver o2) {
				return o2.getTotalDistance() - o1.getTotalDistance();
			}
		});

	}
	
	public void readDriverFile(String name) {
		try {
            File file = new File(name);
            if (file.exists()) {
            	System.out.println("Yep, that's a file");
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            StringBuffer stringBuffer = new StringBuffer();
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                stringBuffer.append(line);
	                stringBuffer.append("\n");
	                processInput(line);
	            }
	            fileReader.close();
            } else {
            	System.out.println("I can't find that file, dude. Try again.");
            }
        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

        System.out.println("");
	}


}
