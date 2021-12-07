package edit;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Edit {
	public JFrame frame;
	private JTextField Applica;
	private JTextField Username1;
	private JTextField Password2;
	private JTextField urllink;


	/**
	 * Launch the application.
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
	 * Create the application.
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
	}

}
