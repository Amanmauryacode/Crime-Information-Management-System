package com.masai.project;

import java.util.Scanner;

public class Admin {

	public static void adminLogin(Scanner sc) {
		
		System.out.print("Enter Your Username : ");
		String username = sc.next();
		
		System.out.print("Enter Your Password : ");
		String password = sc.next();
		
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("Hello Admin");
			Admin.adminFeature();
		}else {
			System.out.println("Wrong Credential ! ");
		}
	}

	public static void adminFeature() {
		
		
		
	}
	
}
