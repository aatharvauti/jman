package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Creat_Acc.Create_Account;
import Password_man.Pass_Manag;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login_S {

	Connection con = null;

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
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
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setBounds(184, 12, 130, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(45, 77, 82, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(45, 128, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(145, 75, 114, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(145, 126, 114, 19);
		frame.getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String password = txtPassword.getText();
				String usrname = txtUsername.getText();

				try
			    {

					Class.forName("com.mysql.jdbc.Driver");
			  
			        Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

			        Statement stmt = con.createStatement();
			        String sql = "SELECT * from `loginsystemtable` WHERE username='"+usrname+"' and password='"+password+"'";
			        ResultSet rs = stmt.executeQuery(sql);

			        while (rs.next())
			        {
			            if (usrname.equals(rs.getString("username")))
			            {
			                if (password.equals(rs.getString("password")))
			                {
			                	txtPassword.setText(null);
								txtUsername.setText(null);
								Pass_Manag info = new Pass_Manag();
								Pass_Manag.main(null);
			                }
                            else
                            {
                            	JOptionPane.showMessageDialog(null,"Invalid Password","Login Error",JOptionPane.ERROR_MESSAGE);
                            	txtPassword.setText(null);
                            	txtUsername.setText(null);
                      	    }
			            }
			            else
			            {
			            	JOptionPane.showMessageDialog(null,"Invalid Username","Login Error",JOptionPane.ERROR_MESSAGE);
			                txtPassword.setText(null);
                        	txtUsername.setText(null);
			            }
		            }
			    
			        
			        
			        
			        con.close();
			        
//			        txtPassword.setText(null);
//					txtUsername.setText(null);
//					
//					Pass_Manag info = new Pass_Manag();
//					Pass_Manag.main(null);
			    }

			    catch (SQLException | ClassNotFoundException e)
			    {
			        System.out.println(e);
			    }
			}
		});
		btnNewButton.setBounds(45, 190, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create_Account create = new Create_Account();
				Create_Account.main(null);
			}
		});
		btnNewButton_1.setBounds(225, 190, 175, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
