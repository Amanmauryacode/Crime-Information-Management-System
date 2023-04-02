package com.masai.usecases;

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

			System.out.println(ANSI_GREEN+"Ps_Area        Total_Crime");
			for (Map.Entry<String, Integer> set : map.entrySet()) {
				System.out.println(ANSI_GREEN+set.getKey() + " ---- " + set.getValue());
			}
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

			System.out.println(ANSI_GREEN+"Crime_type     Total_Count");
			for (Map.Entry<String, Integer> set : map.entrySet()) {
				System.out.println(ANSI_GREEN+set.getKey() + " ---- " + set.getValue());
			}
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}

	}
	
	public void getCriminalDetails(Scanner sc) {
		
		System.out.print("Enter Criminal Name : ");
		String name = sc.next();
		
		PublicDao dao = new PublicDaoImpl();
		
		try {
			CriminalDetails criminal = dao.getCriminalDetailsByCriminalName(name);
			System.out.println(ANSI_GREEN+criminal);
		} catch (CriminalException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}
	}
	
	public void getCrimeDetails(Scanner sc) {
		
		System.out.print("Enter Crime Description : ");
		String desc = sc.next();
		
		PublicDao dao = new PublicDaoImpl();
		
		try {
			CrimeDetails crime = dao.getCrimeDetailsByDescription(desc);
			System.out.println(ANSI_GREEN+crime);
		} catch (CrimeException e) {
			System.err.println(Main.ANSI_RED+e.getMessage());
		}
	}
	
}
