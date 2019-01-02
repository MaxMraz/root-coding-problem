package trip_tracker;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {
	private LocalTime startTime;
	private LocalTime endTime;
	private double distance;
	private double duration;
	private double speed; //in miles per hour

	public Trip(String userString) { //userString will be something like "Dan startTime end distance"
		String[] splitString = userString.split(" ");

		this.startTime = LocalTime.parse(splitString[1]);
		this.endTime = LocalTime.parse(splitString[2]);
		this.distance = Double.parseDouble(splitString[3]);
		
		this.duration = this.startTime.until(this.endTime, ChronoUnit.HOURS);
		this.speed = this.distance / this.duration;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
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
