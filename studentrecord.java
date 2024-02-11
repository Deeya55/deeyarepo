package CMS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class studentrecord {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					studentrecord window = new studentrecord();
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
	public studentrecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(182, 210, 254));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Record");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel.setBounds(85, 46, 286, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\book.png"));
		lblNewLabel_1.setBounds(36, 25, 64, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(36, 190, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Course");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(36, 231, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Semester");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_3.setBounds(36, 272, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Marks");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_4.setBounds(135, 311, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Module");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_5.setBounds(36, 367, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Score");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_6.setBounds(36, 419, 174, 30);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JButton btnNewButton = new JButton("Upload Record");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterName = textField.getText();
		        String enterCourse = textField_1.getText();
		        String enterSemester = textField_2.getText();
		        String enterModule = textField_3.getText();
		        int enterScore = Integer.parseInt(textField_4.getText());

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "INSERT INTO records (Name, Course, Semester, Module, Score) VALUES ('" +
		                    enterName + "','" + enterCourse + "','" + enterSemester + "','" + enterModule + "'," + enterScore + ")";

		            Statement sta = connection.createStatement();
		            int x = sta.executeUpdate(query);
		            if (x == 0) {
		                JOptionPane.showMessageDialog(btnNewButton, "Record not added");
		            } else {
		                JOptionPane.showMessageDialog(btnNewButton, "Record added to the table.");
		            }
		            connection.close();
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
		        frame.setVisible(false);
		    }
		});
		btnNewButton.setBounds(144, 479, 133, 43);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(164, 190, 184, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 231, 184, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 272, 184, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 367, 184, 30);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 408, 184, 30);
		frame.getContentPane().add(textField_4);
		frame.setBounds(100, 100, 469, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
