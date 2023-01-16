package com.ecommers.connectivity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class RegistrationForm {
	
	public void getCustomerInfo(Scanner scanner) {
	//	Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the registration form!");
		System.out.println("Please enter your information:");

		System.out.print("Name: ");
		String CustomerName = scanner.nextLine();

		System.out.print("Email: ");
		String CustomerMail = scanner.nextLine();

		System.out.print("City: ");
		String Address = scanner.nextLine();

		System.out.print("Password: ");
		String Password = scanner.nextLine();

		// Connect to the database
		try {
			// loading driver class
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

			// Create a statement
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO customers (CustomerName, CustomerMail, Address, Password) VALUES (?,?,?,?)");
// Close the connection
			ps.setString(1, CustomerName);
			ps.setString(2, CustomerMail);
			ps.setString(3, Address);
			ps.setString(4, Password);

			int i = ps.executeUpdate();
			System.out.println("Registration Successfully.." + i);
			conn.close();
			ps.close();
		//	scanner.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
         
	}
}
