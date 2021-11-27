package be.preaux.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.preaux.POJO.Bike;
import be.preaux.POJO.Calendar;
import be.preaux.POJO.Manager;
import be.preaux.POJO.Member;
import be.preaux.POJO.Ride;
import be.preaux.Windows.Manager.HomeManager;
import be.preaux.Windows.Member.HomeMember;

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
import javax.swing.JPanel;
import java.awt.Panel;

public class Home {

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
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				List<Manager> managers = new ArrayList<>();
				List<Member> members = new ArrayList<>();
				Member member = new Member();
				Manager manager = new Manager();
				members = member.getAllMember();
				managers = manager.getAllManager();
				for (Manager m : managers) {
					if (m.getNickname().toString().equalsIgnoreCase(txtNickname.getText())){
						{
							JOptionPane.showMessageDialog(null, "Erreur le pseudo : " + m.getNickname() + " existe déjà");
							return;
						}	
					}
				}
				for (Member m : members) {
					if (m.getNickname().toString().equalsIgnoreCase(txtNickname.getText())){
						{
							JOptionPane.showMessageDialog(null, "Erreur le pseudo : " + m.getNickname() + " existe déjà");
							return;
						}	
					}
				}
				Member newMember = new Member();
				newMember.setName(txtName.getText());
				newMember.setSurname(txtSurname.getText());
				newMember.setTelephone(txtTelephone.getText());
				newMember.setNickname(txtNickname.getText());
				newMember.setPassword(String.valueOf(txtPassword.getPassword()));
				newMember.setBalance(0.0);
				try {
					newMember.addMember();
					txtName.setText("");
					txtSurname.setText("");
					txtTelephone.setText("");
					txtNickname.setText("");
					txtPassword.setText("");
					JOptionPane.showMessageDialog(null,"Le compte " + newMember.getNickname() + " a bien été créé"); 
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(null,error.getMessage());

				}
			}
		});
		Submit.setBounds(102, 215, 89, 23);
		frame.getContentPane().add(Submit);
		
		txtConnectPassword = new JPasswordField();
		txtConnectPassword.setBounds(440, 120, 86, 20);
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
		
		JLabel lblNewLabel_1 = new JLabel("Inscription");
		lblNewLabel_1.setBounds(80, 0, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Connexion");
		lblNewLabel_1_1.setBounds(414, 45, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		
		txtConnectNickname = new JTextField();
		txtConnectNickname.setBounds(440, 89, 86, 20);
		frame.getContentPane().add(txtConnectNickname);
		txtConnectNickname.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(385, 123, 46, 14);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblNickname_1 = new JLabel("Nickname");
		lblNickname_1.setBounds(385, 92, 45, 14);
		frame.getContentPane().add(lblNickname_1);
		
		JButton TestConnect = new JButton("Test connect");
		TestConnect.setBounds(466, 210, 95, 23);
		frame.getContentPane().add(TestConnect);
		
		JButton btnNewButton = new JButton(" Inscription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager manager = new Manager();
				manager = manager.findManager(3);

			}
		});
		btnNewButton.setBounds(434, 244, 108, 71);
		frame.getContentPane().add(btnNewButton);
		TestConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Manager> managers = new ArrayList<>();
				List<Member> members = new ArrayList<>();
				Member member = new Member();
				Manager manager = new Manager();
				members = member.getAllMember();
				managers = manager.getAllManager();
				for (Manager m : managers) {
					if (m.getNickname().toString().equalsIgnoreCase(txtConnectNickname.getText())){
						if(m.getPassword().toString().equals(String.valueOf(txtConnectPassword.getPassword()))) 
						{
							JOptionPane.showMessageDialog(null, "Bienvenue manager " + m.getSurname());
							HomeManager homeManager;
							try {
								homeManager = new HomeManager(m);
								homeManager.open(m);
								frame.dispose();
								return;
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
						}	
					}
				}
				for (Member m : members) {
					if (m.getNickname().toString().equalsIgnoreCase(txtConnectNickname.getText())){
						if(m.getPassword().toString().equals(String.valueOf(txtConnectPassword.getPassword()))) 
						{
							JOptionPane.showMessageDialog(null, "Bienvenue membre " + m.getSurname());
							HomeMember homeMember = new HomeMember(m);
							homeMember.open(m);
							frame.dispose();
							return;
						}	
					}
				}
				
				
			}
		});
	}
}
