package trip_tracker;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {
	private double distance;
	private double duration; //in minutes!
	private double speed; //in miles per hour

	public Trip(String userString) { //userString will be something like "Dan startTime end distance"
		String[] splitString = userString.split(" ");
		this.distance = Double.parseDouble(splitString[3]);
		LocalTime startTime = LocalTime.parse(splitString[1]);
		LocalTime endTime = LocalTime.parse(splitString[2]);
		this.duration = startTime.until(endTime, ChronoUnit.MINUTES);
		this.speed = this.distance / (this.duration/60);
	}
	
	public Trip(String startTimeString, String endTimeString, String distanceString) {
		this.distance = Double.parseDouble(distanceString);
		LocalTime startTime = LocalTime.parse(startTimeString);
		LocalTime endTime = LocalTime.parse(endTimeString);
		this.duration = startTime.until(endTime, ChronoUnit.MINUTES);
		this.speed = this.distance / (this.duration/60);
	}


	public double getDistance() {
		return distance;
	}

	public double getDuration() {
		return duration;
	}

	public double getSpeed() {
		return speed;
	}


}
