package be.preaux.Windows.Manager;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import be.preaux.POJO.Calendar;
import be.preaux.POJO.Manager;
import be.preaux.POJO.Member;
import be.preaux.POJO.Ride;
import be.preaux.Windows.Member.HomeMember;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HomeManager {

	private JFrame frame;
	private Manager manager;
	private JTable table;

	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public HomeManager(Manager m ) throws Exception {
		manager = m;
		initialize();
		
		
	}
	
	public void open(Manager m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeManager window = new HomeManager(m);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setBounds(10, 11, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel.setText(manager.getSurname());
		
		JButton btnNewButton = new JButton("Consulter Agenda");
		btnNewButton.setBounds(10, 36, 119, 55);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel((String) null);
		lblNewLabel_1.setBounds(217, 11, 207, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1.setText("Vous gérez la catégorie : " + manager.getCategory().getName());
		
		List<Ride> calandar = new ArrayList<>();
		Calendar ca = new Calendar();
		calandar = ca.getAllRide(manager.getCategory().getIDCategory());
		
		String[] col = {"ID","Lieu","Date","Charge"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if (calandar.isEmpty()) 
		{

			JOptionPane.showMessageDialog(null, "Il n'y a aucune balade pour cette catégorie");

			
		} 
		else {
			for (int i = 0; i < calandar.size(); i++) {
				int ID = calandar.get(i).getIDRide();
				String Lieu  = calandar.get(i).getStartPlace();
				LocalDate Date = calandar.get(i).getStartDate();
				Double Charge = calandar.get(i).getFee();
				
			}
		}
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{calandar.get(1).getIDRide(), calandar.get(1).getStartPlace(), calandar.get(1).getStartDate(),calandar.get(1).getFee()},
			},
			new String[] {
				"ID", "Lieu", "Date", "Charge"
			}
		));
		table.setBounds(139, 36, 285, 214);
		frame.getContentPane().add(table);
	}
}
