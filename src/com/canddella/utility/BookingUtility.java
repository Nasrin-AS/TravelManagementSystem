package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Booking;
import com.canddella.entity.Bus;
import com.canddella.entity.BusRoute;
import com.canddella.entity.Passenger;
import com.canddella.service.BookingServiceImpl;


public class BookingUtility {

	public static void main(String[] args) {

//		getAllBooking();
//		insertIntoBooking();
//		getAllBooking();
//		updateBooking();
//		deleteBooking();
//		searchBooking();
		menuDisplay();

	}

	private static void insertIntoBooking() {
		
		PassengerUtility.getAllPassenger();
		BusRouteUtility.getAllBusRoute();
		BusUtility.getAllBus();
		BookingUtility.getAllBooking();
		
		Scanner in = new Scanner(System.in);
		System.out.println("*******Inserting into Booking*******");
		System.out.println("Enter the PassengerID:");
		int passengerId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the BusID:");
		int busId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the RouteID:");
		int routeId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the BookingDate:");
		String bookingDate = in.nextLine();

		Booking booking = new Booking();
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passengerId);
		booking.setPassenger(passenger);

		Bus bus = new Bus();
		bus.setBusId(busId);
		booking.setBus(bus);

		BusRoute busRoute = new BusRoute();
		busRoute.setRouteId(routeId);
		booking.setBusRoute(busRoute);

		booking.setBookingDate(bookingDate);

		BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
		bookingServiceImpl.save(booking);

	}

	public static void getAllBooking() {

		BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
		List<Booking> bookingList = bookingServiceImpl.findall();
		display();
		for (Booking booking : bookingList) {
			System.out.println(booking.getBookingId() + "	" + booking.getPassenger().getPassengerId()+ "	" + booking.getBus().getBusId() + "	" 
					+ "	" + booking.getBusRoute().getRouteId() + "	" + booking.getBookingDate());
		}
	}

	public static void display() {
		System.out.println("************************************BOOKING TABLE************************************");
		System.out.println("______________________________________________________________________________________");
		System.out.println("BOOKING_ID  PASSENGER_ID  BUS_ID  ROUTE_ID  BOOKING_DATE");

	}

	public static void updateBooking() {

		Scanner in = new Scanner(System.in);
		System.out.println("*********************Updating into Booking***********************");
		System.out.println("Enter the BookingID:");
		int bookingId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the PassengerID:");
		int passengerId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the BusID:");
		int busId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the RouteID:");
		int routeId = in.nextInt();
		in.nextLine();
		System.out.println("Enter the BookingDate:");
		String bookingDate = in.nextLine();
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passengerId);
		
		Bus bus = new Bus();
		bus.setBusId(busId);
		
		BusRoute busRoute = new BusRoute();
		busRoute.setRouteId(routeId);
		
		Booking booking = new Booking(bookingId, passenger, bus, busRoute, bookingDate);
		BookingServiceImpl bookingService = new BookingServiceImpl();
		bookingService.update(booking);
	}

	public static void deleteBooking() {

		Scanner in = new Scanner(System.in);
		System.out.println("*********************Deleting into Booking***********************");
		System.out.println("Enter the BookingID:");
		int bookingId = in.nextInt();
		in.nextLine();
		Booking booking = new Booking(bookingId,null,null,null,null);
		BookingServiceImpl bookingService = new BookingServiceImpl();
		bookingService.delete(booking);
	}
	private static void searchBooking() {
		Scanner in = new Scanner(System.in);
		System.out.println("*********************Searching into Booking***********************");
		System.out.println("Enter the BookingID:");
		int bookingId = in.nextInt();
		Booking booking = new Booking(bookingId, null, null, null, null);
		BookingServiceImpl bookingService = new BookingServiceImpl();
		booking = bookingService.bookingid(bookingId);
		
	/*	Passenger passenger = new Passenger();
		int passengerId = in.nextInt();

		Bus bus = new Bus();
		int busId = in.nextInt();
		
		BusRoute busRoute = new BusRoute();
		int routeId = in.nextInt();
		
		busRoute.setRouteId(routeId); */
		
		
		if(booking!=null)
			System.out.println("Booking ID:"+booking.getBookingId()+"\nPassenger ID:"+booking.getPassenger().getPassengerId()+"\nBus ID:"+booking.getBus().getBusId()
			+"\nRoute ID:"+booking.getBusRoute().getRouteId()+"\nBooking Date:"+booking.getBookingDate());
			else
				System.out.println("Id not found");	
		
	
	}

	public static void menuDisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************BOOKING DETAILS******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Booking Details");
			System.out.println("2. Add new Booking");
			System.out.println("3. Edit Booking Details");
			System.out.println("4. Remove from Booking");
			System.out.println("5. Search using ID");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllBooking();
				System.out.println("\n");
				break;

			case 2:
				getAllBooking();
				do {
					System.out.println("Do you want to insert? (y/n)");
					response = in.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoBooking();
						getAllBooking();
					}
				} while (response == 'y');

				break;

			case 3:
				getAllBooking();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						updateBooking();
						getAllBooking();
					}
				} while (response == 'y');

				break;

			case 4:
				getAllBooking();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						deleteBooking();
						getAllBooking();
					}
				} while (response == 'y');

				break;
				
			case 5:
				getAllBooking();
				do {
				System.out.println("Do you want to Search ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						searchBooking();
						getAllBooking();
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
