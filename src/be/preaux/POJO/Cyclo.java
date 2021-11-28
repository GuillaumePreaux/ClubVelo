package be.preaux.POJO;

import be.preaux.DAO.DAOCyclo;

public class Cyclo extends Category {

	public Cyclo() {
		// TODO Auto-generated constructor stub
	}

	public Cyclo(int iDCategory, String name) {
		super(iDCategory, name);
		// TODO Auto-generated constructor stub
	}

	public Cyclo findCyclo(int id)
	{
		DAOCyclo dao = new DAOCyclo(DBConnection.GetInstance());
		return dao.find(id);
	}
}
