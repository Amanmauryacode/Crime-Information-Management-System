package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.masai.Utitlity.DBUtil;
import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

public class PublicDaoImpl implements PublicDao{

	@Override
	public Map<String, Integer> totalCrimeForEachPSBetweenDate(String Date1, String Date2) throws CrimeException {
		Map<String , Integer> map = new HashMap<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select ps_area,COUNT(ps_area) from crime_details where date BETWEEN '"+Date1+"' AND '"+Date2+"' GROUP BY ps_area");
						
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				flag = false;
				map.put(rs.getString(1), rs.getInt(2));
			}
			
			if(flag) {
				throw new CrimeException("No Crime Happened Between "+Date1+" And "+Date2);
			}			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		
		return map;
	}
	
	
	public Map<String, Integer> totalCrimeForEachCrimeTypeBetweenDate(String Date1, String Date2) throws CrimeException {
		Map<String , Integer> map = new HashMap<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select crime_type,COUNT(crime_type) from crime_details where date BETWEEN '"+Date1+"' AND '"+Date2+"' GROUP BY crime_type");
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				flag = false;
				map.put(rs.getString(1), rs.getInt(2));
			}
			
			if(flag) {
				throw new CrimeException("No Crime Happened Between "+Date1+" And "+Date2);
			}			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		
		return map;
	}


	@Override
	public CriminalDetails getCriminalDetailsByCriminalName(String name) throws CriminalException {
		CriminalDetails criminal = new CriminalDetails();
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from criminal_details where name = ?");
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();	
			
						
			if(rs.next()) {
				criminal.setCriminal_id(rs.getInt(1));
				criminal.setName(rs.getString(2));
				criminal.setDob(rs.getString(3));
				criminal.setGender(rs.getString(4));
				criminal.setIdentifying_mark(rs.getString(5));
				criminal.setFirst_arrest_date(rs.getString(6));
				criminal.setArrestedFromPsArea(rs.getString(7));
			}else {
				throw new CriminalException("Criminal Not Found With Name : "+name);
			}
		} catch (SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		return criminal;
		
	}


	@Override
	public CrimeDetails getCrimeDetailsByDescription(String desc) throws CrimeException {
		CrimeDetails crime = new CrimeDetails();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from crime_details where description = ?");
			ps.setString(1, desc);
		    ResultSet rs = ps.executeQuery();
			
		    if(rs.next()) {
		    	
		    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    	
		    	
		    	crime.setCrime_id(rs.getInt(1));
		    	crime.setCrime_type(rs.getString(2));
		    	crime.setDescription(rs.getString(3));
		    	crime.setPs_area(rs.getString(4));
		    	crime.setDate(df.format(rs.getDate(5)));
		    	crime.setNameOfVictim(rs.getString(6));
		 		    	
		    }else {
		    	throw new CrimeException("Crime Not Exist With Description : "+desc);
		    }
		    
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		
		return crime;
	}

}
