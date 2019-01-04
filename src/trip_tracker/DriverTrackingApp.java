package trip_tracker;

import java.util.Scanner;

public class DriverTrackingApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		InputProcessor inputProcessor = new InputProcessor();
		System.out.println("What's going on?");
		System.out.println("There's a couple things you can type here:");
		System.out.println("You can type the name of a file to read in the project directory, to add drivers and trips.");
		System.out.println("There's an example file to read, called \"driver-commands.txt\" to try if you'd like");
		System.out.println("You can also add drivers and trips by typing the commands in here, for example \"Driver Hobbes\" will add a driver.");
		System.out.println("Finally, type \"quit\" to quit the application.");
		System.out.println("\n");
		String command = input.nextLine();
		
		while (!command.equalsIgnoreCase("quit")) {
			inputProcessor.processInput(command);
			inputProcessor.sortDriversByDistance();
			System.out.println("\n Driver Stats:");
			for(Driver driver : inputProcessor.getDrivers()) {
				System.out.println(driver.getReport());
			}
			
			System.out.println("Anything else to add?");
			command = input.nextLine();
		}
		input.close();

	}

}
