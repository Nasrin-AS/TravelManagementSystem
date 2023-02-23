package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Bus;
import com.canddella.entity.Driver;
import com.canddella.entity.Owner;
import com.canddella.service.BusServiceImpl;

public class BusUtility {

	public static void main(String[] args) {
		
//		getAllBus();
//		insertIntoBus();
//		getAllBus();
//		updateBus();
//		deleteBus();
//		searchBus();
		menuDisplay();

	}

	private static void insertIntoBus() {
		
		DriverUtility.getAllDriver();
		OwnerUtility.getAllOwner();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******Inserting into Bus*******");
		System.out.println("Enter the DriverID:");
		int driverId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the busName:");
		String busName = scanner.nextLine();
		
		Bus bus = new Bus();
		//setting bus id to busRoute
		Driver driver = new Driver();
		driver.setDriverId(driverId);
		bus.setDriver(driver);
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		bus.setOwner(owner);
		
		bus.setBusName(busName);
		
		BusServiceImpl busServiceImpl = new BusServiceImpl();
		busServiceImpl.save(bus);

	}
	public static void getAllBus() {
		
		BusServiceImpl busServiceImpl = new BusServiceImpl();
		List<Bus> busList = busServiceImpl.findall();
		display();
		for(Bus bus : busList)
		{
			System.out.println(bus.getBusId()+"\t\t"+bus.getDriver().getDriverId()+"\t\t"+bus.getOwner().getOwnerId()+"\t\t"+bus.getBusName());
		}
	}
		public static void display() {
			System.out.println("************************************BUS TABLE************************************");
			System.out.println("______________________________________________________________________________________");
			System.out.println("BUS ID\tDRIVER ID\tOWNER ID\t\tBUS NAME");
			
	}
		public static void updateBus() {
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into Bus***********************");
		System.out.println("Enter the BusID:");
		int busId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the DriverID:");
		int driverId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the BusName:");
		String busName = scanner.nextLine();
		Driver driver = new Driver();
		driver.setDriverId(driverId);
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		
		Bus bus = new Bus(busId,driver,owner,busName);
		BusServiceImpl busService = new BusServiceImpl();
		busService.update(bus);
		}
		public static void deleteBus() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************Deleting into Bus***********************");
			System.out.println("Enter the BusID:");
			int busId = scanner.nextInt();
			scanner.nextLine();
			Bus bus = new Bus(busId, null, null, null);
			BusServiceImpl busService = new BusServiceImpl();
			busService.delete(bus);
			}
		private static void searchBus() {
			Scanner in = new Scanner(System.in);
			System.out.println("*********************Searching into Bus***********************");
			System.out.println("Enter the BusID:");
			int busId = in.nextInt();
			in.nextLine();
			Bus bus = new Bus(busId, null, null, null);
			BusServiceImpl busService = new BusServiceImpl();
			bus = busService.busid(busId);
			/*Driver driver = new Driver();
			int driverId = in.nextInt();
			in.nextLine();
			Owner owner = new Owner();
			int ownerId = in.nextInt();
			in.nextLine();
			driver.setDriverId(driverId);
			owner.setOwnerId(ownerId);*/
			
			if(bus!=null)
				System.out.println("Bus ID:"+bus.getBusId()+"\nDriver ID:"+bus.getDriver().getDriverId()+
						"\nOwner ID:"+bus.getOwner().getOwnerId()+"\nBusName :"+bus.getBusName());
				else
					System.out.println("Id not found");
		
			
		}

		public static void menuDisplay() {
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("******************BUS DETAILS******************\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Bus Details");
				System.out.println("2. Add new Bus");
				System.out.println("3. Edit Bus Details");
				System.out.println("4. Remove from Bus");
				System.out.println("5. Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllBus();
					System.out.println("\n");
					break;
					
				case 2:
					getAllBus();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoBus();
							getAllBus();
						}
					} while (response == 'y');

					break;
					
				case 3:
					getAllBus();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateBus();
							getAllBus();
						}
					} while (response == 'y');

					break;

				case 4:
					getAllBus();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteBus();
							getAllBus();
						}
					} while (response == 'y');

					break;
					
				case 5:
					getAllBus();
					do {
						System.out.println("Do you want to Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchBus();
							getAllBus();
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
