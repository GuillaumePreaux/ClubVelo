package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.preaux.POJO.BikeHiker;
import be.preaux.POJO.Cyclo;
import be.preaux.POJO.DownhillSkier;
import be.preaux.POJO.TrialRider;

public class DAOCyclo extends DAO<Cyclo> {

	public DAOCyclo(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Cyclo obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cyclo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cyclo find(int id) {
		Cyclo cyclo = new Cyclo();
		try 
		{
			String sql = "SELECT * FROM Category "
					+ "WHERE IDCategory="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) 
			{
				cyclo.setIDCategory(id);
				cyclo.setName(result.getString("Name"));
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return cyclo;
	}


	@Override
	public List<Cyclo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
