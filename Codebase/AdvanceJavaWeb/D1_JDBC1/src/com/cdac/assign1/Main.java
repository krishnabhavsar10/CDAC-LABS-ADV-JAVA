package com.cdac.assign1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		try(
				Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1adj", "root", "cdac");
				PreparedStatement stUpdate = connection.prepareStatement("update usertable set password=? where username=?");
				PreparedStatement psInsertAll = connection.prepareStatement("insert into usertable values(?,?,?,?,?)");
				PreparedStatement psSelectUser = connection.prepareStatement("select * from usertable where username=?");
				PreparedStatement psSelectCity = connection.prepareStatement("select * from usertable where city=?");
				
				){
			
			while(true) {
				System.out.println("\n--- User Management System ---");
		        System.out.println("1. Register a User");
		        System.out.println("2. List All Users Based on City");
		        System.out.println("3. Update Password of a User");
		        System.out.println("4. Display User Information Based on User Name");
		        System.out.println("5. Exit");
		        System.out.print("Enter your choice: ");

		        int choice = scanner.nextInt();
		        scanner.nextLine(); // Eater

		        switch (choice) {
		            case 1:
		                registerUser(psInsertAll, scanner);
		                break;
		            case 2:
		                listUsersByCity(psSelectCity, scanner);
		                break;
		            case 3:
		                updatePassword(psSelectUser, stUpdate, scanner);
		                break;
		            case 4:
		                displayUserInfo(psSelectUser, scanner);
		                break;
		            case 5:
		                System.out.println("Exiting the system. Goodbye!");
		                return;
		            default:
		                System.out.println("Invalid choice! Please try again.");
		        }
			}
	        
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void displayUserInfo(PreparedStatement psSelectUser,  Scanner sc) throws SQLException {
		System.out.print("Enter Your username: ");
		String str = sc.nextLine();
		
		psSelectUser.setString(1, str);
		
		ResultSet result = psSelectUser.executeQuery();
		
		if (result.next()) {
	        do {
	            System.out.println(result.getString(1) + " " 
	                + result.getString(2) + " " 
	                + result.getString(3) + " "
	                + result.getString(4) + " "
	                + result.getString(5));
	            System.out.println("----------------------------------------");
	        } while (result.next());
	    } else {
	        System.out.println("No user found with the username: " + str);
	    }
		
	}

	private static void updatePassword(PreparedStatement psSelectUser, PreparedStatement stUpdate, Scanner sc) throws SQLException {
		System.out.print("Enter Your username: ");
		String str = sc.nextLine();
		
		psSelectUser.setString(1, str);
		
		ResultSet result = psSelectUser.executeQuery();
		
		if (result.next()) {
			System.out.print("Enter Your new Password: ");
			String pass = sc.nextLine();
			
			stUpdate.setString(1, pass);
			stUpdate.setString(2, str);
			
	        stUpdate.executeUpdate();
	        System.out.println("Password Update Successfull!!");
	    } else {
	        System.out.println("No user found with the username: " + str);
	    }
			
	}

	private static void listUsersByCity(PreparedStatement psSelectCity,  Scanner sc) throws SQLException {
		System.out.print("Enter Your city: ");
		String city = sc.nextLine();
		
		psSelectCity.setString(1, city);
		
		ResultSet result = psSelectCity.executeQuery();
		
		if (result.next()) {
	        do {
	            System.out.println(result.getString(1) + " " 
	                + result.getString(2) + " " 
	                + result.getString(3) + " "
	                + result.getString(4) + " "
	                + result.getString(5));
	            System.out.println("----------------------------------------");
	        } while (result.next());
	    } else {
	        System.out.println("No user found with the city: " + city);
	    }
		
	}

	private static void registerUser(PreparedStatement psInsert, Scanner sc) throws SQLException {
		System.out.print("Enter Your username: ");
		String username = sc.nextLine();	
		
		System.out.print("Enter Your password: ");
		String password = sc.nextLine();
		
		System.out.print("Enter Your name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Your email: ");
		String email = sc.nextLine();
		
		System.out.print("Enter Your city: ");
		String city = sc.nextLine();
		
		psInsert.setString(1, username);
		psInsert.setString(2,password);
		psInsert.setString(3, name);
		psInsert.setString(4, email);
		psInsert.setString(5, city);
		
		psInsert.executeUpdate();
		
		System.out.println("Registration Successfull!!");
	}

}

