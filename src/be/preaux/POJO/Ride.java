package be.preaux.POJO;

import java.time.*;

public class Ride {
	
	private int IDRide;
	private int IDCategory;
	private String StartPlace;
	private LocalDate StartDate;
	private Double Fee;
	
	
	public int getIDRide() {
		return IDRide;
	}
	public void setIDRide(int iDRide) {
		IDRide = iDRide;
	}
	public int getIDCategory() {
		return IDCategory;
	}
	public void setIDCategory(int iDCategory) {
		IDCategory = iDCategory;
	}
	public String getStartPlace() {
		return StartPlace;
	}
	public void setStartPlace(String startPlace) {
		StartPlace = startPlace;
	}
	public LocalDate getStartDate() {
		return StartDate;
	}
	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}
	public Double getFee() {
		return Fee;
	}
	public void setFee(Double fee) {
		this.Fee = fee;
	}
	
	public Ride() {
		super();
	}
	public Ride(int iDRide, int iDCategory, String startPlace, LocalDate startDate, Double fee) {
		super();
		IDRide = iDRide;
		IDCategory = iDCategory;
		StartPlace = startPlace;
		StartDate = startDate;
		Fee = fee;
	}
	
	
}
