package be.preaux.Windows;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionDB {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException {
		
		try 
		{
			//chargement de la classe du driver de la JVM
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null,"Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		}
		
		Connection connec = null;
		Statement stmt = null;
		ResultSet res = null;
		try
		{
			String url = "jdbc:ucanaccess://./ClubVelo.accdb";
			// -> //./ répertoire courant 
			connec = DriverManager.getConnection(url);
			
			
			String requete = "SELECT * FROM Bike";
			stmt = connec.createStatement();
			res = stmt.executeQuery(requete);
			
			String type;
			String brand;
			
			while(res.next())
			{
				type = res.getString(2); //Ou res.getString("NomProduit") nom de la colonne ;
				brand = res.getString(3);
				JOptionPane.showMessageDialog(null,type + " " + brand);
			}
			
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(null,"Erreur JDBC : " + ex.getMessage());
		}
		finally //Toujours fermer la DB
		{
			try
			{
				if	(res != null)
					res.close();
				if (stmt != null);
					stmt.close();
				if (connec != null)
					connec.close();
				
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
				
			}
		}
		
	}
	

}