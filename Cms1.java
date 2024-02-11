package CMS1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Cms1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
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
					Cms1 window = new Cms1();
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
	public Cms1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(160, 188, 254));
		frame.setBounds(100, 100, 555, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Signup Panel");
		lblNewLabel.setBounds(10, 22, 521, 62);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setBounds(82, 205, 359, 33);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(51, 128, 118));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Email Address");
		lblNewLabel_1_1.setBounds(82, 268, 359, 33);
		lblNewLabel_1_1.setForeground(new Color(51, 128, 118));
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Password");
		lblNewLabel_1_2.setBounds(82, 326, 359, 33);
		lblNewLabel_1_2.setForeground(new Color(51, 128, 118));
		lblNewLabel_1_2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(82, 225, 359, 32);
		textField.setForeground(new Color(60, 149, 102));
		textField.setBackground(new Color(244, 237, 230));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 289, 359, 32);
		textField_1.setForeground(new Color(60, 149, 102));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(244, 237, 230));
		frame.getContentPane().add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(82, 348, 359, 33);
		passwordField.setBackground(new Color(244, 237, 230));
		passwordField.setForeground(new Color(60, 149, 102));
		frame.getContentPane().add(passwordField);
		

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setVisible(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BIT", "BBIM"}));
		comboBox_1.setBounds(242, 460, 139, 23);
		frame.getContentPane().add(comboBox_1);
		
		JLabel selectcourse = new JLabel("Select Course");
		selectcourse.setVisible(false);
		selectcourse.setHorizontalAlignment(SwingConstants.CENTER);
		selectcourse.setForeground(new Color(51, 128, 118));
		selectcourse.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		selectcourse.setBounds(127, 460, 120, 33);
		frame.getContentPane().add(selectcourse);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 417, 366, 32);
		comboBox.setForeground(new Color(67, 118, 254));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"Admin", "Student", "Teacher"}));
		comboBox.setBackground(new Color(244, 237, 230));
		comboBox.setToolTipText("");
		frame.getContentPane().add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			private void comboBox_SelectedIndexChanged() {
			    String selectedValue = comboBox.getSelectedItem().toString();
			    if (selectedValue.equals("Student")) {
			        comboBox_1.setVisible(true);
			        selectcourse.setVisible(true);
			    } else {
			        comboBox_1.setVisible(false);
			        selectcourse.setVisible(false);
			    }
			}
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        comboBox_SelectedIndexChanged();
		    }
		}); // Added closing parenthesis here

		

		
		JLabel lblNewLabel_1_2_1 = new JLabel("Select User Type");
		lblNewLabel_1_2_1.setBounds(82, 395, 359, 33);
		lblNewLabel_1_2_1.setForeground(new Color(51, 128, 118));
		lblNewLabel_1_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setForeground(new Color(255, 230, 230));
		btnNewButton.setBackground(new Color(67, 118, 254));
		btnNewButton.setBounds(179, 508, 153, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterName = textField.getText();
		        String enterEmail = textField_1.getText();
		        String enterPassword = new String(passwordField.getPassword());
		        String userType = comboBox.getSelectedItem().toString();

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		            // Use switch statement to handle different user types
		            switch (userType) {
		                case "Student":
		                    String selectedCourse = "";
		                    if (comboBox_1.isVisible()) {
		                        // Only get selected item if comboBox_1 is visible
		                        selectedCourse = comboBox_1.getSelectedItem().toString();
		                    }
		                    insertIntoStudentTable(connection, enterName, enterEmail, enterPassword, selectedCourse);
		                    break;
		                case "Admin":
		                    insertIntoAdminTable(connection, enterName, enterEmail, enterPassword);
		                    break;
		                case "Teacher":
		                    insertIntoTeacherTable(connection, enterName, enterEmail, enterPassword);
		                    break;
		                default:
		                    // Handle unexpected user type
		                    break;
		            }

		            connection.close();
		            JOptionPane.showMessageDialog(btnNewButton, "Your account is successfully created.");

		            // Open the dashboard window
		            try {
		                dashboard window = new dashboard();
		                window.systempanel.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }

		        } catch (SQLException exception) {
		            exception.printStackTrace();
		            JOptionPane.showMessageDialog(btnNewButton, "Error creating the account");
		        }
		    }

		    private void insertIntoStudentTable(Connection connection, String name, String email, String password, String course) throws SQLException {
		        String query = "INSERT INTO signup (Name, Email, Password, Course) VALUES ('" + name + "','" + email + "','" + password + "','" + course + "')";
		        try (Statement sta = connection.createStatement()) {
		            sta.executeUpdate(query);
		        }
		    }

		    private void insertIntoAdminTable(Connection connection, String name, String email, String password) throws SQLException {
		        String query = "INSERT INTO admin (Username, Email, Password) VALUES ('" + name + "','" + email + "','" + password + "')";
		        try (Statement sta = connection.createStatement()) {
		            sta.executeUpdate(query);
		        }
		    }

		    private void insertIntoTeacherTable(Connection connection, String name, String email, String password) throws SQLException {
		        String query = "INSERT INTO teachers (Name, Email, Password) VALUES ('" + name + "','" + email + "','" + password + "')";
		        try (Statement sta = connection.createStatement()) {
		            sta.executeUpdate(query);
		        }
		    }
		});


		
		JLabel lblNewLabel_2 = new JLabel("Already have an Account?");
		lblNewLabel_2.setBounds(111, 546, 160, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login window = new Login();
					window.LoginPanel.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(67, 118, 254));
		btnNewButton_1.setForeground(new Color(255, 244, 244));
		btnNewButton_1.setBounds(268, 542, 128, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\process.png"));
		lblNewLabel_3.setBounds(190, 68, 128, 128);
		frame.getContentPane().add(lblNewLabel_3);		
		
	}
}
