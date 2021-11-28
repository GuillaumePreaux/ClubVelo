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
import be.preaux.Windows.Member.Categories;
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
import javax.swing.SwingConstants;

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
		frame.setBounds(100, 100, 584, 276);
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
		txtPassword.setBounds(102, 120, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		txtTelephone = new JTextField();
		txtTelephone.setBounds(102, 155, 86, 20);
		frame.getContentPane().add(txtTelephone);
		txtTelephone.setColumns(10);
		
		JButton Submit = new JButton("Inscription");
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
					JOptionPane.showMessageDialog(null, "Dans le prochain écran veuillez choisir une catégorie ");
					Categories categories = new Categories(newMember);
					categories.open(newMember);
					frame.dispose();
					return;
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(null,error.getMessage());

				}
			}
		});
		Submit.setBounds(52, 203, 102, 23);
		frame.getContentPane().add(Submit);
		
		txtConnectPassword = new JPasswordField();
		txtConnectPassword.setBounds(422, 114, 86, 20);
		frame.getContentPane().add(txtConnectPassword);
		
		JLabel lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 27, 82, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Pr\u00E9nom :");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(10, 60, 82, 14);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblNickname = new JLabel("Pseudonyme :");
		lblNickname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNickname.setBounds(10, 92, 82, 14);
		frame.getContentPane().add(lblNickname);
		
		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(10, 123, 82, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphone.setBounds(10, 158, 82, 14);
		frame.getContentPane().add(lblTlphone);
		
		JLabel lblNewLabel_1 = new JLabel("Inscription");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(79, 2, 74, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Connexion");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(382, 60, 74, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		
		txtConnectNickname = new JTextField();
		txtConnectNickname.setBounds(422, 81, 86, 20);
		frame.getContentPane().add(txtConnectNickname);
		txtConnectNickname.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Mot de passe :");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setBounds(310, 117, 102, 14);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblNickname_1 = new JLabel("Pseudonyme :");
		lblNickname_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNickname_1.setBounds(326, 84, 86, 14);
		frame.getContentPane().add(lblNickname_1);
		
		JButton TestConnect = new JButton("Connexion");
		TestConnect.setBounds(382, 149, 95, 23);
		frame.getContentPane().add(TestConnect);
		TestConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtConnectNickname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Veuillez renseigner le pseudo");
				}
				else if (String.valueOf(txtConnectPassword.getPassword()).isEmpty()) {
					JOptionPane.showMessageDialog(null,"Veuillez renseigner le mot de passe");
				}
				else 
				{
					
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
							else 
							{
								JOptionPane.showMessageDialog(null,"Le mot de passe est incorrect");
								txtConnectPassword.setText("");
								return;
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
							else 
							{
								JOptionPane.showMessageDialog(null,"Le mot de passe est incorrect");
								txtConnectPassword.setText("");
								return;
							}
						}
					}
					
					JOptionPane.showMessageDialog(null,"Aucun compte existe pour ce pseudo, veuillez-vous inscrire");
					
					
				}
			}
		});
	}
}
