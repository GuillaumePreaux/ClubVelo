package be.preaux.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.preaux.POJO.Calendar;
import be.preaux.POJO.Ride;

public class DAOCalandar extends DAO<Calendar>{

	public DAOCalandar(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Calendar obj) throws Exception {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(Calendar obj) {
		return false;
	}

	@Override
	public Calendar find(int id) {
		return null;
	}

	public List<Ride> getAllByIDCategory(int IDCategory) throws Exception {
		try {
			List<Ride> rides = new ArrayList<>();
			
				String sql = "SELECT * FROM Ride WHERE IDCategory = " + IDCategory ;
				ResultSet result = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
				while(result.next()) {
					Ride ride = new Ride();
					ride.setIDCategory(IDCategory);
					ride.setIDRide(result.getInt("IDRide"));
					ride.setStartDate(result.getDate("StartDate").toLocalDate());
					ride.setStartPlace(result.getString("StartPlace"));
					rides.add(ride);
				}
				return rides;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return null;

		}

	@Override
	public List<Calendar> getAll() throws Exception {
	
		return null;
	
	}
}
