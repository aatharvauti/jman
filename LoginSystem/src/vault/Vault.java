package vault;

import java.sql.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import edit.Edit;
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
		frame.setVisible(true);
		
		JLabel IdNumber = new JLabel("ID");
		IdNumber.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 15));
		IdNumber.setBounds(65, 383, 20, 25);
		frame.getContentPane().add(IdNumber);
		
		JTextField EditTextbox = new JTextField();
		EditTextbox.setBounds(103, 386, 41, 19);
		frame.getContentPane().add(EditTextbox);
		EditTextbox.setColumns(10);
		
		JLabel IDforDelte = new JLabel("ID");
		IDforDelte.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 15));
		IDforDelte.setBounds(543, 383, 20, 25);
		frame.getContentPane().add(IDforDelte);
		
		JTextField Deletetextbox = new JTextField();
		Deletetextbox.setBounds(591, 386, 41, 19);
		frame.getContentPane().add(Deletetextbox);
		Deletetextbox.setColumns(10);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(293, 420, 117, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
		}
		});
		
		JButton Edit = new JButton("Edit");
		Edit.setBounds(66, 420, 78, 25);
		frame.getContentPane().add(Edit);
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Edit Eddit = new Edit();
				Eddit.main(null);
		}
		});
		
		JButton Delete = new JButton("Delete");
		Delete.setBounds(543, 420, 89, 25);
		frame.getContentPane().add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
              	scrollPane.setSize(600, 600);	  
              	frame.getContentPane().add(scrollPane);
              	table.setPreferredScrollableViewportSize(new Dimension(1000,600));
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
