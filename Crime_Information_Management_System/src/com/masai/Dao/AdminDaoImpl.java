package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Utitlity.DBUtil;
import com.masai.exception.CrimeException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeDetails;
import com.masai.model.CriminalDetails;

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
			System.out.println();
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
			
			System.out.println();
			if(x>0) {
				msg = "Data Sucessfully Updated...";
			}else {
				throw new CrimeException("Crime Not Exist With Crime Id : "+crime.getCrime_id() );
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String addCriminalDetails(CriminalDetails cd) throws CriminalException {
		String msg = "Data Not Updated...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into criminal_details values(?,?,?,?,?,?,?)");
			ps.setInt(1, cd.getCriminal_id());
			ps.setString(2, cd.getName());
			ps.setString(3, cd.getDob());
			ps.setString(4, cd.getGender());
			ps.setString(5, cd.getIdentifying_mark());
			ps.setString(6, cd.getFirst_arrest_date());
			ps.setString(7, cd.getArrestedFromPsArea());
			
			int x = ps.executeUpdate();
			
			System.out.println();
			if(x>0) {
				msg = "Data Sucessfully Updated..";
			}else {
				throw new CriminalException("Invalid Data Entry..");
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String updateCriminalDetailsUsingCriminalID(CriminalDetails cd) throws CriminalException {
		String msg = "Data Not Updated...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update criminal_details set name = ?, dob = ?, gender = ?, identifying_mark = ?, first_arrest_date = ?, arrested_from_ps_area = ? where criminal_id = ?  ");
			
			ps.setString(1, cd.getName());
			ps.setString(2, cd.getDob());
			ps.setString(3, cd.getGender());
			ps.setString(4, cd.getIdentifying_mark());
			ps.setString(5, cd.getFirst_arrest_date());
			ps.setString(6, cd.getArrestedFromPsArea());
			ps.setInt(7, cd.getCriminal_id());
			
			int x = ps.executeUpdate();
			
			System.out.println();
			if(x>0) {
				msg = "Data Sucessfully Updated";
			}else {
				throw new CriminalException("Criminal Not Exist with Criminal Id : "+cd.getCriminal_id());
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String assignCriminalToCrime(int Criminal_ID, int Crime_ID) throws CriminalException, CrimeException {
		String msg = "Crime Not Assign to Criminal...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps1 = con.prepareStatement("select * from criminal_details where criminal_id = ?");
			ps1.setInt(1, Criminal_ID);
			
			ResultSet rs1 =  ps1.executeQuery();
			
			if(rs1.next()) {
				
				PreparedStatement ps2 = con.prepareStatement("select * from crime_details where crime_id = ?");
				ps2.setInt(1, Crime_ID);
				
				ResultSet rs2 =  ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps = con.prepareStatement("insert into crime_criminal_details values (?,?)");
					ps.setInt(1, Criminal_ID);
					ps.setInt(2, Crime_ID);
					
					int x =ps.executeUpdate();
					
					if(x>0) {
						msg = "Crime Assign to Criminal Sucessfull...";
					}
					
				}else {
					throw new CrimeException("Crime Not Exist With Crime ID : "+Crime_ID);
				}
				
			}else {
				throw new CriminalException("Criminal Not Exist With Criminal ID : "+Criminal_ID);
			}
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}
	
	
}
