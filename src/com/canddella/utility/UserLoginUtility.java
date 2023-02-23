package com.canddella.utility;

import java.sql.SQLException;
import java.util.Scanner;

import com.canddella.dao.UserLoginDAOImpl;

public class UserLoginUtility {
	
	
	public static void main(String[] args) {
		userLogin();
		}

		public static void userLogin() {
	
				Scanner scanner = new Scanner(System.in);
				System.out.println("***USER LOGIN***");
				System.out.println("----------------");
				System.out.println();

				System.out.println("Enter User Name :");
				String userName = scanner.nextLine();
				System.out.println("Enter Password :");
				String password = scanner.nextLine();

				UserLoginDAOImpl userLoginDAOImpl = new UserLoginDAOImpl();
				boolean isLoginValid;
				try {
					isLoginValid = userLoginDAOImpl.findByUsernameAndPassword(userName, password);
					if (isLoginValid) {
						MainMenuUtility.MainMenu();
					} else {
						System.out.println("Incorrect Login Details. Try again");
						System.out.println();
						userLogin();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


}
