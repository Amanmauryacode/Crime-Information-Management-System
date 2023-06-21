package com.masai.usecases;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.Dao.PublicDao;
import com.masai.Dao.PublicDaoImpl;
import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;
import com.masai.project.Main;

public class PublicUseCase {
	
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public void totalCrimeForEachPSBetweenDate(Scanner sc) {

		System.out.print("Enter The Starting Date [YYYY-MM-DD] : ");
		String date1 = sc.next();

		System.out.print("Enter The Ending Date [YYYY-MM-DD] : ");
		String date2 = sc.next();

		PublicDao dao = new PublicDaoImpl();

		try {
			Map<String, Integer> map = dao.totalCrimeForEachPSBetweenDate(date1, date2);
			System.out.println();
			System.out.println(ANSI_GREEN+"|----------------------------------------------|");
			for (Map.Entry<String, Integer> set : map.entrySet()) {
				System.out.println("| "+ANSI_GREEN+set.getKey() + "  ---->  " + set.getValue());
			}
			System.out.println(ANSI_GREEN+"|----------------------------------------------|");
			
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}

	}

	public void totalCrimeForEachCrimeTypeBetweenDate(Scanner sc) {

		System.out.print("Enter The Starting Date [YYYY-MM-DD] : ");
		String date1 = sc.next();

		System.out.print("Enter The Ending Date [YYYY-MM-DD] : ");
		String date2 = sc.next();

		PublicDao dao = new PublicDaoImpl();

		try {
			Map<String, Integer> map = dao.totalCrimeForEachCrimeTypeBetweenDate(date1, date2);

			System.out.println();
			System.out.println();
			System.out.println(ANSI_GREEN+"|----------------------------------------------|");
			for (Map.Entry<String, Integer> set : map.entrySet()) {
				System.out.println("| "+ANSI_GREEN+set.getKey() + "  ---->  " + set.getValue());
			}
			System.out.println(ANSI_GREEN+"|----------------------------------------------|");
			
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}

	}
	
	public void getCriminalDetails(Scanner sc) {
		
		System.out.print("Enter Criminal Name : ");
		String name = sc.next();
		
		PublicDao dao = new PublicDaoImpl();
		
		try {
			List<CriminalDetails> criminalList = dao.getCriminalDetailsByCriminalName(name);
			for(CriminalDetails criminal : criminalList) {
				System.out.println(ANSI_GREEN+criminal);
			}
			
		} catch (CriminalException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}
	}
	
	public void getCrimeDetails(Scanner sc) {
		sc.nextLine();
		System.out.print("Enter Crime Description : ");
		String desc = sc.nextLine();
		
		PublicDao dao = new PublicDaoImpl();
		
		try {
			List<CrimeDetails> crimeList =  dao.getCrimeDetailsByDescription(desc);
			for(CrimeDetails crime : crimeList) {
				System.out.println(ANSI_GREEN+crime);
			}
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}
	}
	
	public void getCrimeDetailsByType(Scanner sc) {
		sc.nextLine();
		System.out.print("Enter Crime Type : ");
		String type = sc.nextLine();
		
		PublicDao dao = new PublicDaoImpl();
		
		try {
			List<CrimeDetails> crimeList =  dao.getCrimeDetailsByCrimeType(type);
			for(CrimeDetails crime : crimeList) {
				System.out.println(ANSI_GREEN+crime);
			}
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}
	}
	
}
