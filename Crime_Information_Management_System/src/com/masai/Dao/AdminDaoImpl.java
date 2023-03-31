package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.Utitlity.DBUtil;
import com.masai.exception.CrimeException;
import com.masai.model.CrimeDetails;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String addCrimeDetails(CrimeDetails crime) throws CrimeException {
		String msg = "Data Not Inserted...!";
		
		try(Connection con =  DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into crime_details values(?,?,?,?,?,?)");
			ps.setInt(1, crime.getCrime_id());
			ps.setString(2, crime.getCrime_type());
			ps.setString(3, crime.getDescription());
			ps.setString(4, crime.getPs_area());
			ps.setString(5, crime.getDate());
			ps.setString(6, crime.getNameOfVictim());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				msg = "Data Sucessfully Inserted into Crime Table ...";
			}else {
				throw new CrimeException("Invalid Data Entry");
			}
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String updateCrimeDetailsUsingCrimeId(CrimeDetails crime) throws CrimeException {
		String msg = "Data Not Updated...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update crime_details set crime_type = ?,  description = ?, ps_area = ?, date = ?, name_of_victim = ? where crime_id = ? ");
			
			ps.setString(1, crime.getCrime_type());
			ps.setString(2, crime.getDescription());
			ps.setString(3, crime.getPs_area());
			ps.setString(4, crime.getDate());
			ps.setString(5, crime.getNameOfVictim());
			ps.setInt(6, crime.getCrime_id());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Data Sucessfully Updated...";
			}else {
				throw new CrimeException("Invalid Data Entry...");
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}
	
	
}
