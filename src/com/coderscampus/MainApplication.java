package com.coderscampus;

import java.io.IOException;
import java.util.Scanner;

public class MainApplication {
public static void main(String[] args) throws IOException {
		
		FileReaderService fileRead = new FileReaderService();
		int numberOfUsers;
		
		// determine length of user data file (aka array length)
		numberOfUsers = fileRead.calculateUsers();
		
		// import user data into array 
		User[] theUsers = new User[numberOfUsers];
		theUsers = fileRead.retrieveUsers(numberOfUsers);
		
		try (Scanner scanner = new Scanner(System.in)) {
			int wrongAttempts = 0;
			int attemptLimit = 5;
			
			while (wrongAttempts <= attemptLimit) {
				
				// collect username & password input
				System.out.println("Enter Username: ");
				String username = scanner.nextLine();
				System.out.println("Enter Password: ");
				String password = scanner.nextLine();
				
				// Validate input against array of users
				int i=0;
				while (i<numberOfUsers) {		
					if (username.equalsIgnoreCase(theUsers[i].getUsername()) && password.equals(theUsers[i].getPassword()) ) {
						System.out.println("Welcome " + theUsers[i].getName());
						System.exit(0);
					} 
					i++;
				}	
				if (wrongAttempts == attemptLimit) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					System.exit(0);
				}	
				else {
					System.out.println("Invalid login, please try again.");
					wrongAttempts++;
				}
							
			}
		}
						
	}

}
