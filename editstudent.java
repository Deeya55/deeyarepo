package CMS1;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class editstudent {

	JFrame frame2;
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
					editstudent window = new editstudent();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editstudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(160, 188, 254));
		frame2.setBounds(100, 100, 606, 622);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(192, 65, 215, 44);
		frame2.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1.setBounds(28, 168, 174, 30);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(28, 226, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(28, 279, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1_1.setBounds(28, 334, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1_1_1.setBounds(28, 388, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(172, 168, 235, 30);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 227, 235, 30);
		frame2.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 285, 235, 30);
		frame2.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 340, 235, 30);
		frame2.getContentPane().add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 389, 235, 30);
		frame2.getContentPane().add(passwordField);
		
	
		
		JButton btnNewButton = new JButton("Edit Student");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterID = textField_1.getText();
		        String enterName = textField.getText();
		        String enterEmail = textField_2.getText();
		        String enterCourse = textField_3.getText();
		        String enterPassword = new String(passwordField.getPassword());

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "UPDATE signup SET Name = '" + enterName + "', Email = '" + enterEmail + "', Course = '" + enterCourse + "', Password = '" + enterPassword + "' WHERE userID = '" + enterID + "'";

		            try (Statement sta = connection.createStatement()) {
		                int rowCount = sta.executeUpdate(query);

		                if (rowCount > 0) {
		                    JOptionPane.showMessageDialog(btnNewButton, "Student updated successfully.");
		                } else {
		                    JOptionPane.showMessageDialog(btnNewButton, "No student found with the given ID.");
		                }
		            } catch (Exception exception) {
		                exception.printStackTrace();
		            } finally {
		                connection.close();
		            }
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        frame2.setVisible(false);
		    }
		});

		
		btnNewButton.setBounds(192, 448, 174, 44);
		frame2.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png"));
		lblNewLabel_2.setBounds(148, 56, 64, 64);
		frame2.getContentPane().add(lblNewLabel_2);
				
	}

}
