package vault;

import java.sql.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.Login;


public class Vault {

	private JFrame frame;
	public static JTextField EditTextbox;
    Connection con = null;

	//	Launch the Application
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vault window = new Vault();
					window.frame.setVisible(false);
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
		frame.setVisible(true);

		
		JLabel IDforDelte = new JLabel("ID");
		IDforDelte.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 15));
		IDforDelte.setBounds(543, 383, 20, 25);
		frame.getContentPane().add(IDforDelte);
		
		JTextField Deletetextbox = new JTextField();
		Deletetextbox.setBounds(591, 386, 41, 19);
		frame.getContentPane().add(Deletetextbox);
		Deletetextbox.setColumns(10);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(66, 420, 150, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
		}
		});
		
		
		JButton Delete = new JButton("Delete");
		Delete.setBounds(543, 420, 150, 25);
		frame.getContentPane().add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
			    {

					int DeleteId = Integer.parseInt(Deletetextbox.getText());
					
					
					String usrname = Login.txtUsername.getText();
					Class.forName("com.mysql.jdbc.Driver");
			  
			        Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

			        Statement stmt = con.createStatement();
			        stmt.executeUpdate("DELETE FROM `"+usrname+"` WHERE `"+usrname+"`.`id` = "+DeleteId+"");
			        //"DELETE FROM `vivek` WHERE `vivek`.`id` = 3"
			    
			        con.close();
			        frame.setVisible(false);
			        Vault V = new Vault();
					V.main(null);
			        
			        
			        
			        
			    }

			    catch (SQLException | ClassNotFoundException e)
			    {
			        System.out.println(e);
			        e.printStackTrace();
			    }
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
	            		
        		String columns[] = { "ID", "Application", "Username", "Password", "URL" };
        		String data[][] = new String[10][5];
	            	    
        		int i = 0;
        		while (rs.next()) 
        		{
        			int tableID = rs.getInt(1);
        	        String tableApp = rs.getString(2);
        	        String tableUsername = rs.getString(3);
        	        String tablePassword = rs.getString(4);
        	        String tableURL = rs.getString(5);
        	        
        	        data[i][0] = tableID + "";
        	        data[i][1] = tableApp;
        	        data[i][2] = tableUsername;
        	        data[i][3] = tablePassword;
        	        data[i][4] = tableURL;
        	        i++;
        		}
      
//    			DefaultTableModel model = new DefaultTableModel(data, columns);
//    			JTable table = new JTable(model);
//    			table.setShowGrid(true);
//				table.setShowVerticalLines(true);
//				table.setVisible(true);
//				JScrollPane pane = new JScrollPane(table);
//				pane.setVisible(true);
//				pane.setSize(600, 600);
//				frame.getContentPane().add(pane);
//				JPanel panel = new JPanel();
//				panel.add(pane);
//				panel.setVisible(true);
//				table.setPreferredScrollableViewportSize(new Dimension(1000,600));
//				table.setFillsViewportHeight(true);	
        		
              	JTable table = new JTable(data, columns);
              	JScrollPane scrollPane = new JScrollPane(table);
              	scrollPane.setSize(800, 500);	  
              	frame.getContentPane().add(scrollPane);
              	//table.setPreferredScrollableViewportSize(new Dimension(1200,500));
              	//table.setPreferredScrollableViewportSize(new Dimension(1200,600));
              	table.setFillsViewportHeight(true);
              	frame.setVisible(true);
	              	    
	            con.close(); 
	        
	            }
	      
	      catch (SQLException | ClassNotFoundException e)
	        {
	            System.out.println(e);
	            e.printStackTrace();
	        }
	        
	}
}
