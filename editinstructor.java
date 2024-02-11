package CMS1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class editinstructor {

	JFrame frame2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField idField;
	private JTextField nameField;
	private JTextField emailField;
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
					editinstructor window = new editinstructor();
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
	public editinstructor() {
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
		
		JLabel lblNewLabel = new JLabel("Edit Instructor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(208, 65, 215, 44);
		frame2.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1.setBounds(28, 215, 174, 30);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(28, 272, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png"));
		lblNewLabel_2.setBounds(148, 56, 64, 64);
		frame2.getContentPane().add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Instructor ID");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(28, 163, 174, 30);
		frame2.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Edit Instructor");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterID = idField.getText();
		        String enterName = nameField.getText();
		        String enterEmail = emailField.getText();
		        String enterPassword = new String(passwordField.getPassword());

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "UPDATE teachers SET Name = '" + enterName + "', Email = '" + enterEmail + "', Password = '" + enterPassword + "' WHERE userID = '" + enterID + "'";

		            try (Statement sta = connection.createStatement()) {
		                int rowCount = sta.executeUpdate(query);

		                if (rowCount > 0) {
		                    JOptionPane.showMessageDialog(btnNewButton, "Instructor edited successfully.");
		                } else {
		                    JOptionPane.showMessageDialog(btnNewButton, "No instructor found with the given ID.");
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

		btnNewButton.setBounds(192, 426, 174, 44);
		frame2.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(28, 324, 154, 30);
		frame2.getContentPane().add(lblNewLabel_1_1_1);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(179, 161, 257, 37);
		frame2.getContentPane().add(idField);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(179, 208, 257, 37);
		frame2.getContentPane().add(nameField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(179, 256, 257, 37);
		frame2.getContentPane().add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 318, 257, 36);
		frame2.getContentPane().add(passwordField);
	}

}
