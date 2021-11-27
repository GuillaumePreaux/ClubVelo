package be.preaux.POJO;

import be.preaux.DAO.DAOBike;

public class Bike {
	
	private int IDBike;
	private int IDMember;
	private String Brand;
	private Double Weight;
	private String Type;
	private Double Length;
	
	
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
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public Double getWeight() {
		return Weight;
	}
	public void setWeight(Double weight) {
		Weight = weight;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Double getLength() {
		return Length;
	}
	public void setLength(Double length) {
		Length = length;
	}
	public Bike findBike(int id)
	{
		DAOBike dao = new DAOBike(DBConnection.GetInstance());
		return dao.find(id);
	}
	
	public Bike() {
	}

	public Bike(int iDBike, int iDMember, String brand, Double weight, String type, Double length) {
		super();
		IDBike = iDBike;
		IDMember = iDMember;
		Brand = brand;
		Weight = weight;
		Type = type;
		Length = length;
	}


	@Override
	public String toString() {
		if(IDBike == 0)
		{
			return "Erreur aucun vélo n'a été trouvé";
		}
		
		return "Vélo n°: " + IDBike + ", IDMember=" + IDMember + ", Brand=" + Brand + ", Weight=" + Weight
					+ ", Type=" + Type + ", Lenght=" + Length + "]";
	
		
	}
}
