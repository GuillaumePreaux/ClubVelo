package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.preaux.POJO.DownhillSkier;
import be.preaux.POJO.TrialRider;

public class DAODownhillSkier extends DAO<DownhillSkier> {

	public DAODownhillSkier(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DownhillSkier obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DownhillSkier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DownhillSkier find(int id) {
		DownhillSkier downhillSkier = new DownhillSkier();
		try 
		{
			String sql = "SELECT * FROM Category "
					+ "WHERE IDCategory="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) 
			{
				downhillSkier.setIDCategory(id);
				downhillSkier.setName(result.getString("Name"));
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return downhillSkier;
	}

	@Override
	public List<DownhillSkier> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
