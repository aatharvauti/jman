package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import login.Login;
import vault.Vault;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class App {

	public JFrame frame;
	private JTextField Applica;
	private JTextField Username1;
	private JTextField Password2;
	private JTextField urllink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JLabel DisplayField;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		JLabel DisplayField = new JLabel();
		JLabel usern = new JLabel();
		JLabel pass = new JLabel();
		JLabel url = new JLabel();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPasswordManager = new JLabel("Password Manager");
		lblPasswordManager.setFont(new Font("Bitstream Charter", Font.BOLD, 13));
		lblPasswordManager.setBounds(135, 12, 214, 15);
		frame.getContentPane().add(lblPasswordManager);
		
		JLabel lblNewLabel = new JLabel("Application");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 37, 94, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(23, 77, 94, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(23, 115, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("URL");
		lblNewLabel_3.setBounds(23, 161, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		Applica = new JTextField();
		Applica.setBounds(135, 39, 114, 19);
		frame.getContentPane().add(Applica);
		Applica.setColumns(10);
		
		Username1 = new JTextField();
		Username1.setBounds(135, 75, 114, 19);
		frame.getContentPane().add(Username1);
		Username1.setColumns(10);
		
		Password2 = new JTextField();
		Password2.setBounds(135, 115, 114, 19);
		frame.getContentPane().add(Password2);
		Password2.setColumns(10);
		
		urllink = new JTextField();
		urllink.setBounds(135, 159, 114, 19);
		frame.getContentPane().add(urllink);
		urllink.setColumns(10);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(300, 205, 100, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
		}
		});
		
		JButton btnAddMoreApplication = new JButton("Add");
		btnAddMoreApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try
			    {
					String usrname = Login.txtUsername.getText();
					System.out.println("My username is " + usrname);
					String Application = Applica.getText();
					String AppUser = Username1.getText();
					String AppPass = Password2.getText();
					String AppUrl = urllink.getText();

					Class.forName("com.mysql.jdbc.Driver");
			  
			        Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

			        Statement stmt = con.createStatement();
			        stmt.executeUpdate("INSERT INTO `"+usrname+"` (`id`, `application name`, `username`, `password`, `url`) VALUES (NULL, '"+Application+"', '"+AppUser+"', '"+AppPass+"', '"+AppUrl+"')");
			        
			        con.close();
			    }

			    catch (SQLException | ClassNotFoundException e)
			    {
			        System.out.println(e);
			    }


				Applica.setText(null);
				Username1.setText(null);
				Password2.setText(null);
				urllink.setText(null);
			}
		});
		
		btnAddMoreApplication.setBounds(15, 205, 100, 25);
		frame.getContentPane().add(btnAddMoreApplication);
		
		JButton Displaycon = new JButton("Open Vault");
		Displaycon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vault Display = new Vault();
				Vault.main(null);
				
				
				
			}
		});
		
		
		Displaycon.setBounds(145, 205, 125, 25);
		frame.getContentPane().add(Displaycon);
		
		
	}
}
