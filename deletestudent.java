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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deletestudent {

	JFrame frame;
	private JTextField textField_1;
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
					deletestudent window = new deletestudent();
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
	public deletestudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(160, 188, 254));
		frame.setBounds(100, 100, 606, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(186, 76, 271, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(28, 227, 154, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
	
		
		JButton btnNewButton = new JButton("Delete Student");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String enterID = textField_1.getText();

		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		            String query = "DELETE FROM teachers WHERE userID = '" + enterID + "'";

		            try (Statement sta = connection.createStatement()) {
		                int rowCount = sta.executeUpdate(query);

		                if (rowCount > 0) {
		                    JOptionPane.showMessageDialog(btnNewButton, "Student deleted successfully.");
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
		        frame.setVisible(false);
		    }
		});
		btnNewButton.setBounds(193, 329, 174, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\delete.png"));
		lblNewLabel_2.setBounds(128, 56, 64, 64);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 227, 234, 30);
		frame.getContentPane().add(textField_1);
	}

}
