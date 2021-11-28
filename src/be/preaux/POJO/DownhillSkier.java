package be.preaux.POJO;

import be.preaux.DAO.DAODownhillSkier;

public class DownhillSkier extends MountainBike {

	public DownhillSkier() {
		// TODO Auto-generated constructor stub
	}

	public DownhillSkier(int iDCategory, String name) {
		super(iDCategory, name);
		// TODO Auto-generated constructor stub
	}
	
	public DownhillSkier findDownhillSkier(int id)
	{
		DAODownhillSkier dao = new DAODownhillSkier(DBConnection.GetInstance());
		return dao.find(id);
	}

}
