package com.masai.Dao;

import java.util.List;
import java.util.Map;

import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

public interface PublicDao {

	public Map<String,Integer> totalCrimeForEachPSBetweenDate(String Date1,String Date2) throws CrimeException;
	
	public Map<String, Integer> totalCrimeForEachCrimeTypeBetweenDate(String Date1, String Date2) throws CrimeException ;
	
	public List<CriminalDetails> getCriminalDetailsByCriminalName(String name) throws CriminalException;
	
	public List<CrimeDetails> getCrimeDetailsByDescription(String desc) throws CrimeException;
	public List<CrimeDetails> getCrimeDetailsByCrimeType(String type) throws CrimeException;
}
