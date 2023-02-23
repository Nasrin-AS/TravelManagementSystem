package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Passenger;
import com.canddella.service.PassengerServiceImpl;
/********
 * 
 * @author Nasrin A S
 *
 */

public class PassengerUtility {

	public static void main(String[] args) {
//		getAllPassenger();
//		insertIntoPassenger();
//		getAllPassenger();
//		updatePassenger();
//		deletePassenger();
//		searchPassenger();
		menuDisplay();

	}
	public static void insertIntoPassenger() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Passenger***********************");
		System.out.println("Enter the PassengerID:");
		int passengerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Passengername:");
		String passengerName = scanner.nextLine();
		System.out.println("Enter the PassengerAddress:");
		String passengerAddress = scanner.nextLine();
		System.out.println("Enter the PassengerPhoneNumber:");
		String passengerPhoneNumber = scanner.nextLine();
		System.out.println("Enter the PassengerMailId:");
		String passengerMailId = scanner.nextLine();
		Passenger passenger = new Passenger(passengerId,passengerName,passengerAddress,passengerPhoneNumber,passengerMailId);
		PassengerServiceImpl passengerService = new PassengerServiceImpl();
		passengerService.save(passenger);
		
	}
	/*****
	 * To get all departments from the department table
	 */
	
	public static void getAllPassenger() {
	
		PassengerServiceImpl passengerServiceImpl = new PassengerServiceImpl();
		List<Passenger> passengerList = passengerServiceImpl.findAll();
		display();
		for(Passenger passenger : passengerList)
		{
			System.out.println(passenger.getPassengerId()+"\t\t"+passenger.getPassengerName()+"\t\t"+passenger.getPassengerAddress()+"\t\t"+passenger.getPassengerPhoneNumber()+"\t\t"+passenger.getPassengerMailId());
		}
	}
	
		public static void display() {
			System.out.println("*************************************PASSENGER TABLE*************************************");
			System.out.println("_________________________________________________________________________________________");
			System.out.println("PASSENGER ID\tPASSENGER NAME\tPASSENGER ADDRESS\tPASSENGER PHONENUMBER\tPASSENGER MAIL ID");
	}
		
		public static void updatePassenger() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************Updating into Passenger***********************");
			System.out.println("Enter the PassengerID:");
			int passengerId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the Passengername:");
			String passengerName = scanner.nextLine();
			System.out.println("Enter the PassengerAddress:");
			String passengerAddress = scanner.nextLine();
			System.out.println("Enter the PassengerPhoneNumber:");
			String passengerPhoneNumber = scanner.nextLine();
			System.out.println("Enter the PassengerMailId:");
			String passengerMailId = scanner.nextLine();
			Passenger passenger = new Passenger(passengerId,passengerName,passengerAddress,passengerPhoneNumber,passengerMailId);
			PassengerServiceImpl passengerService = new PassengerServiceImpl();
			passengerService.update(passenger);
			}
		
			public static void deletePassenger() {
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("*********************deleting into Passenger***********************");
				System.out.println("Enter the PassengerID:");
				int passengerId = scanner.nextInt();
				scanner.nextLine();
				Passenger passenger = new Passenger(passengerId, null, null, null, null);
				PassengerServiceImpl passengerService = new PassengerServiceImpl();
				passengerService.delete(passenger);
				}
			
			public static void searchPassenger() {
				Scanner in = new Scanner(System.in);
				System.out.println("*********************Searching into Passenger***********************");
				System.out.println("Enter the PassengerID:");
				int passengerId = in.nextInt();
				in.nextLine();
				Passenger passenger = new Passenger(passengerId, null, null, null, null);
				PassengerServiceImpl passengerService = new PassengerServiceImpl();
				passenger = passengerService.passengerid(passengerId);
				if(passenger!=null)
					System.out.println("Passenger ID:"+passenger.getPassengerId()+"\nPassengerName :"+passenger.getPassengerName()+
							"\nPassengerAddress:"+passenger.getPassengerAddress()+"\nPassengerPhoneNumber :"+passenger.getPassengerPhoneNumber()
							+"\nPassengerMailId:"+passenger.getPassengerMailId());
					else
						System.out.println("Id not found");
			}
			
			public static void menuDisplay() {
				Scanner in = new Scanner(System.in);
				boolean condition = true;
				int choice;
				char response;
				do {
					System.out.println("******************PASSENGER DETAILS******************\n");
					System.out.println("Choose an option:\n");
					System.out.println("1. Show Passenger Details");
					System.out.println("2. Add new Passenger");
					System.out.println("3. Edit Passenger Details");
					System.out.println("4. Remove from Passenger");
					System.out.println("5. Search using ID");
					System.out.println("6. Exit");
					System.out.print("Enter your choice: ");
					choice = in.nextInt();

					switch (choice) {

					case 1:
						getAllPassenger();
						System.out.println("\n");
						break;
						
					case 2:
						getAllPassenger();
						do {
							// code to be executed
							System.out.println("Do you want to insert? (y/n)");
							response = in.next().charAt(0);

							if (response == 'n') {
								break;
							} else {

								insertIntoPassenger();
								getAllPassenger();
							}
						} while (response == 'y');

						break;
						
					case 3:
						getAllPassenger();
						do {
							System.out.println("Do you want to Update? (y/n)");
							response = in.next().charAt(0);
							if (response == 'n') {
								break;
							} else {
								updatePassenger();
								getAllPassenger();
							}
						} while (response == 'y');

						break;

					case 4:
						getAllPassenger();
						do {
							System.out.println("Do you want to  Delete ? (y/n)");
							response = in.next().charAt(0);
							if (response == 'n') {
								break;
							} else {
								deletePassenger();
								getAllPassenger();
							}
						} while (response == 'y');

						break;
						
					case 5:
						getAllPassenger();
						do {
							System.out.println("Do you want to Search ? (y/n)");
							response = in.next().charAt(0);
							if (response == 'n') {
								break;
							} else {
								searchPassenger();
								getAllPassenger();
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
