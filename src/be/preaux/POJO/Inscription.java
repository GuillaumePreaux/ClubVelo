package be.preaux.POJO;

public class Inscription {

	private int IDInscription;
	private int IDRide;
	private int IDBike;
	private int IDMember;
	private boolean Traveller;
	private boolean Bike;
	
	public int getIDInscription() {
		return IDInscription;
	}
	public void setIDInscription(int iDInscription) {
		IDInscription = iDInscription;
	}
	public int getIDRide() {
		return IDRide;
	}
	public void setIDRide(int iDRide) {
		IDRide = iDRide;
	}
	public int getIDBike() {
		return IDBike;
	}
	public void setIDBike(int iDBike) {
		IDBike = iDBike;
	}
	public int getIDMember() {
		return IDMember;
	}
	public void setIDMember(int iDMember) {
		IDMember = iDMember;
	}
	public boolean isTraveller() {
		return Traveller;
	}
	public void setTraveller(boolean traveller) {
		Traveller = traveller;
	}
	public boolean isBike() {
		return Bike;
	}
	public void setBike(boolean bike) {
		Bike = bike;
	}
	
	public Inscription() {
		super();
	}
	
	public Inscription(int iDInscription, int iDRide, int iDBike, int iDMember, boolean traveller, boolean bike) {
		super();
		IDInscription = iDInscription;
		IDRide = iDRide;
		IDBike = iDBike;
		IDMember = iDMember;
		Traveller = traveller;
		Bike = bike;
	}
	
}
