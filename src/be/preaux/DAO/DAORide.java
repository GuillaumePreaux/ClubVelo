package be.preaux.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import be.preaux.POJO.Ride;

public class DAORide extends DAO<Ride> {

	public DAORide(Connection co) {
		super(co);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Ride r) throws Exception {
		String sql = "INSERT INTO Ride(StartPlace,StartDate,Fee,IDCategory)"
				+ "VALUES ('" + r.getStartPlace() + "','" 
				+ r.getStartDate() + "'," + r.getFee() + "," 
				+ r.getIDCategory() + ")";
		PreparedStatement pst=connect.prepareStatement(sql);
		pst.execute();
		System.out.println("Course créée");
		pst.close();
		return true;

	}


	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM Ride WHERE IDRide="+ id;
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
	public boolean update(Ride r) {
		try {
			String sql = "UPDATE Ride SET startPlace = '" 
						+ r.getStartPlace() +"', StartDate = '"
						+ r.getStartDate() +"',Fee = "
						+ r.getFee() + " " 
						+ "WHERE IDRide ="+ r.getIDRide();
			
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
	public Ride find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ride> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
