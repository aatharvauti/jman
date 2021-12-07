package vault;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import login.Login;

public class Display {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	   public Display(){
	      prepareGUI();
	   }
	   public static void main(String[] args){
	      Display DisplayDemo = new Display();      
	      DisplayDemo.showTableDemo();
	   }
	   private void prepareGUI(){
	      mainFrame = new JFrame("Java Swing Examples");
	      mainFrame.setSize(1080,720);
	      mainFrame.setLayout(new GridLayout(3, 5));

	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    
	      statusLabel.setSize(600,600);

	      controlPanel = new JPanel();
	      //controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   private void showTableDemo(){
	      headerLabel.setText("Control in action: JTable"); 
	      
	      try
	        {
				//String usrname = Login.txtUsername.getText();
				String usrname = "vivek";
	            Class.forName("com.mysql.jdbc.Driver");
	      
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/loginsystem", "root", "D4v13504wm");

	            Statement stmt = con.createStatement();  

	            ResultSet rs = stmt.executeQuery("SELECT * from "+usrname+"");  
	          
	            String[] columnNames = {"ID", "APPLICATION","USERNAME","PASSWORD","URL"};
	            
	            int[] ID = new int[100];
	            String[] Username = new String[100];
	            String[] Password = new String[100];
	            String[] Application = new String[100];
	            String[] Url = new String[100];
	            int i=0;
	            while(rs.next()) {
	            	ID[i] = rs.getInt(1);
	            	Application[i]=rs.getString(2);
	            	Username[i] =rs.getString(3);
	            	Password[i] = rs.getString(4);
	            	Url[i] =rs.getString(5);
            	 Object[][] data = {
            			 {ID[i],Application[i],Username[i],Password[i],Url[i]},
            	 };
	              JTable table = new JTable(data, columnNames);
	       	      JScrollPane scrollPane = new JScrollPane(table);
	       	      scrollPane.setSize(600, 600);
	       	      //table.setMinimumSize(null);
	       	      table.setPreferredScrollableViewportSize(new Dimension(1000,600));
	       	      table.setFillsViewportHeight(true);
	       	      controlPanel.add(scrollPane);      
	       	      mainFrame.setVisible(true);
	            	//lblVaultContent.setText(snew);
	            	//lblVaultContent.setVisible(true);
	        		//frame.getContentPane().add(lblVaultContent);
	        		//i += 20;
	            i=i+1;
	            }
	            con.close(); 
	      
	            }
	      
	      catch (SQLException | ClassNotFoundException e)
	        {
	            System.out.println(e);
	        }
	        
	}
}




