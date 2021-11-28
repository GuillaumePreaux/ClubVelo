package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.preaux.POJO.BikeHiker;
import be.preaux.POJO.Cyclo;

public class DAOBikeHiker extends DAO<BikeHiker> {

	public DAOBikeHiker(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(BikeHiker obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BikeHiker obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BikeHiker find(int id) {
		BikeHiker bikeHiker = new BikeHiker();
		try 
		{
			String sql = "SELECT * FROM Category "
					+ "WHERE IDCategory="+ id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) 
			{
				bikeHiker.setIDCategory(id);
				bikeHiker.setName(result.getString("Name"));

			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return bikeHiker;
	}

	@Override
	public List<BikeHiker> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
