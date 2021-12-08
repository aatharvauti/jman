package edit;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import app.App;
import login.Login;
import vault.Vault;

public class Edit {
	Connection con = null;
	
	public JFrame frame;
	private JTextField EditApplica;
	private JTextField EditUsername;
	private JTextField EditPassword;
	private JTextField EditUrllink;


	/**
	 * Launch the EditApplication.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the EditApplication.
	 */
	public Edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().setBackground(Color.green);
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPasswordManager = new JLabel("Edit Data Base");
		lblPasswordManager.setFont(new Font("Bitstream Charter", Font.BOLD, 13));
		lblPasswordManager.setBounds(135, 12, 214, 15);
		frame.getContentPane().add(lblPasswordManager);
		
		JLabel lblNewLabel = new JLabel("EditApplication");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 37, 94, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EditUsername");
		lblNewLabel_1.setBounds(23, 77, 94, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EditPassword");
		lblNewLabel_2.setBounds(23, 115, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EditURL");
		lblNewLabel_3.setBounds(23, 161, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		EditApplica = new JTextField();
		EditApplica.setBounds(135, 39, 114, 19);
		frame.getContentPane().add(EditApplica);
		EditApplica.setColumns(10);
		
		EditUsername = new JTextField();
		EditUsername.setBounds(135, 75, 114, 19);
		frame.getContentPane().add(EditUsername);
		EditUsername.setColumns(10);
		
		EditPassword = new JTextField();
		EditPassword.setBounds(135, 115, 114, 19);
		frame.getContentPane().add(EditPassword);
		EditPassword.setColumns(10);
		
		EditUrllink = new JTextField();
		EditUrllink.setBounds(135, 159, 114, 19);
		frame.getContentPane().add(EditUrllink);
		EditUrllink.setColumns(10);
		

		JButton Editt = new JButton("Edit");
		Editt.setBounds(145, 205, 125, 25);
		frame.getContentPane().add(Editt);
		Editt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
			    {

					int EditId = Integer.parseInt(Vault.EditTextbox.getText());
					String usrname = Login.txtUsername.getText();
					String EditAppl = EditApplica.getText();
					String EditUsern = EditUsername.getText();
					String Editpass = EditPassword.getText();
					String EditUrl = EditUrllink.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
			  
			        Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

			        Statement stmt = con.createStatement();
			        stmt.executeUpdate("UPDATE `"+usrname+"` SET `application name` = '"+EditAppl+"', `username` = '"+EditUsern+"', `password` = '"+Editpass+"', `url` = '"+EditUrl+"' WHERE `"+usrname+"`.`id` = "+EditId+""); 
			        
			        //UPDATE `vivek` SET `application name` = 'Instagram3', `username` = 'Vivek_m_20023', `password` = '1234567893', `url` = 'https://instagram.com3' WHERE `vivek`.`id` = 1 
			        con.close();
			        
			    }

			    catch (SQLException | ClassNotFoundException e)
			    {
			        System.out.println(e);
			        e.printStackTrace();
			    }
			}
			
		});
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(300, 205, 100, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
	}
}
