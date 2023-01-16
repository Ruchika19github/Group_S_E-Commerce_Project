package com.ecommers.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CustomerLogin_Connectivity {
public void getCustomerLogin() {
	Scanner  scanner = new Scanner(System.in);
	System.out.println("-----------------------------------Welcome to Login Page-----------------------------------");
	System.out.println("Enter the Customer Email :");
	String CustomerMail =scanner.next();
	System.out.println("Enter the Password :");
	String Password = scanner.next();
	try {
		// loading driver class
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

		// Create a statement
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO customers ( CustomerMail, Password) VALUES (?,?)");
//Close the connection
		ps.setString(1,CustomerMail );
		ps.setString(2, Password);
		int i = ps.executeUpdate();
		System.out.println(" Customer Login completed........................." + i);
		conn.close();
		ps.close();
		scanner.close();
}catch(Exception e) {
	e.printStackTrace();
}
}
}