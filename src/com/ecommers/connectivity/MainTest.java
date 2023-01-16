package com.ecommers.connectivity;

import java.util.Scanner;

public class MainTest {
public static void main(String[] args) throws Exception {
	Scanner scanner = new Scanner(System.in);
	//registration
	RegistrationForm registrationForm = new RegistrationForm();
	registrationForm.getCustomerInfo(scanner);
	//product
	ProductConnectivity  productConnectivity = new ProductConnectivity();
	productConnectivity.getName();
	//cart
		System.out.println("----------------- Welcome to cart ---------------");
			CartConnectivity cartConnectivity = new CartConnectivity();
			cartConnectivity.getValues(scanner);
			System.out.println("-----------------------------------------TOTAL AMOUNT OF PRODUCT---------------------------------------------");
			Column_Calculation cc = new Column_Calculation();
			cc.calculate(scanner);
		System.out.println("VISIT AGAIN AND AGAIN");
		AdminInfo  ai = new AdminInfo();
		ai.CustomerDetails();
		ai.getCartDetails(scanner);
		ai.getProductDetails(scanner);
		System.out.println("---------------------------Thank you for visit----------------------");
       }

}
