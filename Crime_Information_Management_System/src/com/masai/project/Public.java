package com.masai.project;

import java.util.Scanner;

import com.masai.usecases.PublicUseCase;

public class Public {

	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void publicFacilities() {
		
		Scanner sc = new Scanner(System.in);
		
		int opt ;
		
		PublicUseCase facilities = new PublicUseCase();
		System.out.println(Main.ANSI_CYAN+"Welcome To Public Facilities");
		
		do {
		
			System.out.println();
			System.out.println(ANSI_WHITE+"0. Exit");
			System.out.println(ANSI_WHITE+"1. To View Total Crime For Each Police Station Area B/W Date Range");
			System.out.println(ANSI_WHITE+"2. To View Total Crime For Each Crime Type B/W Date Range");
			System.out.println(ANSI_WHITE+"3. To View Criminal Details By Criminal Name ");
			System.out.println(ANSI_WHITE+"4. To View Crime Details By Crime Description ");
			System.out.print(Main.ANSI_CYAN+"Enter Your Option : ");
			
			opt = sc.nextInt();
			
			switch (opt) {
			case 0: {
				System.out.println(Main.ANSI_GREEN+"Thanku for visiting...");
			}
			break;
			
			case 1 : {
				facilities.totalCrimeForEachPSBetweenDate(sc);
				System.out.println();
			}
			break;
			
			case 2 : {
				facilities.totalCrimeForEachCrimeTypeBetweenDate(sc);
				System.out.println();
			}
			break;
			
			case 3 : {
				facilities.getCriminalDetails(sc);
				System.out.println();
			}
			break;
			
			case 4 : {
				facilities.getCrimeDetails(sc);
				System.out.println();
			}
			break; 
			
			default:
				System.err.println(Main.ANSI_RED+"Invalid Option ");
			}
			
			
		} while (opt !=0);
		
	}
	
}
