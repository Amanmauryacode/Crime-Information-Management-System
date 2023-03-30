package com.masai.model;

public class CrimeDetails {

	private int crime_id;
	private String crime_type;
	private String description;
	private String ps_area;
	private String Date;
	private String nameOfVictim;
	
	public CrimeDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CrimeDetails(int crime_id, String crime_type, String description, String ps_area, String date,
			String nameOfVictim) {
		super();
		this.crime_id = crime_id;
		this.crime_type = crime_type;
		this.description = description;
		this.ps_area = ps_area;
		Date = date;
		this.nameOfVictim = nameOfVictim;
	}

	public int getCrime_id() {
		return crime_id;
	}

	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}

	public String getCrime_type() {
		return crime_type;
	}

	public void setCrime_type(String crime_type) {
		this.crime_type = crime_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPs_area() {
		return ps_area;
	}

	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getNameOfVictim() {
		return nameOfVictim;
	}

	public void setNameOfVictim(String nameOfVictim) {
		this.nameOfVictim = nameOfVictim;
	}

	@Override
	public String toString() {
		return "crime_id=" + crime_id + ", crime_type=" + crime_type + ", description=" + description
				+ ", ps_area=" + ps_area + ", Date=" + Date + ", nameOfVictim=" + nameOfVictim + "\n";
	}
	
	
}
