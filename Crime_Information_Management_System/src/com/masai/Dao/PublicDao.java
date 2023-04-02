package com.masai.Dao;

import java.util.Map;

import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

public interface PublicDao {

	public Map<String,Integer> totalCrimeForEachPSBetweenDate(String Date1,String Date2) throws CrimeException;
	
	public Map<String, Integer> totalCrimeForEachCrimeTypeBetweenDate(String Date1, String Date2) throws CrimeException ;
	
	public CriminalDetails getCriminalDetailsByCriminalName(String name) throws CriminalException;
	
	public CrimeDetails getCrimeDetailsByDescription(String desc) throws CrimeException;
}
