package be.preaux.POJO;

public class Vehicle {
	private int IDVehicle;
	private int NumberPlaceMember;
	private int NumberPlaceBike;

	
	public int getIDVehicle() {
		return IDVehicle;
	}
	public void setIDVehicle(int iDVehicle) {
		IDVehicle = iDVehicle;
	}
	public int getNumberPlaceMember() {
		return NumberPlaceMember;
	}
	public void setNumberPlaceMember(int numberPlaceMember) {
		NumberPlaceMember = numberPlaceMember;
	}
	public int getNumberPlaceBike() {
		return NumberPlaceBike;
	}
	public void setNumberPlaceBike(int numberPlaceBike) {
		NumberPlaceBike = numberPlaceBike;
	}
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(int iDVehicle, int numberPlaceMember, int numberPlaceBike) {
		super();
		IDVehicle = iDVehicle;
		NumberPlaceMember = numberPlaceMember;
		NumberPlaceBike = numberPlaceBike;
	}
	
}
