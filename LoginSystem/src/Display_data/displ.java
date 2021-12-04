package Display_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Password_man.Pass_Manag;

public class displ {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displ window = new displ();
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
	public displ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplayData = new JLabel("Display data");
		lblDisplayData.setBounds(184, 12, 89, 15);
		frame.getContentPane().add(lblDisplayData);
		
		JLabel username = new JLabel("");
		username.setBounds(12, 85, 162, 15);
		frame.getContentPane().add(username);
		username.setText(Applica.getText());
		
		JLabel password = new JLabel("");
		password.setBounds(12, 112, 162, 15);
		frame.getContentPane().add(password);
		
		JLabel application = new JLabel("");
		application.setBounds(12, 44, 162, 15);
		frame.getContentPane().add(application);
		
		JLabel URL = new JLabel("");
		URL.setBounds(12, 139, 261, 15);
		frame.getContentPane().add(URL);
	}
}
