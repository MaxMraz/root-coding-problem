package trip_tracker;

import java.util.Scanner;

public class DriverTrackingApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		InputProcessor inputProcessor = new InputProcessor();
		System.out.println("What's going on?");
		System.out.println("You can add a driver or a trip or type \"quit\"");
		String command = input.nextLine();
		
		while (!command.equalsIgnoreCase("quit")) {
			inputProcessor.processInput(command);
			for(Driver driver : inputProcessor.getDrivers()) {
				System.out.println(driver.getReport());
			}
			
			command = input.nextLine();
		}

	}

}
