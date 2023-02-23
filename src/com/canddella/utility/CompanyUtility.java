package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Company;
import com.canddella.service.CompanyServiceImpl;

/********
 * 
 * @author Nasrin A S
 *
 */

public class CompanyUtility {

	public static void main(String[] args) {
//		getAllCompany();
//		insertIntoCompany();
//		getAllCompany();
//		updateCompany();
//		deleteCompany();
//		searchCompany();
		menuDisplay();
		
	}
	public static void insertIntoCompany() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Company***********************");
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Companyname:");
		String companyName = scanner.nextLine();
		System.out.println("Enter the Companyplace:");
		String companyPlace = scanner.nextLine();
		System.out.println("Enter the CompanyPhoneNumber:");
		String companyPhoneNumber = scanner.nextLine();
		Company company = new Company(companyId,companyName,companyPlace,companyPhoneNumber);
		CompanyServiceImpl companyService = new CompanyServiceImpl();
		companyService.save(company);

		
	}
	/*****
	 * To get all departments from the department table
	 */
	
	public static void getAllCompany() {
	
		CompanyServiceImpl companyServiceImpl = new CompanyServiceImpl();
		List<Company> companyList = companyServiceImpl.findAll();
		display();
		for(Company company : companyList)
		{
			System.out.println(company.getCompanyId()+"\t\t"+company.getCompanyName()+"\t\t"+company.getCompanyPlace()+"\t\t"+company.getPhoneNumber());
		}
	}
		public static void display() {
			System.out.println("**************************COMPANY TABLE**************************");
			System.out.println("_________________________________________________________________");
			System.out.println("COMPANY ID\tCOMPANY NAME\tCOMPANY PLACE\tCOMPANY PHONENUMBER");
			
	}
		public static void updateCompany() {
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Updating into Company***********************");
		System.out.println("Enter the CompanyID:");
		int companyId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Companyname:");
		String companyName = scanner.nextLine();
		System.out.println("Enter the Companyplace:");
		String companyPlace = scanner.nextLine();
		System.out.println("Enter the CompanyPhoneNumber:");
		String companyPhoneNumber = scanner.nextLine();
		Company company = new Company(companyId,companyName,companyPlace,companyPhoneNumber);
		CompanyServiceImpl companyService = new CompanyServiceImpl();
		companyService.update(company);
		}
		public static void deleteCompany() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("*********************Deleting into Company***********************");
			System.out.println("Enter the CompanyID:");
			int companyId = scanner.nextInt();
			scanner.nextLine();
			Company company = new Company(companyId, null, null, null);
			CompanyServiceImpl companyService = new CompanyServiceImpl();
			companyService.delete(company);
			}
		public static void searchCompany() {
			Scanner in = new Scanner(System.in);
			System.out.println("*********************Searching into Company***********************");
			System.out.println("Enter the CompanyID:");
			int companyId = in.nextInt();
			in.nextLine();
			Company company = new Company(companyId, null, null, null);
			CompanyServiceImpl companyService = new CompanyServiceImpl();
			company = companyService.companyid(companyId);
			if(company!=null)
				System.out.println("Company ID:"+company.getCompanyId()+"\nCompanyName :"+company.getCompanyName()+
						"\nCompanyPlace :"+company.getCompanyPlace()+"\nCompanyPhoneNumber :"+company.getPhoneNumber()
						);
				else
					System.out.println("Id not found");
		}
		public static void menuDisplay() {
			Scanner in = new Scanner(System.in);
			boolean condition = true;
			int choice;
			char response;
			do {
				System.out.println("******************COMPANY DETAILS******************\n");
				System.out.println("Choose an option:\n");
				System.out.println("1. Show company Details");
				System.out.println("2. Add new company");
				System.out.println("3. Edit company Details");
				System.out.println("4. Remove from company");
				System.out.println("5. Search using ID");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");
				choice = in.nextInt();

				switch (choice) {

				case 1:
					getAllCompany();
					System.out.println("\n");
					break;
					
				case 2:
					getAllCompany();
					do {
						// code to be executed
						System.out.println("Do you want to insert? (y/n)");
						response = in.next().charAt(0);

						if (response == 'n') {
							break;
						} else {

							insertIntoCompany();
							getAllCompany();
						}
					} while (response == 'y');

					break;
					
				case 3:
					getAllCompany();
					do {
						System.out.println("Do you want to Update? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							updateCompany();
							getAllCompany();
						}
					} while (response == 'y');

					break;

				case 4:
					getAllCompany();
					do {
						System.out.println("Do you want to  Delete ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							deleteCompany();
							getAllCompany();
						}
					} while (response == 'y');

					break;
					
				case 5:
					getAllCompany();
					do {
						System.out.println("Do you want to Search ? (y/n)");
						response = in.next().charAt(0);
						if (response == 'n') {
							break;
						} else {
							searchCompany();
							getAllCompany();
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
