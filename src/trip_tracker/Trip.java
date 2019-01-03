package trip_tracker;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {
	private double distance;
	private double duration;
	private double speed; //in miles per hour

	public Trip(String userString) { //userString will be something like "Dan startTime end distance"
		String[] splitString = userString.split(" ");
		this.distance = Double.parseDouble(splitString[3]);
		this.duration = LocalTime.parse(splitString[1]).until(LocalTime.parse(splitString[2]), ChronoUnit.HOURS);
		this.speed = this.distance / this.duration;
	}
	
	public Trip(String startTimeString, String endTimeString, String distanceString) {
		this.distance = Double.parseDouble(distanceString);
		this.duration = LocalTime.parse(startTimeString).until(LocalTime.parse(endTimeString), ChronoUnit.HOURS);
		this.speed = this.distance / this.duration;
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
