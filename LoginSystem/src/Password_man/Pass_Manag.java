package Password_man;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Display_data.displ;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class Pass_Manag {

	private JFrame frame;
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
					Pass_Manag window = new Pass_Manag();
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
	public Pass_Manag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JLabel DisplayField = new JLabel();
		JLabel usern = new JLabel();
		JLabel pass = new JLabel();
		JLabel url = new JLabel();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(200, 300, 900, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPasswordManager = new JLabel("Password Manager");
		lblPasswordManager.setFont(new Font("Bitstream Charter", Font.BOLD, 17));
		lblPasswordManager.setBounds(154, 12, 214, 15);
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
		
		JButton btnAddMoreApplication = new JButton("Add More Application");
		btnAddMoreApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Applica.setText(null);
				Username1.setText(null);
				Password2.setText(null);
				urllink.setText(null);
			}
		});
		
		btnAddMoreApplication.setBounds(23, 205, 226, 25);
		frame.getContentPane().add(btnAddMoreApplication);
		
		JButton Displaycon = new JButton("Display Content");
		Displaycon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displ Display = new displ();
				displ.main(null);
				
				
				
			}
		});
		
		
		Displaycon.setBounds(293, 205, 155, 25);
		frame.getContentPane().add(Displaycon);
		
		
	}
}
