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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class addstudent {

	JFrame frame1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    static final String USERNAME = "root";
    static final String PASSWORD = "abc123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addstudent window = new addstudent();
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
	public addstudent() {
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
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(208, 65, 215, 44);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1.setBounds(15, 172, 174, 30);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(15, 219, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1);
		
	
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterID = textField_1.getText();
		        String enterName = textField.getText();
		        String enterEmail = textField_2.getText();
		        String enterCourse = textField_3.getText();
		        String enterPassword = new String(passwordField.getPassword());

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "INSERT INTO signup (userID, Name, Email, Course, Password) VALUES ('" + enterID + "','" +
		                    enterName + "','" + enterEmail + "','" + enterCourse + "','" + enterPassword + "')";

		            Statement sta = connection.createStatement();
		            int x = sta.executeUpdate(query);
		            if (x == 0) {
		                JOptionPane.showMessageDialog(btnNewButton, "Student not added");
		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Student added to the table.");
		            }
		            connection.close();
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        frame1.setVisible(false);
		    }
		});

		btnNewButton.setBounds(192, 445, 174, 44);
		frame1.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\add.png"));
		lblNewLabel_2.setBounds(148, 56, 64, 64);
		frame1.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(179, 164, 244, 30);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 214, 244, 30);
		frame1.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 268, 244, 30);
		frame1.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(179, 320, 244, 30);
		frame1.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(15, 267, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1_1.setBounds(15, 320, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1_1_1.setBounds(15, 375, 154, 30);
		frame1.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 371, 244, 30);
		frame1.getContentPane().add(passwordField);
		
	}

}
