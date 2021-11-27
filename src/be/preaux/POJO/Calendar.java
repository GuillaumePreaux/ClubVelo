package be.preaux.POJO;

import java.util.*;

import be.preaux.DAO.DAOCalandar;

public class Calendar {

	private List<Ride> rides;
	
	public List<Ride> getAllRide(int IDRide) throws Exception 
	{
		DAOCalandar dao = new DAOCalandar(DBConnection.GetInstance());
		rides = dao.getAllByIDCategory(IDRide);
		return rides;
	}
	
}
