package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import be.preaux.POJO.Bike;

public class DAOBike extends DAO<Bike> {

	public DAOBike(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Bike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bike find(int id) {
		Bike bike = new Bike();
		try {
			String sql = "SELECT * FROM Bike "
					+ "WHERE IDBike="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) {
				bike.setIDBike(id);
				bike.setBrand(result.getString("brand"));
				bike.setIDMember(result.getInt("IDMember"));
				bike.setLength(result.getDouble("Length"));
				bike.setType(result.getString("Type"));
				bike.setWeight(result.getDouble("Weight"));
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return bike;
	}


	@Override
	public List<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
