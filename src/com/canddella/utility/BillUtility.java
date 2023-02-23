package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Bill;
import com.canddella.entity.Booking;
import com.canddella.entity.Passenger;
import com.canddella.service.BillServiceImpl;

public class BillUtility {

	public static void main(String[] args) {

//		getAllBill();
//		insertIntoBill();
//		getAllBill();
//		updateBill();
//		deleteBill();
//		searchBill();
		menuDisplay();

	}

	private static void insertIntoBill() {

		PassengerUtility.getAllPassenger();
		BusRouteUtility.getAllBusRoute();
		BookingUtility.getAllBooking();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*******Inserting into Bill*******");
		System.out.println("Enter the PassengerID:");
		int passengerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the BookingID:");
		int bookingId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PaymentMode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the PaymentDate:");
		String paymentDate = scanner.nextLine();
		System.out.println("Enter teh Amount:");
		int amount = scanner.nextInt();
		scanner.nextLine();
		

		Bill bill = new Bill();
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passengerId);
		bill.setPassenger(passenger);
		Booking booking = new Booking();
		booking.setBookingId(bookingId);
		bill.setBooking(booking);

		bill.setPaymentMode(paymentMode);
		bill.setPaymentDate(paymentDate);
		bill.setAmount(amount);

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		billServiceImpl.save(bill);

	}

	public static void getAllBill() {

		BillServiceImpl billServiceImpl = new BillServiceImpl();
		List<Bill> billList = billServiceImpl.findall();
		display();
		for (Bill bill : billList) {
			System.out.println(bill.getBillId() + "\t\t" + bill.getPassenger().getPassengerId() + "\t\t"+bill.getBooking().getBookingId()+"\t\t"
					+ bill.getPaymentMode() + "\t\t"+ bill.getPaymentDate() + "\t\t"+ bill.getAmount());
		}
	}

	public static void display() {
		System.out.println("************************************BILL TABLE************************************");
		System.out.println("___________________________________________________________________________________");
		System.out.println("BILL ID\tPASSENGER ID\tBOOKING ID\t\tPAYMENT MODE\t\tPAYMENT DATE\t\tAMOUNT");

	}

	public static void updateBill() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into Bill***********************");
		System.out.println("Enter the BillID:");
		int billId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PassengerID:");
		int passengerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the BookingID:");
		int bookingId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the PaymentMode:");
		String paymentMode = scanner.nextLine();
		System.out.println("Enter the PaymentDate:");
		String paymentDate = scanner.nextLine();
		System.out.println("Enter the Amount:");
		int amount = scanner.nextInt();
		scanner.nextLine();
		
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passengerId);
		
		Booking booking = new Booking();
		booking.setBookingId(bookingId);
		
		Bill bill = new Bill(billId, passenger, booking, paymentMode, paymentDate, amount);
		BillServiceImpl billService = new BillServiceImpl();
		billService.update(bill);
	}

	public static void deleteBill() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Deleting into Bill***********************");
		System.out.println("Enter the BillID:");
		int billId = scanner.nextInt();
		scanner.nextLine();
		Bill bill = new Bill(billId,null,null,null,null,0);
		BillServiceImpl billService = new BillServiceImpl();
		billService.delete(bill);
	}
	private static void searchBill() {
		Scanner in = new Scanner(System.in);
		System.out.println("*********************Searching into Bill***********************");
		System.out.println("Enter the BillID:");
		int billId = in.nextInt();
		in.nextLine();
		Bill bill = new Bill(billId, null, null, null, null,0);
		BillServiceImpl billService = new BillServiceImpl();
		bill = billService.billid(billId);
		
		/*Passenger passenger = new Passenger();
		int passengerId = in.nextInt();
		in.nextLine();
		Booking booking = new Booking();
		int bookingId = in.nextInt();
		in.nextLine();
		passenger.setPassengerId(passengerId);
		booking.setBookingId(bookingId);*/
		
		if(bill!=null)
			System.out.println("Bill ID:"+bill.getBillId()+"\nPassenger ID:"+bill.getPassenger().getPassengerId()+
					"\nBooking ID:"+bill.getBooking().getBookingId()+"\nPaymentMode :"+bill.getPaymentMode()+"\nPaymentDate :"
					+bill.getPaymentDate()+"\nAmount :"+bill.getAmount());
			else
				System.out.println("Id not found");
	
		
	}
		

	public static void menuDisplay() {
		Scanner in = new Scanner(System.in);
		boolean condition = true;
		int choice;
		char response;
		do {
			System.out.println("******************BILL DETAILS******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Bill Details");
			System.out.println("2. Add new Bill");
			System.out.println("3. Edit Bill Details");
			System.out.println("4. Remove from Bill");
			System.out.println("5. Search using ID");
			System.out.println("6. Print bill");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();

			switch (choice) {

			case 1:
				getAllBill();
				System.out.println("\n");
				break;

			case 2:
				getAllBill();
				do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = in.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoBill();
						getAllBill();
					}
				} while (response == 'y');

				break;

			case 3:
				getAllBill();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						updateBill();
						getAllBill();
					}
				} while (response == 'y');

				break;

			case 4:
				getAllBill();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						deleteBill();
						getAllBill();
					}
				} while (response == 'y');

				break;
				
			case 5:
				getAllBill();
				do {
					System.out.println("Do you want to Search ? (y/n)");
					response = in.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						searchBill();
						getAllBill();
					}
				} while (response == 'y');

				break;
				
			case 6:
				
				BillPdfGenerator.generateBill();
				break;
				
			case 7:
				System.out.println("**************THANK YOU**************");
				condition = false;
				break;

			default:
				System.out.println("Invalid option, try again.\n");
			}

		} while (condition);
	}

}
