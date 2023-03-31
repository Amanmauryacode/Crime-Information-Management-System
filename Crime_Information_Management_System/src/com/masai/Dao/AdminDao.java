package com.masai.Dao;

import com.masai.exception.CrimeException;
import com.masai.model.CrimeDetails;

public interface AdminDao {

	public String addCrimeDetails(CrimeDetails crime) throws CrimeException ;
	
	public String updateCrimeDetailsUsingCrimeId(CrimeDetails crime) throws CrimeException ;
	
	
}
