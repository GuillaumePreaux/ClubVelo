package be.preaux.Windows.Member;

import java.awt.EventQueue;

import javax.swing.JFrame;

import be.preaux.POJO.Member;
import javax.swing.JLabel;

public class HomeMember {

	private JFrame frame;
	private Member member;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member ");
		lblNewLabel.setBounds(10, 11, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Member ");
		lblName.setBounds(104, 11, 81, 14);
		frame.getContentPane().add(lblName);
		
		lblName.setText(member.getSurname());
	}

}
