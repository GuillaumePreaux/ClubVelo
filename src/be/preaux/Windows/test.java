package be.preaux.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.preaux.POJO.Bike;
import be.preaux.POJO.Manager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JCheckBox;

public class test {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtNickname;
	private JPasswordField txtPassword;
	private JTextField txtTelephone;
	private JTextField txtConnectNickname;
	private JPasswordField txtConnectPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton TestConnect = new JButton("Test connect");
		TestConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								List<Manager> managers = new ArrayList<>();
				Manager manager = new Manager();
				managers = manager.getAllManager();
				for (Manager m : managers) {
					if (m.getNickname().toString().equals(txtConnectNickname.getText())
							&& m.getPassword().toString().equals(String.valueOf(txtConnectPassword.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Bienvenue " + m.getSurname());
					}
				}	
			}
		});
		TestConnect.setBounds(301, 165, 123, 23);
		frame.getContentPane().add(TestConnect);
		
		txtName = new JTextField();
		txtName.setBounds(102, 24, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(102, 57, 86, 20);
		frame.getContentPane().add(txtSurname);
		
		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		txtNickname.setBounds(102, 89, 86, 20);
		frame.getContentPane().add(txtNickname);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(102, 135, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		txtTelephone = new JTextField();
		txtTelephone.setBounds(102, 166, 86, 20);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager manager = new Manager();
				manager.setName(txtName.getText());
				manager.setSurname(txtSurname.getText());
				manager.setTelephone(txtTelephone.getText());
				manager.setNickname(txtNickname.getText());
				manager.setPassword(String.valueOf(txtPassword.getPassword()));
				try {
					manager.addManager();
					txtName.setText("");
					txtSurname.setText("");
					txtTelephone.setText("");
					txtNickname.setText("");
					txtPassword.setText("");
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(null,error.getMessage());

				}
			}
		});
		Submit.setBounds(102, 215, 89, 23);
		frame.getContentPane().add(Submit);
		
		txtConnectNickname = new JTextField();
		txtConnectNickname.setColumns(10);
		txtConnectNickname.setBounds(324, 105, 86, 20);
		frame.getContentPane().add(txtConnectNickname);
		
		txtConnectPassword = new JPasswordField();
		txtConnectPassword.setBounds(324, 135, 86, 20);
		frame.getContentPane().add(txtConnectPassword);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(33, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(33, 60, 46, 14);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(33, 92, 46, 14);
		frame.getContentPane().add(lblNickname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 138, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone");
		lblTlphone.setBounds(33, 169, 59, 14);
		frame.getContentPane().add(lblTlphone);
		
		JLabel lblNickname_1 = new JLabel("Nickname");
		lblNickname_1.setBounds(268, 108, 46, 14);
		frame.getContentPane().add(lblNickname_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(268, 138, 46, 14);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblNewLabel_1 = new JLabel("Inscription");
		lblNewLabel_1.setBounds(80, 0, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Connexion");
		lblNewLabel_1_1.setBounds(295, 77, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
	}
}
