package login;

import app.App;
import register.Register;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	Connection con = null;

	private JFrame frame;
	public static JTextField txtUsername;
	private JPasswordField txtPassword;


// Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

 //Create the application.
	
	public Login() {
		initialize();
	}

//Initialize the contents of the frame.
	
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
				
				try
			    {

					String password = txtPassword.getText();
					String usrname = txtUsername.getText();

					Class.forName("com.mysql.jdbc.Driver");
			  
			        Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

			        Statement stmt = con.createStatement();
			        String sql = "SELECT * from `loginsystemtable` WHERE username='"+usrname+"' and password='"+password+"'";
			        ResultSet rs = stmt.executeQuery(sql);

			        while (rs.next())
			        {
			            if (usrname.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			            {
		                	txtPassword.setText(null);
//							txtUsername.setText(null);
							App info = new App();
							App.main(null);
							
							frame.setVisible(false);
		                }
			            else
                        {
                        	System.out.println("PASS");
        					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
        					txtPassword.setText(null);
        					txtUsername.setText(null);
                  	    }
			        }
			    
			        con.close();
			    }

			    catch (SQLException | ClassNotFoundException e)
			    {
			        System.out.println(e);
			        e.printStackTrace();
			    }
			}
		});

		btnNewButton.setBounds(45, 190, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register create = new Register();
				Register.main(null);
			}
		});

		btnNewButton_1.setBounds(225, 190, 175, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		//frame.pack();
	}
}
