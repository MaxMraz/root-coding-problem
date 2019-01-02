package trip_tracker;


import java.time.LocalTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DriverTest {
	
	@Test public void makeSureTestsAreWorking() {
		Assert.assertEquals(1,  1);
	}
	
	
	//Create A Driver
	
	@Test
	public void aDriverShouldHaveAName() {
		String name = "foo";
		Driver underTest = new Driver(name);
		Assert.assertEquals(name, underTest.getName());	
	}
	
	//Create A Trip
	
	@Test
	public void shouldCreateTripWithStartTime() {
		Trip trip1 = new Trip("foo 07:00 08:00 60");
		LocalTime idealStartTime = LocalTime.parse("07:00");
		Assert.assertEquals(trip1.getStartTime(), idealStartTime);
	}
	
	@Test
	public void shouldCreateTripWithEndTime() {
		Trip trip1 = new Trip("foo 07:00 08:00 60");
		LocalTime idealEndTime = LocalTime.parse("08:00");
		Assert.assertEquals(trip1.getEndTime(), idealEndTime);
	}
	
	@Test
	public void shouldCreateTripWithDistance() {
		Trip trip1 = new Trip("foo 07:00 08:00 60");
		double idealDistance = 60.0;
		Assert.assertEquals(trip1.getDistance(), idealDistance, 0.001);
	}
	
	//Trip logic
	
	@Test
	public void shouldGetTripDuration() {
		Trip testTrip = new Trip("foo 07:00 09:00 60");
		double duration = 2.0;
		Assert.assertEquals(duration, testTrip.getDuration(), 0.01);
	}
	
	@Test
	public void shouldGetTripSpeed() {
		Trip testTrip = new Trip("foo 07:00 08:00 60");
		double speed = 60.0;
		Assert.assertEquals(speed, testTrip.getSpeed(), 0.01);
	}
	
	
	
	//Assign a trip to a driver
	
	@Test
	public void shouldAssignATripToADriver() {
		Driver testDriver = new Driver("foo");
		Trip testTrip = new Trip("foo 07:00 08:00 60");
		testDriver.assignTrip(testTrip);
		Assert.assertEquals(true, testDriver.getTrips().contains(testTrip));
	}
	
	@Test
	public void shouldAssignTwoTripsAndHaveBoth() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 60");
		Trip testTrip2 = new Trip("foo 07:00 08:00 60");
		testDriver.assignTrip(testTrip1);
		testDriver.assignTrip(testTrip2);
		Assert.assertEquals(true, testDriver.getTrips().contains(testTrip1));
		Assert.assertEquals(true, testDriver.getTrips().contains(testTrip2));
	}
	
	
	//Get Trip stats
	
	@Test
	public void shouldGetTotalDistanceOfTrips() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 60");
		Trip testTrip2 = new Trip("foo 07:00 08:00 60");
		testDriver.assignTrip(testTrip1);
		testDriver.assignTrip(testTrip2);
		
		Assert.assertEquals(120.0, testDriver.getTotalDistance(), 0.001);
	}
	
}
