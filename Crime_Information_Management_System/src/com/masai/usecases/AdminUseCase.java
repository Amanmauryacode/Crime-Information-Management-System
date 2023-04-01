package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

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
		
		System.out.print("Enter Crime Date [YYYY-MM-DD] : ");
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
	
	
	public void addCriminalDetails(Scanner sc) {
		
		System.out.print("Enter Criminal ID : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Enter Criminal Name : ");
		String name = sc.nextLine();
		
		System.out.print("Enter Criminal Date of Birth : ");
		String dob = sc.nextLine();
		
		System.out.print("Enter Criminal Gender : ");
		String gender = sc.nextLine();
		
		System.out.print("Enter Criminal Identifying Mark  : ");
		String identifying_mark  = sc.nextLine();
		
		System.out.print("Enter Criminal First Arrest Date : ");
		String first_arrest_date = sc.nextLine();
		
		System.out.print("Enter Criminal Arrested From Ps Area : ");
		String arrested_from_ps_area = sc.nextLine();
		
		CriminalDetails cd = new CriminalDetails();
		
		cd.setCriminal_id(id);
		cd.setName(name);
		cd.setDob(dob);
		cd.setGender(gender);
		cd.setIdentifying_mark(identifying_mark);
		cd.setFirst_arrest_date(first_arrest_date);
		cd.setArrestedFromPsArea(arrested_from_ps_area);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		 	String msg = dao.addCriminalDetails(cd);
		 	if(msg.equals("Data Sucessfully Updated..")) {
		 		System.out.println(msg);
		 	}else {
		 		System.err.println(msg);
		 	}
		} catch (CriminalException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void updateCriminalDetailsUsingCriminalID(Scanner sc) {
		
		System.out.print("Enter Criminal ID To Update Criminal Details : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Enter Criminal Name : ");
		String name = sc.nextLine();
		
		System.out.print("Enter Criminal Date of Birth : ");
		String dob = sc.nextLine();
		
		System.out.print("Enter Criminal Gender : ");
		String gender = sc.nextLine();
		
		System.out.print("Enter Criminal Identifying Mark  : ");
		String identifying_mark  = sc.nextLine();
		
		System.out.print("Enter Criminal First Arrest Date : ");
		String first_arrest_date = sc.nextLine();
		
		System.out.print("Enter Criminal Arrested From Ps Area : ");
		String arrested_from_ps_area = sc.nextLine();
		
		CriminalDetails cd = new CriminalDetails();
		
		cd.setCriminal_id(id);
		cd.setName(name);
		cd.setDob(dob);
		cd.setGender(gender);
		cd.setIdentifying_mark(identifying_mark);
		cd.setFirst_arrest_date(first_arrest_date);
		cd.setArrestedFromPsArea(arrested_from_ps_area);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String msg = dao.updateCriminalDetailsUsingCriminalID(cd);
			
			if(msg.equals("Data Sucessfully Updated")) {
				System.out.println(msg);
			}else {
				System.err.println(msg);
			}
		} catch (CriminalException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public void assignCriminalToCrime(Scanner sc) {
		
		System.out.print("Enter Criminal Id To Assgin Crime : ");
		int Criminal_id = sc.nextInt();
		
		System.out.print("Enter Crime Id To Assgin Crime to Criminal : ");
		int Crime_id = sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		
		 try {
			String msg = dao.assignCriminalToCrime(Criminal_id, Crime_id);
			System.out.println(msg);
		} catch (CriminalException e) {
			System.err.println(e.getMessage());
		} catch (CrimeException e) {
			System.err.println(e.getMessage());
		}
		 
		
	}
	
}
