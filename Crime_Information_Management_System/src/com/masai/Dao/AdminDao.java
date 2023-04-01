package com.masai.Dao;

import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

public interface AdminDao {

	public String addCrimeDetails(CrimeDetails crime) throws CrimeException ;
	
	public String updateCrimeDetailsUsingCrimeId(CrimeDetails crime) throws CrimeException ;
	
	public String addCriminalDetails(CriminalDetails cd) throws CriminalException;
	
	public String updateCriminalDetailsUsingCriminalID(CriminalDetails cd) throws CriminalException;
	
	public String assignCriminalToCrime(int Criminal_ID,int Crime_ID) throws CriminalException,CrimeException;
}
