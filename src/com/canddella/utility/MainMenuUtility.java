package com.canddella.utility;

import java.util.Scanner;

public class MainMenuUtility {

	public static void main(String[] args) {
		
		UserLoginUtility.userLogin();
		MainMenu();
		BillPdfGenerator.generateBill();
		//CompanyUtility.menuDisplay();
		//PassengerUtility.menuDisplay();
		//BookingUtility.menuDisplay();
		//DriverUtility.menuDisplay();
		//OwnerUtility.menuDisplay();
		//BusUtility.menuDisplay();
		//BusRouteUtility.menuDisplay();
		//BillUtility.menuDisplay();
	}
	public static void MainMenu() {
		 Scanner in = new Scanner(System.in);
		 boolean  value = true;
		    int num;
		    do {
		    System.out.println("*******************WELCOME*******************\n\n"
		    		+ "**********TRAVEL MANAGEMENT SYSTEM**********\n");	
		    System.out.println("1.COMPANY_DETAILS\n2.PASSENGER_DETAILS\n3.BOOKING_DETAILS\n4.DRIVER_DETAILS\n5.OWNER_DETAILS"
		    		+ "\n6.BUS_DETAILS\n7.BUSROUTE_DETAILS\n8.BILL_DETAILS\n9.Exit");	
		    System.out.print("Enter a Choice: ");
		    num = in.nextInt();
		    
		    switch (num) {
		      case 1:
		    	  CompanyUtility.menuDisplay();
		        break;
		      case 2:
		    	  PassengerUtility.menuDisplay();
		        break;
		      case 3:
		    	  BookingUtility.menuDisplay();
		        break;
		      case 4:
		    	  DriverUtility.menuDisplay();
		        break;
		      case 5:
		    	  OwnerUtility.menuDisplay();
		        break;
		      case 6:
		    	  BusUtility.menuDisplay();
		        break;
		      case 7:
		    	  BusRouteUtility.menuDisplay();
		        break;
		      case 8:
		    	  BillUtility.menuDisplay();
		        break;
		      
		      case 9:
		    	 System.out.println("************THANK YOU************");
		    	 value = false;
		        break;
		      default:
		        System.out.println("**********Wrong Choice Try Again**********\n");
		    }
		    
		  }while(value);

	}


}
