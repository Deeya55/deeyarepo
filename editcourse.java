package CMS1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class editcourse {

    JFrame frame2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    static final String USERNAME = "root";
    static final String PASSWORD = "abc123";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    editcourse window = new editcourse();
                    window.frame2.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public editcourse() {
        initialize();
    }

    private void initialize() {
        frame2 = new JFrame();
        frame2.getContentPane().setBackground(new Color(160, 188, 254));
        frame2.setBounds(100, 100, 606, 622);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit Course");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setBounds(175, 55, 215, 44);
        frame2.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Course Name");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        lblNewLabel_1.setBounds(28, 168, 174, 30);
        frame2.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Course ID");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        lblNewLabel_1_1.setBounds(28, 227, 154, 30);
        frame2.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Seats");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        lblNewLabel_1_1_1.setBounds(28, 284, 154, 30);
        frame2.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Semester");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        lblNewLabel_1_1_2.setBounds(28, 339, 154, 30);
        frame2.getContentPane().add(lblNewLabel_1_1_2);

        textField = new JTextField();
        textField.setBounds(192, 166, 273, 36);
        frame2.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(192, 221, 273, 36);
        frame2.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(192, 278, 273, 36);
        frame2.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(192, 333, 273, 36);
        frame2.getContentPane().add(textField_3);

        JButton btnNewButton = new JButton("Edit Course");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields
                String courseID = textField_1.getText();
                String seats = textField_2.getText();
                String semester = textField_3.getText();

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String query = "UPDATE course SET Seats = '" + seats + "', Semester = '" + semester +
                            "' WHERE CourseID = '" + courseID + "'";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);

                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "Course not updated");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Course updated in the table.");
                    }

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                frame2.setVisible(false);
            }
        });

        btnNewButton.setBounds(192, 426, 174, 44);
        frame2.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png"));
        lblNewLabel_2.setBounds(138, 46, 64, 64);
        frame2.getContentPane().add(lblNewLabel_2);
    }
}

