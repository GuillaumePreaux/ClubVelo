package be.preaux.Windows.Manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.preaux.POJO.Manager;
import be.preaux.POJO.Ride;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FormRide {

	private JFrame frame;
	private Manager manager;
	private Ride ride;
	private JTextField txtStartPlace;
	private JTextField txtStartDate;
	private JTextField txtFee;
	
	
	/**
	 * Create the application.
	 */
	public FormRide(Manager m,Ride r) {
		manager = m;
		ride = r;
		initialize();
	}

	public void open(Manager m,Ride r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRide window = new FormRide(m,r);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtStartPlace = new JTextField();
		txtStartPlace.setBounds(174, 50, 86, 20);
		frame.getContentPane().add(txtStartPlace);
		txtStartPlace.setColumns(10);
		
		txtStartDate = new JTextField();
		txtStartDate.setToolTipText("JJ-MM-AAAA");
		txtStartDate.setBounds(174, 120, 86, 20);
		frame.getContentPane().add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtFee = new JTextField();
		txtFee.setColumns(10);
		txtFee.setBounds(174, 190, 86, 20);
		frame.getContentPane().add(txtFee);
		
		
		
		JButton btnSave = new JButton("Sauvegarder");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ride ride = new Ride();
				ride.setIDCategory(manager.getCategory().getIDCategory());
				ride.setStartDate(LocalDate.parse(txtStartDate.getText(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				ride.setStartPlace(txtStartPlace.getText());
				ride.setFee(Double.parseDouble(txtFee.getText()));
				try 
				{
					ride.addRide();
					HomeManager homeManager;
					homeManager = new HomeManager(manager);
					homeManager.open(manager);
					frame.dispose();
					return;
				} 
				catch (Exception e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnSave.setBounds(157, 227, 103, 23);
		frame.getContentPane().add(btnSave);
		
		
		
		JLabel lblStartPlace = new JLabel("Lieu de d\u00E9part");
		lblStartPlace.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartPlace.setBounds(57, 50, 112, 17);
		frame.getContentPane().add(lblStartPlace);
		
		JLabel lblDateDeDpart = new JLabel("Date de d\u00E9part");
		lblDateDeDpart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDeDpart.setBounds(57, 122, 112, 17);
		frame.getContentPane().add(lblDateDeDpart);
		
		JLabel lblCharge = new JLabel("Charge ");
		lblCharge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharge.setVerticalAlignment(SwingConstants.TOP);
		lblCharge.setBounds(57, 193, 112, 17);
		frame.getContentPane().add(lblCharge);
		
		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ride rideUpdated = new Ride(ride.getIDRide(),ride.getIDCategory(),
						txtStartPlace.getText(),
						LocalDate.parse(txtStartDate.getText(),DateTimeFormatter.ofPattern("dd-MM-yyyy")),
						Double.parseDouble(txtFee.getText()));
				try {
					rideUpdated.updateRide();
					HomeManager homeManager;
					homeManager = new HomeManager(manager);
					homeManager.open(manager);
					frame.dispose();
					return;
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnUpdate.setBounds(157, 227, 103, 23);
		frame.getContentPane().add(btnUpdate);
		
		if(ride != null) {
			txtStartDate.setText(String.valueOf(ride.getStartDate()));
			txtStartPlace.setText(ride.getStartPlace());
			txtFee.setText(String.valueOf(ride.getFee()));
			btnSave.setVisible(false);
			btnUpdate.setVisible(true);
			
		}
	}
}
