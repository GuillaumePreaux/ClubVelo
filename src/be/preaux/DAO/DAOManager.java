package be.preaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.preaux.POJO.Manager;

public class DAOManager extends DAO<Manager>{

	public DAOManager(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Manager m) throws Exception {
		
			String sql = "INSERT INTO Manager(Name,Surname,Telephone,Nickname,Password)"
					+ "VALUES ('" + m.getName() + "','" 
					+ m.getSurname() + "','" + m.getTelephone()+ "','" 
					+ m.getNickname() + "','" + m.getPassword() + "')";
			PreparedStatement pst=connect.prepareStatement(sql);
			pst.execute();
			System.out.println("Manager créé");
			pst.close();
			return true;

	}

	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM Manager WHERE IDManager="+ id;
			PreparedStatement pst=connect.prepareStatement(sql);
			pst.execute();
			System.out.println("Suppression effectuée");
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	@Override
	public boolean update(Manager m) {
		try {
			String sql = "UPDATE Manager SET Name ='" + m.getName() +"',Surname = " + m.getSurname() +",Telephone = " + m.getTelephone() + ",Nickname =" + m.getNickname() + ",Password =" + m.getPassword() +
							"WHERE IDManager ="+ m.getIDPerson();	
			PreparedStatement pst=connect.prepareStatement(sql);
			pst.execute();
			System.out.println("Modification effectuée");
			pst.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

	@Override
	public Manager find(int id) {
		Manager manager = new Manager();
		try {
			String sql = "SELECT * FROM manager "
					+ "WHERE IDPerson="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) {
				manager.setIDPerson(id);
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return manager;
	}

	@Override
	public List<Manager> getAll() {
	try {
		List<Manager> managers = new ArrayList<>();
		
			String sql = "SELECT * FROM Manager";
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			while(result.next()) {
				Manager manager = new Manager();
				manager.setIDPerson(result.getInt("IDManager"));
				manager.setSurname(result.getString("Surname"));
				manager.setName(result.getString("Name"));
				manager.setNickname(result.getString("Nickname"));
				manager.setPassword(result.getString("Password"));
				manager.setTelephone(result.getString("Telephone"));
				managers.add(manager);
			}
			return managers;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.exit(0);
	}
	return null;

	}

}
