package be.preaux.Windows.Member;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import be.preaux.POJO.BikeHiker;
import be.preaux.POJO.Category;
import be.preaux.POJO.Cyclo;
import be.preaux.POJO.DownhillSkier;
import be.preaux.POJO.Member;
import be.preaux.POJO.TrialRider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeMember {

	private JFrame frame;
	private Member member;
	private JTable table;

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
		frame.setBounds(100, 100, 494, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Membre");
		lblNewLabel.setBounds(10, 11, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Member ");
		lblName.setBounds(104, 11, 81, 14);
		frame.getContentPane().add(lblName);
		
		lblName.setText(member.getSurname());
		
		
		
		
	}
}
