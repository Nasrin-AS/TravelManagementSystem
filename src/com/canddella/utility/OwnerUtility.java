package com.canddella.utility;

import java.util.List;
import java.util.Scanner;
import com.canddella.entity.Owner;
import com.canddella.service.OwnerServiceImpl;

/********
 * 
 * @author Nasrin A S
 *
 */

public class OwnerUtility {

	public static void main(String[] args) {
//		getAllOwner();
//		insertIntoOwner();
//		getAllOwner();
//		updateOwner();
//		deleteOwner();
//		searchOwner();
		menuDisplay();

	}
	public static void insertIntoOwner() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Owner***********************");
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Ownername:");
		String ownerName = scanner.nextLine();
		System.out.println("Enter the OwnerAddress:");
		String ownerAddress = scanner.nextLine();
		System.out.println("Enter the OwnerPhoneNumber:");
		String ownerPhoneNumber = scanner.nextLine();
		Owner owner = new Owner(ownerId,ownerName,ownerAddress,ownerPhoneNumber);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.save(owner);

		
		
	}
	/*****
	 * To get all drivers from the driver table
	 */
	
	public static void getAllOwner() {
	
		OwnerServiceImpl ownerServiceImpl = new OwnerServiceImpl();
		List<Owner> ownerList = ownerServiceImpl.findAll();
		display();
		for(Owner owner : ownerList)
		{
			System.out.println(owner.getOwnerId()+"\t\t"+owner.getOwnerName()+"\t\t"+owner.getOwnerAddress()+"\t\t"+owner.getOwnerPhoneNumber());
		}
		
	}
	public static void display() {
		System.out.println("**********************OWNER TABLE*********************");
		System.out.println("______________________________________________________");
		System.out.println("OWNER ID\tOWNER NAME\tOWNER ADDRESS\tOWNER PHONENUMBER");
	


	}
	public static void updateOwner() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into Owner***********************");
		System.out.println("Enter the OwnerID:");
		int ownerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Ownername:");
		String ownerName = scanner.nextLine();
		System.out.println("Enter the OwnerAddress:");
		String ownerAddress = scanner.nextLine();
		System.out.println("Enter the OwnerPhoneNumber:");
		String ownerPhoneNumber = scanner.nextLine();
		Owner owner = new Owner(ownerId,ownerName,ownerAddress,ownerPhoneNumber);
		OwnerServiceImpl ownerService = new OwnerServiceImpl();
		ownerService.update(owner);
		}
	
		public static void deleteOwner() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************deleting into Owner***********************");
			System.out.println("Enter the OwnerID:");
			int ownerId = scanner.nextInt();
			scanner.nextLine();
			Owner owner = new Owner(ownerId, null, null, null);
			OwnerServiceImpl ownerService = new OwnerServiceImpl();
			ownerService.delete(owner);
			}
		public static void searchOwner() {
			Scanner in = new Scanner(System.in);
			System.out.println("*********************Searching into Owner***********************");
			System.out.println("Enter the OwnerID:");
			int ownerId = in.nextInt();
			in.nextLine();
			Owner owner = new Owner(ownerId, null, null, null);
			OwnerServiceImpl ownerService = new OwnerServiceImpl();
			owner = ownerService.ownerid(ownerId);
			if(owner!=null)
				System.out.println("Owner ID:"+owner.getOwnerId()+"\nOwnerName :"+owner.getOwnerName()+
						"\nOwnerAddress:"+owner.getOwnerAddress()+"\nOwnerPhoneNumber :"+owner.getOwnerPhoneNumber());
				else
					System.out.println("Id not found");
		}
		
		
		public static void menuDisplay() {
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("******************OWNER DETAILS******************\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show Owner Details");
				System.out.println("2. Add new Owner");
				System.out.println("3. Edit Owner Details");
				System.out.println("4. Remove from Owner");
				System.out.println("5. Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllOwner();
					System.out.println("\n");
					break;
					
				case 2:
					getAllOwner();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;
					
				case 3:
					getAllOwner();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;

				case 4:
					getAllOwner();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteOwner();
							getAllOwner();
						}
					} while (response == 'y');

					break;
					
				case 5:
					getAllOwner();
					do {
						System.out.println("Do you want to Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchOwner();
							getAllOwner();
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
