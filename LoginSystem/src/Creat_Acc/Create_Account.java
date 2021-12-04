package Creat_Acc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create_Account {

	private JFrame frame;
	private JTextField firstname;
	private JTextField secondname;
	private JTextField Dateofbirth;
	private JTextField Usern;
	private JTextField mail;
	private JPasswordField pass;
	private JPasswordField confpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Account window = new Create_Account();
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
	public Create_Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(200, 200, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblNewLabel.setBounds(277, 12, 117, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsrname = new JLabel("Username");
		lblUsrname.setBounds(12, 110, 82, 15);
		frame.getContentPane().add(lblUsrname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 151, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(12, 186, 105, 15);
		frame.getContentPane().add(lblEmailAddress);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 39, 82, 15);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second Name");
		lblSecondName.setBounds(351, 39, 110, 15);
		frame.getContentPane().add(lblSecondName);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(12, 75, 70, 15);
		frame.getContentPane().add(lblDob);
		
		firstname = new JTextField();
		firstname.setBounds(94, 39, 209, 19);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		secondname = new JTextField();
		secondname.setBounds(491, 37, 187, 19);
		frame.getContentPane().add(secondname);
		secondname.setColumns(10);
		
		Dateofbirth = new JTextField();
		Dateofbirth.setBounds(94, 75, 209, 19);
		frame.getContentPane().add(Dateofbirth);
		Dateofbirth.setColumns(10);
		
		Usern = new JTextField();
		Usern.setBounds(94, 110, 209, 19);
		frame.getContentPane().add(Usern);
		Usern.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(121, 186, 225, 19);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwor = pass.getText();
				String confpasswor = confpass.getText();
				if(passwor.contentEquals(confpasswor)) {
					pass.setText(null);
					confpass.setText(null);
					firstname.setText(null);
					secondname.setText(null);
					Dateofbirth.setText(null);
					mail.setText(null);
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Please re-enter the password","Password Error",JOptionPane.ERROR_MESSAGE);
					pass.setText(null);
					confpass.setText(null);
			}
		}
		});
		btnSubmit.setBounds(277, 230, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		pass = new JPasswordField();
		pass.setBounds(100, 149, 203, 19);
		frame.getContentPane().add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setBounds(351, 151, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		confpass = new JPasswordField();
		confpass.setBounds(491, 149, 187, 19);
		frame.getContentPane().add(confpass);
	}
}