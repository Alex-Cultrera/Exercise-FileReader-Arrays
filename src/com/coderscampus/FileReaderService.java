package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
	String fileName = "dataFile";
	int totalUsers;
		
	// method to import user data into an array of strings,
	// and then convert the array of strings in to an array of user objects
	public User[] retrieveUsers(int totalUsers) {
		this.totalUsers=totalUsers;		
		User[] users = new User[totalUsers];
		try (BufferedReader buffReader = new BufferedReader(new FileReader(fileName))) {
			for (int i=0; i<totalUsers; i++) {
				String userInfo = buffReader.readLine();
				String[] userInfoArray = userInfo.split(",");
				users[i] = new User(userInfoArray[0], userInfoArray[1], userInfoArray[2]);
				} 
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace(); 
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		}
		
		return users;
	}
	
	public int calculateUsers() {
		int totalUsers = 0;
		BufferedReader buffReader;
		try {
			buffReader = new BufferedReader(new FileReader(fileName));
			String userInfo = buffReader.readLine();
			while (userInfo != null) {
				totalUsers++;
				userInfo = buffReader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace(); 
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		}		
		return totalUsers;
	}


}
