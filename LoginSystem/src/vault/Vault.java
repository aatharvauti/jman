package vault;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		frame.setBounds(200, 200, 525, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplayData = new JLabel("Vault");
		lblDisplayData.setBounds(196, 13, 89, 15);
		frame.getContentPane().add(lblDisplayData);
		
		JLabel lblVaultHeading = new JLabel();
		lblVaultHeading.setText("ID          APPLICATION          USERNAME          PASSWORD          URL");
		lblVaultHeading.setBounds(10, 45, 450, 15);
		lblVaultHeading.setVisible(true);
		frame.getContentPane().add(lblVaultHeading);

				
		
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
            	String snew = rs.getInt(1) + "\t\t" + rs.getString(2)+"\\t\\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5);
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
