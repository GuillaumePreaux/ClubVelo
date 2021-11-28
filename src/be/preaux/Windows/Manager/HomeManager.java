package be.preaux.Windows.Manager;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import be.preaux.POJO.Calendar;
import be.preaux.POJO.Manager;
import be.preaux.POJO.Ride;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeManager {

	private JFrame frame;
	private Manager manager;
	private JTable table;
	private int selectedRow;

	
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
		frame.setBounds(100, 100, 495, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setBounds(10, 11, 119, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel.setText(manager.getSurname());
		
		JButton btnNewButton = new JButton("Ajouter balade");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormRide formRide;
				formRide = new FormRide(manager,null);
				formRide.open(manager,null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(305, 36, 164, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel((String) null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(184, 11, 285, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1.setText("Vous gérez la catégorie : " + manager.getCategory().getName());
		
		List<Ride> calandar = new ArrayList<>();
		Calendar ca = new Calendar();
		calandar = ca.getAllRide(manager.getCategory().getIDCategory());
		
		String[] col = {"Lieu","Date","Charge"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			for (int i = 0; i < calandar.size(); i++) 
			{
				String Lieu  = calandar.get(i).getStartPlace();
				LocalDate Date = calandar.get(i).getStartDate();
				double Charge = calandar.get(i).getFee();
				Object[] data  = {Lieu,Date,Charge};
				tableModel.addRow(data);
			}
		table = new JTable(tableModel);
		table.setBounds(10, 36, 285, 214);
		table.setEditingRow(0);
		frame.getContentPane().add(table);
		
		JButton btnSupprimerBalade = new JButton("Supprimer balade");
		btnSupprimerBalade.setEnabled(false);
		btnSupprimerBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ride> calandar = new ArrayList<>();
				Calendar ca = new Calendar();
				try {
					calandar = ca.getAllRide(manager.getCategory().getIDCategory());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Ride ride = new Ride(calandar.get(selectedRow).getIDRide(),
						calandar.get(selectedRow).getIDCategory(),
						calandar.get(selectedRow).getStartPlace(),
						calandar.get(selectedRow).getStartDate(),
						calandar.get(selectedRow).getFee());
				ride.deleteRide();
				((DefaultTableModel)table.getModel()).removeRow(selectedRow);
				btnSupprimerBalade.setEnabled(false);
			}
		});
		btnSupprimerBalade.setBounds(305, 81, 164, 34);
		frame.getContentPane().add(btnSupprimerBalade);
		
		JButton btnModifierBalade = new JButton("Modifier balade");
		btnModifierBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Ride> calandar = new ArrayList<>();
				Calendar ca = new Calendar();
				try {
					calandar = ca.getAllRide(manager.getCategory().getIDCategory());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Ride ride = new Ride(calandar.get(selectedRow).getIDRide(),
						calandar.get(selectedRow).getIDCategory(),
						calandar.get(selectedRow).getStartPlace(),
						calandar.get(selectedRow).getStartDate(),
						calandar.get(selectedRow).getFee());
				FormRide formRide;
				formRide = new FormRide(manager,ride);
				formRide.open(manager,ride);
				frame.dispose();
				
			}
		});
		btnModifierBalade.setEnabled(false);
		btnModifierBalade.setBounds(305, 123, 164, 34);
		frame.getContentPane().add(btnModifierBalade);
	
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				if (selectedRow > -1) {
					btnSupprimerBalade.setEnabled(true);
					btnModifierBalade.setEnabled(true);
				}
			}
		});
	}
}

