package be.preaux.POJO;

import java.util.List;

import be.preaux.DAO.DAOMember;

public class Member extends Person{

	private double balance; 

	public Member() {
		super();
	}

	public Member(int IDPerson, String name, String surname, String telephone, String nickname, String password,double balance) {
		super(IDPerson, name, surname, telephone, nickname, password);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Member findMember(int id)
	{
		DAOMember dao = new DAOMember(DBConnection.GetInstance());
		return dao.find(id);
	}
	
	public void addMember() throws Exception {
		DAOMember dao = new DAOMember(DBConnection.GetInstance());
		dao.create(this);
	}
	
	public void addCategoryMember(Member m,int ID) throws Exception {
		DAOMember dao = new DAOMember(DBConnection.GetInstance());
		dao.createCategoryMember(m,ID);
	}
	
	public List<Member> getAllMember()
	{
		DAOMember dao = new DAOMember(DBConnection.GetInstance());
		return dao.getAll();
	}

}
