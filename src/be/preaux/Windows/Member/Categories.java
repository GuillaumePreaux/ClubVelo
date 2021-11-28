package be.preaux.Windows.Member;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.preaux.POJO.BikeHiker;
import be.preaux.POJO.Category;
import be.preaux.POJO.Cyclo;
import be.preaux.POJO.DownhillSkier;
import be.preaux.POJO.Member;
import be.preaux.POJO.TrialRider;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Categories {

	private JFrame frame;
	private Member member;
	private JTable table;
	private int selectedRow;


	/**
	 * Launch the application.
	 */
	
	
	public void open(Member m) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categories window = new Categories(m);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Categories(Member m ) {
		this.member = m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List<Category> categories = new ArrayList<>();
		Cyclo cyclo 				= new Cyclo();
		TrialRider trialRider 		= new TrialRider();
		DownhillSkier downhillSkier = new DownhillSkier();
		BikeHiker bikeHiker 		= new BikeHiker();
		cyclo = cyclo.findCyclo(1);
		trialRider = trialRider.findTrialRider(2);
		downhillSkier = downhillSkier.findDownhillSkier(3);
		bikeHiker = bikeHiker.findBikeHiker(4);
		categories.add(cyclo);
		categories.add(downhillSkier);
		categories.add(trialRider);
		categories.add(bikeHiker);
		
		String[] col = {"Nom"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			for (int i = 0; i < categories.size(); i++) 
			{
				String nom = categories.get(i).getName();
				Object[] data  = {nom};
				tableModel.addRow(data);
			}
		
			table = new JTable(tableModel);
			
			table.setBounds(10, 36, 285, 214);
			table.setEditingRow(0);
			frame.getContentPane().add(table);

		
		JButton btnSelectionnerCategorie = new JButton("Selectionner cat\u00E9gorie");
		btnSelectionnerCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = categories.get(selectedRow).getIDCategory();
				try {
					member.addMember();
					member.addCategoryMember(member,i);
					JOptionPane.showMessageDialog(null,"Le compte " + member.getNickname() + " a bien été créé"); 
					HomeMember homemember = new HomeMember(member);
					homemember.open(member);
					frame.dispose();
					return;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectionnerCategorie.setBounds(305, 36, 164, 34);
		frame.getContentPane().add(btnSelectionnerCategorie);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				if (selectedRow > -1) {
					btnSelectionnerCategorie.setEnabled(true);
				}
			}
		});
	}

}
