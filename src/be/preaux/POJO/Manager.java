package be.preaux.POJO;

import java.util.List;

import be.preaux.DAO.DAOManager;

public class Manager extends Person {
	

	public Manager(int IDPerson, String name, String surname, String telephone, String nickname, String password) {
		super(IDPerson, name, surname, telephone, nickname, password);
		// TODO Auto-generated constructor stub
	}

	public Manager() {
		super();
	}

	public Manager findManager(int id)
	{
		DAOManager dao = new DAOManager(DBConnection.GetInstance());
		return dao.find(id);
	}
	
	public void addManager() throws Exception {
		DAOManager dao = new DAOManager(DBConnection.GetInstance());
		dao.create(this);
	}
	
	public List<Manager> getAllManager() 
	{
		DAOManager dao = new DAOManager(DBConnection.GetInstance());
		return dao.getAll();
	}
	
	

	
}
