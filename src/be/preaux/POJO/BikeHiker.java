package be.preaux.POJO;

import be.preaux.DAO.DAOBikeHiker;

public class BikeHiker extends MountainBike {

	public BikeHiker() {
		// TODO Auto-generated constructor stub
	}

	public BikeHiker(int iDCategory, String name) {
		super(iDCategory, name);
		// TODO Auto-generated constructor stub
	}
	
	public BikeHiker findBikeHiker(int id)
	{
		DAOBikeHiker dao = new DAOBikeHiker(DBConnection.GetInstance());
		return dao.find(id);
	}

}
