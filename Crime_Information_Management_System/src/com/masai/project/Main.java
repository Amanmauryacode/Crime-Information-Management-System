package com.masai.project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int opt ;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Enter the Correct Option to Enter in Crime Management System.");
			
			System.out.println("0. Exit");
			System.out.println("1. Admin Role ");
			System.out.println("2. Public Role");
			opt = sc.nextInt();
			
			switch(opt) {
			case 0: System.out.println("Thank You for using Crime Management System.");
					 break;
			
			case 1 : Admin.adminLogin(sc);
					 break;
			case 2 : System.out.println("Hello Public");
					 break;
			default : System.out.println("Enter correct option");
					 break;
			}
		
			
		}while(opt != 0);
		
	}
}
