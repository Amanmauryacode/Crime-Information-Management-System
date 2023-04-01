package com.masai.project;

import java.util.Scanner;
import com.masai.usecases.AdminUseCase;

public class Admin {

	public static void adminLogin(Scanner sc) {
		
		System.out.print("Enter Your Username : ");
		String username = sc.next();
		
		System.out.print("Enter Your Password : ");
		String password = sc.next();
		
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println();
			System.out.println("Hello Admin");
			System.out.println();
			Admin.adminFeature(sc);
		}else {
			System.err.println("Wrong Credential ! ");
		}
	}

	public static void adminFeature(Scanner sc) {
		
		
		int opt ;
		
		do {
			System.out.println("Select from Given Option ->");
			System.out.println();
			
			System.out.println("0. Logout");
			System.out.println("1. Add New Crime Details");
			System.out.println("2. Update Crime Details");
			System.out.println("3. Add new Criminal Details");
			System.out.println("4. Update Criminal Details");
			System.out.println("5. Assign Criminals To Crime");
			System.out.println("6. Remove Criminal From Crime");
			System.out.println("7. Delete Crime Using Crime ID");
			System.out.println("8. Delete Criminal Using Criminal ID");
			
			opt = sc.nextInt();
			AdminUseCase admin = new AdminUseCase();
			
			switch (opt) {
			
			case 0 : System.out.println("Thanku for visiting...");
			break;
			
			case 1: {
				admin.addCrimeDetails(sc);
				System.out.println();
			}
			break;
			
			case 2 : {
				admin.updateCrimeDetailsUsingCrimeId(sc);
				System.out.println();
			}
			break;
			
			case 3 : {
				admin.addCriminalDetails(sc);
				System.out.println();
			}
			break;
			
			case 4 :{
				admin.updateCriminalDetailsUsingCriminalID(sc);
				System.out.println();
			}
			break;
			
			case 5 : {
				admin.assignCriminalToCrime(sc);
				System.out.println();
			}
			break;
			
			case 6 : {
				admin.removeCriminalFromCrime(sc);
				System.out.println();
			}
			break;
			
			case 7 : {
				admin.deleteCrimeByUsingCrimeID(sc);
				System.out.println();
			}
			break;
			
			case 8 :{
				admin.deleteCriminalByUsingCriminalID(sc);
				System.out.println();
			}
			break;
			default: System.err.println("Enter valid option no. ");
			
			}
			
		} while (opt !=0);
		
		System.out.println();
		
	}
	
}
