package trip_tracker;


import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Tests {
	
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
	public void shouldCreateTripWithDistance() {
		Trip trip1 = new Trip("foo 07:00 08:00 60");
		double idealDistance = 60.0;
		Assert.assertEquals(trip1.getDistance(), idealDistance, 0.001);
	}
	
	@Test
	public void shoudCreateAnotherTripWithDistance() {
		Trip trip1 = new Trip("foo 10:00 10:15 15");
		double expectedDistance = 15.00;
		Assert.assertEquals(trip1.getDistance(), expectedDistance, 0.001);
	}
	
	//Trip logic
	
	@Test
	public void shouldGetTripDuration() {
		Trip testTrip = new Trip("foo 07:00 09:00 60");
		double duration = 120.0;
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
		Assert.assertTrue(testDriver.getTrips().contains(testTrip));
	}
	
	@Test
	public void shouldAssignTwoTripsAndHaveBoth() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 60");
		Trip testTrip2 = new Trip("foo 07:00 08:00 60");
		testDriver.assignTrip(testTrip1);
		testDriver.assignTrip(testTrip2);
		Assert.assertTrue(testDriver.getTrips().contains(testTrip1));
		Assert.assertTrue(testDriver.getTrips().contains(testTrip2));
	}
	
	@Test
	public void shouldIgnoreATripThatsTooSlow() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 1");
		testDriver.assignTrip(testTrip1);
		Assert.assertFalse(testDriver.getTrips().contains(testTrip1));
	}

	@Test
	public void shouldIgnoreATripThatsTooFast() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 3000");
		testDriver.assignTrip(testTrip1);
		Assert.assertFalse(testDriver.getTrips().contains(testTrip1));
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
	
	@Test
	public void shouldGetAverageSpeed() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 40");
		Trip testTrip2 = new Trip("foo 07:00 08:00 20");
		testDriver.assignTrip(testTrip1);
		testDriver.assignTrip(testTrip2);
		
		Assert.assertEquals(30, testDriver.getAverageSpeed());
	}
	
	@Test
	public void shouldReturnDriverReport() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 08:00 40");
		Trip testTrip2 = new Trip("foo 07:00 08:00 20");
		testDriver.assignTrip(testTrip1);
		testDriver.assignTrip(testTrip2);
		
		Assert.assertEquals("foo: 60 miles @ 30 mph", testDriver.getReport());
	}
	
	@Test
	public void shouldReturnDriverReportForLessThanAnHour() {
		Driver testDriver = new Driver("foo");
		Trip testTrip1 = new Trip("foo 07:00 07:15 15");
		testDriver.assignTrip(testTrip1);
		
		System.out.println("dist: " + testTrip1.getDistance());
		System.out.println("speed: " + testTrip1.getSpeed());
		System.out.println("duration" + testTrip1.getDuration());
		Assert.assertEquals("foo: 15 miles @ 60 mph", testDriver.getReport());
	}
	
	
	// Input Processing
	
	@Test
	public void shouldCreateANewDriverFromInput() {
		InputProcessor iP = new InputProcessor();
		iP.processInput("Driver foo");
		
		Collection<String> driverNames = new ArrayList<String>();
		for (Driver driver : iP.getDrivers()) { driverNames.add(driver.getName());}
		
		Assert.assertTrue(driverNames.contains("foo"));
	}
	
	@Test
	public void shouldCreateANewTripFromInput() {
		InputProcessor iP = new InputProcessor();
		iP.processInput("Driver David");
		iP.processInput("Trip David 07:00 08:00 40");
		iP.processInput("Trip David 01:00 02:00 80");

		int totalDistance = 0;
		for (Driver driver : iP.getDrivers()) {
			if (driver.getName().equals("David")) {
				for (Trip trip : driver.getTrips()) {totalDistance += trip.getDistance();}
			}
		}
		
		Assert.assertEquals(120, totalDistance);
	}
	
	@Test
	public void shouldArrangeDriversByMiles() {
		InputProcessor iP = new InputProcessor();
		iP.processInput("Driver Max");
		iP.processInput("Trip Max 07:00 08:00 40");
		iP.processInput("Driver Riley");
		iP.processInput("Trip Riley 07:00 08:00 50");
		iP.processInput("Driver Spiderman");
		iP.processInput("Trip Spiderman 07:00 08:00 45");
		iP.sortDriversByDistance();
		
		Assert.assertEquals(iP.getDrivers().get(0).getName(), "Riley");
		Assert.assertEquals(iP.getDrivers().get(1).getName(), "Spiderman");
		Assert.assertEquals(iP.getDrivers().get(2).getName(), "Max");
		
	}
	
}
