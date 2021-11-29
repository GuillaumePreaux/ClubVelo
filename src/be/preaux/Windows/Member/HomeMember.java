package be.preaux.Windows.Member;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import be.preaux.POJO.Category;
import be.preaux.POJO.Cyclo;
import be.preaux.POJO.Member;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class HomeMember {

	private JFrame frame;
	private Member member;
	private JTable table;
	private JTable tableCategorie;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public HomeMember(Member m ) {
		member = m;
		initialize();
		
		
		
	}
	
	public void open(Member m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMember window = new HomeMember(m);
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
		frame.setBounds(100, 100, 876, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Membre");
		lblNewLabel.setBounds(10, 11, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Member ");
		lblName.setBounds(104, 11, 81, 14);
		frame.getContentPane().add(lblName);
		
		lblName.setText(member.getSurname());
		
		
		
		JPanel panelCategorie = new JPanel();
		panelCategorie.setBounds(100, 25, 760, 456);
		frame.getContentPane().add(panelCategorie);
		panelCategorie.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Ajouter cat\u00E9gorie");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categories categories = new Categories(member);
				categories.open(member);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(617, 21, 133, 23);
		panelCategorie.add(btnNewButton_1);
		
		List<Category> categories = new ArrayList<>();
		Cyclo cyclo 				= new Cyclo();
		try {
			categories	= cyclo.findCategoriesByMember(member.getIDPerson());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] col = {"Nom"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			for (int i = 0; i < categories.size(); i++) 
			{
					String nom = categories.get(i).getName();
					Object[] data  = {nom};
					tableModel.addRow(data);
			}
		
		tableCategorie = new JTable(tableModel);
		tableCategorie.setBounds(10, 15, 597, 430);
		panelCategorie.add(tableCategorie);
		
		JButton btnNewButton_1_2 = new JButton("Supprimer cat\u00E9gorie");
		btnNewButton_1_2.setBounds(617, 55, 133, 23);
		panelCategorie.add(btnNewButton_1_2);
		
		
		
		
		JPanel panelVehicule = new JPanel();
		panelVehicule.setBounds(100, 25, 760, 456);
		frame.getContentPane().add(panelVehicule);
		panelVehicule.setLayout(null);
		
		
		JButton btnNewButton_1_1 = new JButton("Ajouter voiture");
		btnNewButton_1_1.setBounds(633, 11, 117, 23);
		panelVehicule.add(btnNewButton_1_1);
		
		
		
		JPanel panelVelo = new JPanel();
		panelVelo.setBounds(100, 25, 760, 456);
		frame.getContentPane().add(panelVelo);
		panelVelo.setLayout(null);
		
		panelVehicule.setVisible(false);
		panelCategorie.setVisible(true);
		panelVelo.setVisible(false);
		
		JButton btnNewButton_1_1_1 = new JButton("Ajouter velo");
		btnNewButton_1_1_1.setBounds(633, 11, 117, 23);
		panelVelo.add(btnNewButton_1_1_1);
		
		JButton btnNewButton = new JButton("Cat\u00E9gories");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVehicule.setVisible(false);
				panelCategorie.setVisible(true);
				panelVelo.setVisible(false);
			}
		});
		btnNewButton.setBounds(2, 43, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVhicules = new JButton("V\u00E9hicules");
		btnVhicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVehicule.setVisible(true);
				panelCategorie.setVisible(false);
				panelVelo.setVisible(false);
			}
		});
		btnVhicules.setBounds(2, 70, 89, 23);
		frame.getContentPane().add(btnVhicules);
		
		JButton btnVlo = new JButton("V\u00E9los");
		btnVlo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelVehicule.setVisible(false);
				panelCategorie.setVisible(false);
				panelVelo.setVisible(true);
			}
		});
		btnVlo.setBounds(2, 101, 89, 23);
		frame.getContentPane().add(btnVlo);
		
		
	}
}
