package register;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.sql.*;

public class Register {

	Connection con = null;

	private JFrame frame;
	private JTextField firstname;
	private JTextField secondname;
	private JTextField Dateofbirth;
	private JTextField Usern;
	private JTextField mail;
	private JPasswordField pass;
	private JPasswordField confpass;

// Launch the Application

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() {
		initialize();
	}

// Init

	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(200, 200, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblNewLabel.setBounds(277, 12, 117, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 110, 82, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 151, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(12, 186, 105, 15);
		frame.getContentPane().add(lblEmailAddress);
		
		JLabel lblFirstName = new JLabel("Name");
		lblFirstName.setBounds(12, 39, 82, 15);
		frame.getContentPane().add(lblFirstName);

		// JTextField
		
		firstname = new JTextField();
		firstname.setBounds(94, 39, 209, 19);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		Usern = new JTextField();
		Usern.setBounds(94, 110, 209, 19);
		frame.getContentPane().add(Usern);
		Usern.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(121, 186, 225, 19);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(100, 149, 203, 19);
		frame.getContentPane().add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setBounds(351, 151, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		confpass = new JPasswordField();
		confpass.setBounds(491, 149, 187, 19);
		frame.getContentPane().add(confpass);
		
//		JButton btnNewButton = new JButton("Back");
//		btnNewButton.setBounds(281, 230, 117, 25);
//		frame.getContentPane().add(btnNewButton);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Login_S Back = new Login_S();
//				Login_S.main(null);
//		}
//		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwor = pass.getText();
				String confpasswor = confpass.getText();
				if(passwor.contentEquals(confpasswor)) {
					
					try
				    {
				        Class.forName("com.mysql.jdbc.Driver");
				  
				        Connection con = DriverManager.getConnection(
				            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

				        Statement stmt = con.createStatement();  

				        String username = Usern.getText();
				        String password = pass.getText();

				        stmt.executeUpdate("INSERT INTO `loginsystemtable` (`id`, `username`, `password`) VALUES (NULL, '"+username+"', '"+password+"');");
				        stmt.executeUpdate("CREATE TABLE `loginsystem`.`"+username+"` ( `id` INT(200) NOT NULL AUTO_INCREMENT , `application name` VARCHAR(1000) NOT NULL , `username` VARCHAR(1000) NOT NULL , `password` VARCHAR(1000) NOT NULL , `url` VARCHAR(1000) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;");


//				        while(rs.next())  
//				        	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//				        
				        con.close();
				        Usern.setText(null);
						pass.setText(null);
						confpass.setText(null);
						firstname.setText(null);
						secondname.setText(null);
						Dateofbirth.setText(null);
						mail.setText(null);

				    }

				    catch (SQLException | ClassNotFoundException e)
				    {
				        System.out.println(e);
				    }

					
					
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
	}
}
