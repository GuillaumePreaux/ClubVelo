package be.preaux.POJO;

import be.preaux.DAO.DAOTrialRider;

public class TrialRider extends MountainBike {

	public TrialRider() {
		// TODO Auto-generated constructor stub
	}

	public TrialRider(int iDCategory, String name) {
		super(iDCategory, name);
		// TODO Auto-generated constructor stub
	}
	
	public TrialRider findTrialRider(int id)
	{
		DAOTrialRider dao = new DAOTrialRider(DBConnection.GetInstance());
		return dao.find(id);
	}

}
