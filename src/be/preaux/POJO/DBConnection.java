package be.preaux.POJO;

import java.sql.*;

public class DBConnection {
	
public static Connection instance = null;
	
	private DBConnection() {
		try{
			String url = "jdbc:ucanaccess://./ClubVelo.accdb";
			instance = DriverManager.getConnection(url);
		}
		
		catch (SQLException ex) {
			System.out.println("Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
			System.out.println( "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
        }
	}
	
	public static Connection GetInstance() {
		if(instance == null)
			new DBConnection();
		return instance;
	}
}


