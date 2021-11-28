package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.preaux.POJO.Cyclo;
import be.preaux.POJO.TrialRider;

public class DAOTrialRider extends DAO<TrialRider> {

	public DAOTrialRider(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TrialRider obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TrialRider obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TrialRider find(int id) {
		TrialRider trial = new TrialRider();
		try 
		{
			String sql = "SELECT * FROM Category "
					+ "WHERE IDCategory="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) 
			{
				trial.setIDCategory(id);
				trial.setName(result.getString("Name"));
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return trial;
	}

	@Override
	public List<TrialRider> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
