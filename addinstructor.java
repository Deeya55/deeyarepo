package CMS1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class addinstructor {

	JFrame frame1;
	private JTextField emailField;
	private JPasswordField passwordField;
	static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    static final String USERNAME = "root";
    static final String PASSWORD = "abc123";
    private JTextField nameField;
    private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addinstructor window = new addinstructor();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addinstructor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(160, 188, 254));
		frame1.setBounds(100, 100, 606, 622);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Instructor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(208, 65, 215, 44);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1.setBounds(28, 215, 174, 30);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(28, 272, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\add.png"));
		lblNewLabel_2.setBounds(148, 56, 64, 64);
		frame1.getContentPane().add(lblNewLabel_2);
		
		emailField = new JTextField();
		emailField.setBounds(180, 209, 257, 37);
		frame1.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(28, 335, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 329, 257, 36);
		frame1.getContentPane().add(passwordField);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(180, 270, 257, 37);
		frame1.getContentPane().add(nameField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(180, 156, 257, 37);
		frame1.getContentPane().add(idField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Instructor ID");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(28, 163, 174, 30);
		frame1.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Add Instructor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterID = idField.getText();
				String enterName = emailField.getText();
		        String enterEmail = nameField.getText();
		        String enterPassword = new String(passwordField.getPassword()); // Use getPassword() for JPasswordField

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "INSERT INTO teachers (userID, Name, Email, Password) VALUES ('" + enterID + "','" +
	                           enterName + "','" + enterEmail + "','" + enterPassword + "')";

		            Statement sta = connection.createStatement();
		            int x = sta.executeUpdate(query);
		            if (x == 0) {
		                JOptionPane.showMessageDialog(btnNewButton, "Instructor added");
		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Instructor Added to the table.");
		            }
		            connection.close();
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        frame1.setVisible(false);
			}
		});
		btnNewButton.setBounds(192, 426, 174, 44);
		frame1.getContentPane().add(btnNewButton);
	}
}
