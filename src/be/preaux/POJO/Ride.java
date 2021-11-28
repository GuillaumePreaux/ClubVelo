package be.preaux.POJO;

import java.time.*;

import be.preaux.DAO.DAORide;

public class Ride {
	
	private int IDRide;
	private int IDCategory;
	private String StartPlace;
	private LocalDate StartDate;
	private double Fee;
	
	
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
	public double getFee() {
		return Fee;
	}
	public void setFee(double fee) {
		this.Fee = fee;
	}
	
	public Ride() {
		super();
	}
	public Ride(int iDRide, int iDCategory, String startPlace, LocalDate startDate, double fee) {
		super();
		IDRide = iDRide;
		IDCategory = iDCategory;
		StartPlace = startPlace;
		StartDate = startDate;
		Fee = fee;
	}
	
	public void addRide() throws Exception {
		DAORide dao = new DAORide(DBConnection.GetInstance());
		dao.create(this);
	}
	public void deleteRide() {
		DAORide dao = new DAORide(DBConnection.GetInstance());
		dao.delete(this.IDRide);
	}
	
	public void updateRide()
	{
		DAORide dao = new DAORide(DBConnection.GetInstance());
		dao.update(this);
	}
		
}
