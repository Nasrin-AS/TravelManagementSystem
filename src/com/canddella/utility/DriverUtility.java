package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Driver;
import com.canddella.service.DriverServiceImpl;


/********
 * 
 * @author Nasrin A S
 *
 */

public class DriverUtility {

	public static void main(String[] args) {
//		getAllDriver();
//		insertIntoDriver();
//		getAllDriver();
//		updateDriver();
//		deleteDriver();
//		searchDriver();
		menuDisplay();

	}
	
	public static void insertIntoDriver() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Driver***********************");
		System.out.println("Enter the DriverID:");
		int driverId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Drivername:");
		String driverName = scanner.nextLine();
		System.out.println("Enter the Driverplace:");
		String driverPlace = scanner.nextLine();
		System.out.println("Enter the DriverPhoneNumber:");
		String driverPhoneNumber = scanner.nextLine();
		Driver driver = new Driver(driverId,driverName,driverPlace,driverPhoneNumber);
		DriverServiceImpl driverService = new DriverServiceImpl();
		driverService.save(driver);

		
		
	}
	/*****
	 * To get all drivers from the driver table
	 */
	
	public static void getAllDriver() {
	
		DriverServiceImpl driverServiceImpl = new DriverServiceImpl();
		List<Driver> driverList = driverServiceImpl.findAll();
		display();
		for(Driver driver : driverList)
		{
			System.out.println(driver.getDriverId()+"\t\t"+driver.getDriverName()+"\t\t"+driver.getDriverPlace()+"\t\t"+driver.getDriverPhoneNumber());
		}


	}
	public static void display() {
		System.out.println("*************************DRIVER TABLE*************************");
		System.out.println("______________________________________________________________");
		System.out.println("DRIVER ID\tDRIVER NAME\tDRIVER PLACE\tDRIVER PHONENUMBER");
		
	}
	public static void updateDriver() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into Driver***********************");
		System.out.println("Enter the DriverID:");
		int driverId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Drivername:");
		String driverName = scanner.nextLine();
		System.out.println("Enter the DriverPlace:");
		String driverPlace = scanner.nextLine();
		System.out.println("Enter the DriverPhoneNumber:");
		String driverPhoneNumber = scanner.nextLine();
		Driver driver = new Driver(driverId,driverName,driverPlace,driverPhoneNumber);
		DriverServiceImpl driverService = new DriverServiceImpl();
		driverService.update(driver);
		}
	
		public static void deleteDriver() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************deleting into Driver***********************");
			System.out.println("Enter the DriverID:");
			int driverId = scanner.nextInt();
			scanner.nextLine();
			Driver driver = new Driver(driverId, null, null, null);
			DriverServiceImpl driverService = new DriverServiceImpl();
			driverService.delete(driver);
			}
		
		private static void searchDriver() {
			Scanner in = new Scanner(System.in);
			System.out.println("*********************Searching into Driver***********************");
			System.out.println("Enter the DriverID:");
			int driverId = in.nextInt();
			in.nextLine();
			Driver driver = new Driver(driverId, null, null, null);
			DriverServiceImpl driverService = new DriverServiceImpl();
			driver = driverService.driverid(driverId);
			if(driver!=null)
				System.out.println("Driver ID:"+driver.getDriverId()+"\nDriverName :"+driver.getDriverName()+
						"\nDriverPlace:"+driver.getDriverPlace()+"\ndriverPhoneNumber :"+driver.getDriverPhoneNumber());
				else
					System.out.println("Id not found");
			
		}
		public static void menuDisplay() {
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("******************DRIVER DETAILS******************\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Driver Details");
				System.out.println("2. Add new Driver");
				System.out.println("3. Edit Driver Details");
				System.out.println("4. Remove from Driver");
				System.out.println("5. Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllDriver();
					System.out.println("\n");
					break;
					
				case 2:
					getAllDriver();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoDriver();
							getAllDriver();
						}
					} while (response == 'y');

					break;
					
				case 3:
					getAllDriver();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateDriver();
							getAllDriver();
						}
					} while (response == 'y');

					break;

				case 4:
					getAllDriver();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteDriver();
							getAllDriver();
						}
					} while (response == 'y');

					break;
					
				case 5:
					getAllDriver();
					do {
						System.out.println("Do you want to Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchDriver();
							getAllDriver();
						}
					} while (response == 'y');

					break;
					
				case 6:
					System.out.println("**************THANK YOU**************");
					condition = false;
					break;

				default:
					System.out.println("Invalid option, try again.\n");
				}

			} while (condition);

		}
}
