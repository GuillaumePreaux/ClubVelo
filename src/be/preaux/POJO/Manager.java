package be.preaux.POJO;

import java.util.List;

import be.preaux.DAO.DAOManager;

public class Manager extends Person {
	
	private Category category;

	public Manager(int IDPerson, String name, String surname, String telephone, String nickname, String password,Category category) {
		super(IDPerson, name, surname, telephone, nickname, password);
		this.category = category;
	}

	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
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
