package CMS1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login {

    JFrame LoginPanel;
    private JTextField textField;
    private JPasswordField pwField;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";
    private static final String SQL_QUERY = 
    	    "SELECT * FROM signup WHERE Name = ? AND Password = ? " +
    	    "UNION " +
    	    "(SELECT * FROM admin WHERE Name = ? AND Password = ?) " +
    	    "UNION " +
    	    "(SELECT * FROM teachers WHERE Name = ? AND Password = ?)";



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.LoginPanel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        LoginPanel = new JFrame();
        LoginPanel.getContentPane().setBackground(new Color(160, 188, 254));
        LoginPanel.setBounds(400, 400, 663, 422);
        LoginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel.getContentPane().setLayout(null);
        LoginPanel.setLocationRelativeTo(null);
        

        JLabel lblNewLabel = new JLabel("Log in");
        lblNewLabel.setBounds(0, 42, 649, 50);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(252, 196, 253));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
        LoginPanel.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setBounds(132, 173, 129, 36);
        lblNewLabel_1.setForeground(new Color(60, 149, 102));
        lblNewLabel_1.setFont(new Font("Source Code Pro", Font.BOLD, 15));
        LoginPanel.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(132, 203, 347, 41);
        LoginPanel.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setBounds(132, 244, 166, 28);
        lblNewLabel_2.setForeground(new Color(60, 149, 102));
        lblNewLabel_2.setFont(new Font("Source Code Pro", Font.BOLD, 15));
        LoginPanel.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(67, 118, 254));
        btnNewButton.setForeground(new Color(255, 232, 232));
        btnNewButton.setBounds(259, 333, 135, 41);
        btnNewButton.setFont(new Font("Serif", Font.BOLD, 15));
        LoginPanel.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String un = textField.getText();
                char[] passwordChars = pwField.getPassword();
                String p = new String(passwordChars);

                // Use SwingUtilities.invokeLater to perform database operations in a separate thread
                SwingUtilities.invokeLater(() -> {
                    try {
                        // Establish database connection
                        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
                            // Modify the SQL_QUERY to include the new tables
                        	String SQL_QUERY =
                        		    "SELECT Name, Password FROM signup WHERE Name = ? AND Password = ? " +
                        		    "UNION " +
                        		    "(SELECT Username, Password FROM admin WHERE Username = ? AND Password = ?) " +
                        		    "UNION " +
                        		    "(SELECT Name, Password FROM teachers WHERE Name = ? AND Password = ?)";


                            // Prepare and execute SQL query
                            try (PreparedStatement pst = conn.prepareStatement(SQL_QUERY)) {
                                // Set parameters for the new SQL_QUERY
                                pst.setString(1, un);
                                pst.setString(2, p);
                                pst.setString(3, un);
                                pst.setString(4, p);
                                pst.setString(5, un);
                                pst.setString(6, p);

                                try (ResultSet rs = pst.executeQuery()) {
                                    if (rs.next()) {
                                        // Authentication successful
                                        SwingUtilities.invokeLater(() -> {
                                            new dashboard().systempanel.setVisible(true);
                                            LoginPanel.setVisible(false);
                                        });
                                    } else {
                                        // Authentication failed
                                        JOptionPane.showMessageDialog(LoginPanel, "Name or Password is incorrect!");
                                    }
                                }
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error while establishing connection or executing query");
                    }
                });
            }
        });




        pwField = new JPasswordField();
        pwField.setBounds(132, 268, 347, 41);
        LoginPanel.getContentPane().add(pwField);
        pwField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\user-login.png"));
        lblNewLabel_3.setBounds(209, 24, 64, 64);
        LoginPanel.getContentPane().add(lblNewLabel_3);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Teacher", "Student"}));
        comboBox.setBounds(132, 140, 347, 36);
        LoginPanel.getContentPane().add(comboBox);

        JLabel lblNewLabel_1_1 = new JLabel("Select user made");
        lblNewLabel_1_1.setForeground(new Color(60, 149, 102));
        lblNewLabel_1_1.setFont(new Font("Source Code Pro", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(132, 109, 199, 36);
        LoginPanel.getContentPane().add(lblNewLabel_1_1);
    }
}
