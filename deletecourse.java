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

public class deletecourse {

    JFrame frame3;
    private JTextField textField_1;
    static final String DB_URL = "jdbc:mysql://localhost:3306/cms";
    static final String USERNAME = "root";
    static final String PASSWORD = "abc123";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    deletecourse window = new deletecourse();
                    window.frame3.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public deletecourse() {
        initialize();
    }

    private void initialize() {
        frame3 = new JFrame();
        frame3.getContentPane().setBackground(new Color(160, 188, 254));
        frame3.setBounds(100, 100, 606, 622);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Delete Course");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(197, 66, 215, 44);
        frame3.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("Course ID");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
        lblNewLabel_1_1.setBounds(28, 227, 154, 30);
        frame3.getContentPane().add(lblNewLabel_1_1);

        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(192, 221, 273, 36);
        frame3.getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("Delete Course");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve the course ID
                String courseID = textField_1.getText();

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String query = "DELETE FROM course WHERE CourseID = '" + courseID + "'";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);

                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "False CourseID.");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Course deleted from the table.");
                    }

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                frame3.setVisible(false);
            }
        });

        btnNewButton.setBounds(192, 426, 174, 44);
        frame3.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\delete.png"));
        lblNewLabel_2.setBounds(138, 46, 64, 64);
        frame3.getContentPane().add(lblNewLabel_2);
    }
}

