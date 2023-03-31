package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.CrimeException;
import com.masai.model.CrimeDetails;

public class AdminUseCase {

	public void addCrimeDetails(Scanner sc) {
		System.out.print("Enter Crime ID : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Enter Crime Type : ");
		String type = sc.nextLine();
		
		
		System.out.print("Enter Crime Desc : ");
		String desc = sc.nextLine();
		
		System.out.print("Enter Crime Ps_area : ");
		String ps_area = sc.nextLine();
		
		System.out.print("Enter Crime Date : ");
		String date = sc.nextLine();
		
		System.out.print("Enter Crime Victim Name : ");
		String name = sc.nextLine();
		
		CrimeDetails crime = new CrimeDetails();
		
		crime.setCrime_id(id);
		crime.setCrime_type(type);
		crime.setDescription(desc);
		crime.setPs_area(ps_area);
		crime.setDate(date);
		crime.setNameOfVictim(name);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String msg = dao.addCrimeDetails(crime);
			if(msg.equals("Data Sucessfully Inserted into Crime Table ...")) {
				System.out.println(msg);		
			}else {
				System.err.println(msg);
			}
			System.out.println();
		} catch (CrimeException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void updateCrimeDetailsUsingCrimeId(Scanner sc) {
		
		System.out.print("Enter Crime ID To Update Crime Details : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Enter New Crime Type : ");
		String type = sc.nextLine();
		
		
		System.out.print("Enter New Crime Desc : ");
		String desc = sc.nextLine();
		
		System.out.print("Enter New Crime Ps_area : ");
		String ps_area = sc.nextLine();
		
		System.out.print("Enter New Crime Date : ");
		String date = sc.nextLine();
		
		System.out.print("Enter New Crime Victim Name : ");
		String name = sc.nextLine();
		
		CrimeDetails crime = new CrimeDetails();
		
		crime.setCrime_id(id);
		crime.setCrime_type(type);
		crime.setDescription(desc);
		crime.setPs_area(ps_area);
		crime.setDate(date);
		crime.setNameOfVictim(name);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String msg =  dao.updateCrimeDetailsUsingCrimeId(crime);
			if(msg.equals("Data Sucessfully Updated...")) {
				System.out.println(msg);
			}else {
				System.err.println(msg);
			}
		} catch (CrimeException e) {
			System.err.println(e.getMessage());
			
		}
		
	}
	
}
