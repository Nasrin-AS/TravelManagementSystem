package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Bus;
import com.canddella.entity.BusRoute;
import com.canddella.service.BusRouteServiceImpl;



public class BusRouteUtility {

	private static final String RouteId = null;


	public static void main(String[] args) {
//		getAllBusRoute();
//		insertIntoBusRoute();
//		getAllBusRoute();
//		updateBusRoute();
//		deleteBusRoute();
//		searchBusRoute();
		menuDisplay();

	}


	private static void insertIntoBusRoute() {
		
		BusUtility.getAllBus();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******Inserting into BusRoute*******");
		System.out.println("Enter the BusID:");
		int busId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Starting Point:");
		String startingPoint = scanner.nextLine();
		System.out.println("Enter the Destination:");
		String destination = scanner.nextLine();
		System.out.println("Enter the Starting Time:");
		String startingTime = scanner.nextLine();
		System.out.println("Enter the Destination Time:");
		String destinationTime = scanner.nextLine();
		
		BusRoute busRoute = new BusRoute();
		//setting bus id to busRoute
		Bus bus = new Bus();
		bus.setBusId(busId);
		busRoute.setBus(bus);
		
		busRoute.setStartingPoint(startingPoint);
		busRoute.setDestination(destination);
		busRoute.setStartingTime(startingTime);
		busRoute.setDestinationTime(destinationTime);
		
		BusRouteServiceImpl busRouteServiceImpl = new BusRouteServiceImpl();
		busRouteServiceImpl.save(busRoute);
		
	

	}
	public static void getAllBusRoute() {
		
		BusRouteServiceImpl busRouteServiceImpl = new BusRouteServiceImpl();
		List<BusRoute> busRouteList = busRouteServiceImpl.findall();
		display();
		for(BusRoute busRoute : busRouteList)
		{
			System.out.println(busRoute.getRouteId()+"\t\t"+busRoute.getBus().getBusId()+"\t\t"+busRoute.getStartingPoint()+"\t\t"+busRoute.getDestination()+"\t\t"
		+busRoute.getStartingTime()+"\t\t"+busRoute.getDestinationTime());
		}
	}
		public static void display() {
			System.out.println("************************************BUSROUTE TABLE************************************");
			System.out.println("______________________________________________________________________________________");
			System.out.println("ROUTE ID\tBUS ID\tSTARTING POINT\tDESTINATION\tSTARTING TIME\tDESTINATION TIME");
			
	}
		public static void updateBusRoute() {
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into BusRoute***********************");
		System.out.println("Enter the RouteID:");
		int routeId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the BusID:");
		int busId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the StartingPoint:");
		String startingPoint = scanner.nextLine();
		System.out.println("Enter the Destination:");
		String destination = scanner.nextLine();
		System.out.println("Enter the StartingTime:");
		String startingTime = scanner.nextLine();
		System.out.println("Enter the DestinationTime:");
		String destinationTime = scanner.nextLine();
		Bus bus = new Bus();
		bus.setBusId(busId);
		
		BusRoute busRoute = new BusRoute(routeId,bus,startingPoint,destination,startingTime,destinationTime);
		BusRouteServiceImpl busRouteService = new BusRouteServiceImpl();
		busRouteService.update(busRoute);
		}
		public static void deleteBusRoute() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************Deleting into BusRoute***********************");
			System.out.println("Enter the RouteID:");
			int routeId = scanner.nextInt();
			scanner.nextLine();
			BusRoute busRoute = new BusRoute(routeId, null, null, null, null, null);
			BusRouteServiceImpl busRouteService = new BusRouteServiceImpl();
			busRouteService.delete(busRoute);
			}
		private static void searchBusRoute() {
			Scanner in = new Scanner(System.in);
			System.out.println("*********************Searching into BusRoute***********************");
			System.out.println("Enter the RouteID:");
			int routeId = in.nextInt();
			in.nextLine();
			BusRoute busRoute = new BusRoute(routeId, null, null, null, null, null);
			BusRouteServiceImpl busRouteService = new BusRouteServiceImpl();
			busRoute = busRouteService.busRouteid(routeId);
		/*	Bus bus = new Bus();
			int busId = in.nextInt();
			in.nextLine();
			bus.setBusId(busId); */
			
			
			if(busRoute!=null)
				System.out.println("Route ID:"+busRoute.getRouteId()+"\nBus ID:"+busRoute.getBus().getBusId()+
						"\nStarting Point:"+busRoute.getStartingPoint()+"\nDestination:"+busRoute.getDestination()+"\nStartingTime :"+busRoute.getStartingTime()
						+"\nDestinationTime :"+busRoute.getDestinationTime());
				else
					System.out.println("Id not found");	
			
		}
			
		public static void menuDisplay() {
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("******************BUSROUTE DETAILS******************\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show BusRoute Details");
				System.out.println("2. Add new BusRoute");
				System.out.println("3. Edit BusRoute Details");
				System.out.println("4. Remove from Busroute");
				System.out.println("5. Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllBusRoute();
					System.out.println("\n");
					break;
					
				case 2:
					getAllBusRoute();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoBusRoute();
							getAllBusRoute();
						}
					} while (response == 'y');

					break;
					
				case 3:
					getAllBusRoute();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateBusRoute();
							getAllBusRoute();
						}
					} while (response == 'y');

					break;

				case 4:
					getAllBusRoute();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteBusRoute();
							getAllBusRoute();
						}
					} while (response == 'y');

					break;
					
				case 5:
					getAllBusRoute();
					do {
						System.out.println("Do you want to Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchBusRoute();
							getAllBusRoute();
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
