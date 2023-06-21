package com.masai.project;

import java.util.Scanner;
import com.masai.usecases.AdminUseCase;

public class Admin {

	public static void adminLogin(Scanner sc) {
		System.out.println();
		System.out.println(Main.ANSI_WHITE+"|-------------------------------------|");
		System.out.print("|"+Main.ANSI_CYAN+" Enter Your Username : ");
		String username = sc.next();
		System.out.print(Main.ANSI_WHITE+"|"+Main.ANSI_CYAN+" Enter Your Password : ");
		String password = sc.next();
		System.out.println(Main.ANSI_WHITE+"|-------------------------------------|");
		
		if(username.equals("admin") && password.equals("admin")) {
			
			System.out.println();
			Admin.adminFeature(sc);
		}else {
			System.err.println(Main.ANSI_RED+"Wrong Credential ! ");
		}
	}

	public static void adminFeature(Scanner sc) {
		
		
		String opt ;
		
		System.out.println(Main.ANSI_GREEN+"Welcome To Admin Facilities");
		do {
			System.out.println(Main.ANSI_WHITE+"|----------------------------------------------------|");
			System.out.println(Main.ANSI_WHITE+"|                                                    |");
			System.out.println(Main.ANSI_WHITE+"| 0. Logout                                          |");
			System.out.println(Main.ANSI_WHITE+"| 1. Add New Crime Details                           |");
			System.out.println(Main.ANSI_WHITE+"| 2. Update Crime Details                            |");
			System.out.println(Main.ANSI_WHITE+"| 3. Add new Criminal Details                        |");
			System.out.println(Main.ANSI_WHITE+"| 4. Update Criminal Details                         |");
			System.out.println(Main.ANSI_WHITE+"| 5. Assign Criminals To Crime                       |");
			System.out.println(Main.ANSI_WHITE+"| 6. Remove Criminal From Crime                      |");
			System.out.println(Main.ANSI_WHITE+"| 7. Delete Crime Using Crime ID                     |");
			System.out.println(Main.ANSI_WHITE+"| 8. Delete Criminal Using Criminal ID               |");
			System.out.println(Main.ANSI_WHITE+"|----------------------------------------------------|");
			System.out.println();
			System.out.print(Main.ANSI_CYAN+"Enter Your Option : ");
			opt = sc.next();
			AdminUseCase admin = new AdminUseCase();
			
			switch (opt) {
			
			case "0" : System.out.println(Main.ANSI_GREEN+"Thanku for visiting...");
			break;
			
			case "1": {
				admin.addCrimeDetails(sc);
				System.out.println();
			}
			break;
			
			case "2" : {
				admin.updateCrimeDetailsUsingCrimeId(sc);
				System.out.println();
			}
			break;
			
			case "3" : {
				admin.addCriminalDetails(sc);
				System.out.println();
			}
			break;
			
			case "4" :{
				admin.updateCriminalDetailsUsingCriminalID(sc);
				System.out.println();
			}
			break;
			
			case "5" : {
				admin.assignCriminalToCrime(sc);
				System.out.println();
			}
			break;
			
			case "6" : {
				admin.removeCriminalFromCrime(sc);
				System.out.println();
			}
			break;
			
			case "7" : {
				admin.deleteCrimeByUsingCrimeID(sc);
				System.out.println();
			}
			break;
			
			case "8" :{
				admin.deleteCriminalByUsingCriminalID(sc);
				System.out.println();
			}
			break;
			default: System.err.println(Main.ANSI_RED+"Enter correct option");
			
			}
			
		} while (!opt.equals("0"));
		
		System.out.println();
		
	}
	
}
