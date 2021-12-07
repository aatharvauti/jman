package vault;

import java.sql.*;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.Login;

public class Vault {

	private JFrame frame;
    Connection con = null;

	//	Launch the Application
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vault window = new Vault();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Initialize
	public Vault() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplayData = new JLabel("Vault");
		lblDisplayData.setBounds(196, 13, 89, 15);
		frame.getContentPane().add(lblDisplayData);
		
		JLabel lblVaultHeading = new JLabel();
		lblVaultHeading.setText("ID        APPLICATION        USERNAME        PASSWORD        URL");
		lblVaultHeading.setBounds(10, 45, 450, 15);
		lblVaultHeading.setVisible(true);
		frame.getContentPane().add(lblVaultHeading);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(328, 232, 117, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
		}
		});
		
		JButton Edit = new JButton("Edit");
		Edit.setBounds(100, 232, 117, 25);
		frame.getContentPane().add(Edit);
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel IdNumber = new JLabel("ID");
				IdNumber.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 15));
				IdNumber.setBounds(62, 292, 20, 15);
				frame.getContentPane().add(IdNumber);
				IdNumber.setVisible(true);
				
				JTextField EditTextbox = new JTextField();
				EditTextbox.setBounds(100, 290, 114, 19);
				frame.getContentPane().add(EditTextbox);
				EditTextbox.setVisible(true);
				EditTextbox.setColumns(10);
		}
		});
		
		JButton Delete = new JButton("Delete");
		Delete.setBounds(543, 232, 117, 25);
		frame.getContentPane().add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel IDforDelte = new JLabel("ID");
				IDforDelte.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 15));
				IDforDelte.setBounds(522, 292, 26, 15);
				frame.getContentPane().add(IDforDelte);
				IDforDelte.setVisible(true);
				
				JTextField Deletetextbox = new JTextField();
				Deletetextbox.setBounds(546, 290, 114, 19);
				frame.getContentPane().add(Deletetextbox);
				Deletetextbox.setVisible(true);
				Deletetextbox.setColumns(10);
		}
		});
		
		
		JLabel password = new JLabel("");
		password.setBounds(12, 112, 162, 15);
		frame.getContentPane().add(password);

		try
        {
			String usrname = Login.txtUsername.getText();
			
            Class.forName("com.mysql.jdbc.Driver");
      
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

            Statement stmt = con.createStatement();  

            ResultSet rs = stmt.executeQuery("SELECT * from "+usrname+"");  
            int i = 0;
            
            while(rs.next())
            {
            	JLabel lblVaultContent = new JLabel();
            	lblVaultContent.setBounds(10, 65 + i, 1000, 15);
            	String snew = rs.getInt(1) + "         " + rs.getString(2)+"         "+rs.getString(3)+"         "+rs.getString(4)+"         "+rs.getString(5);
            	lblVaultContent.setText(snew);
            	lblVaultContent.setVisible(true);
        		frame.getContentPane().add(lblVaultContent);
        		i += 20;
            }
            con.close(); 
        }

        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e);
        }
	}
}
