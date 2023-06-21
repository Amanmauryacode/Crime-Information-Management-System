package com.masai.project;

import java.util.Scanner;

public class Main {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RED = "\u001B[31m";
	
	public static void main(String[] args) {
		
		String opt ;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println(ANSI_GREEN+"|---------------------------------------------------|");
			System.out.println(ANSI_GREEN+"| Welcome To Crime Information Management System    |");
			System.out.println(ANSI_GREEN+"|---------------------------------------------------|");
			System.out.println();
			System.out.println(ANSI_WHITE+"|---------------------------------------------------|");
			System.out.println(ANSI_WHITE+"| 0. Exit                                           |");
			System.out.println(ANSI_WHITE+"| 1. Admin Facilities                               |");
			System.out.println(ANSI_WHITE+"| 2. Public Facilities                              |");
			System.out.println(ANSI_WHITE+"|---------------------------------------------------|");
			System.out.println();
			System.out.print(ANSI_CYAN+"Enter Your Option :");

			opt = sc.next();
			
			switch(opt) {
			
			case "0": System.out.println(ANSI_WHITE+ "|---------------------------------------------------|");
					  System.out.println(ANSI_WHITE+ "|  "+ANSI_GREEN +"Thank You for using Crime Management System.  "+ANSI_WHITE+"   |");
					  System.out.println("|---------------------------------------------------|");
					  break;
			
			case "1" : Admin.adminLogin(sc);
					 break;
			case "2" : Public.publicFacilities();
					 break;
			default : System.err.println(Main.ANSI_RED+"Enter correct option");
					 break;
			}
		
			
		}while(!opt.equals("0"));
		
	}
}
