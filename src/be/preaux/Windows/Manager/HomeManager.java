package be.preaux.Windows.Manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import be.preaux.POJO.Manager;
import be.preaux.POJO.Member;
import be.preaux.Windows.Member.HomeMember;

public class HomeManager {

	private JFrame frame;
	private Manager manager;

	
	/**
	 * Create the application.
	 */
	public HomeManager(Manager m ) {
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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel.setText(manager.getSurname());
	}
}
