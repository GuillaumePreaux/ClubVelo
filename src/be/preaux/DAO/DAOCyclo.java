package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.preaux.POJO.BikeHiker;
import be.preaux.POJO.Category;
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
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(Cyclo obj) {
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
	
	public Cyclo findByMember(int idMember) {
		Cyclo cyclo = new Cyclo();
		try 
		{
			String sql = "SELECT * FROM [Category-Member] "
					+ "WHERE IDCategory="+ idMember;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			if (result.first()) 
			{
				cyclo.setIDCategory(idMember);
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
		return null;
	}
	
	public List<Category> findCategoriesByMember(int IDMember) throws Exception {
		try {
			List<Category> categories = new ArrayList<>();

				String sql = "SELECT * FROM [Category-Member]"
						+ "WHERE IDMember=" + IDMember;
				ResultSet result = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
				while(result.next()) {
					if(result.getInt(1) == 1) 
					{
						Cyclo cyclo = new Cyclo(result.getInt(1),"Cyclo");
						categories.add(cyclo);

					}
					else if(result.getInt(1) == 2) 
					{
						TrialRider trialist = new TrialRider(result.getInt(1),"Trialistes");
						categories.add(trialist);

					}
					else if(result.getInt(1) == 3) 
					{
						DownhillSkier downhillskier = new DownhillSkier(result.getInt(1),"Descendeurs");
						categories.add(downhillskier);

					}
					else 
					{
						BikeHiker bikeHiker =  new BikeHiker(result.getInt(1),"Randonneurs");
						categories.add(bikeHiker);
					}
				}
				return categories;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;

		}
	}

