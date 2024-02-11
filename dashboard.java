package CMS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextPane;

public class dashboard extends JFrame {
	
	private static final long serialVersionUID = 1L; //serialVersionUID to remove warnings
	JFrame systempanel;
	private JLayeredPane layeredPane;
	private JComboBox<String> comboBox; // Add this line to declare the JComboBox

    public JComboBox<String> getComboBox() {
        return comboBox;
    }
    private String userType;
    private JTable table2;
    private JTable table;
    private JTable table1;
    

    public dashboard(String userType) {
        this.userType = userType;
        initialize();
    }
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
					dashboard window = new dashboard();
					window.systempanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model1 = new DefaultTableModel();
		DefaultTableModel model2 = new DefaultTableModel();

		systempanel = new JFrame();
		systempanel.getContentPane().setBackground(new Color(204, 217, 249));
		systempanel.setBounds(100, 100, 1144, 757);
		systempanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		systempanel.getContentPane().setLayout(null);
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(118, 165, 235));
		panel.setBounds(0, 0, 307, 700);
		systempanel.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(317, 21, 789, 668);
		systempanel.getContentPane().add(layeredPane);
		
		JPanel Course = new JPanel();
		Course.setBackground(new Color(160, 188, 254));
		Course.setBounds(0, 0, 789, 668);
		layeredPane.add(Course);
		Course.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Course");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(52, 72, 186, 50);
		lblNewLabel_8.setFont(new Font("Arial Black", Font.PLAIN, 25));
		Course.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		
				btnNewButton.setBounds(65, 454, 125, 36);
				Course.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Edit Course");
				btnNewButton_1.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        // Check if the user type is "admin" before allowing access
				        if ("admin".equals(userType)) {
				            try {
				                addcourse window = new addcourse();
				                window.frame1.setVisible(true);
				            } catch (Exception f) {
				                f.printStackTrace();
				            }
				        } else {
				            // Display a message indicating insufficient privileges
				            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
				        }
				    }
				});
				btnNewButton_1.setBounds(301, 454, 125, 36);
				Course.add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("Delete Course");
				btnNewButton_2.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        // Check if the user type is "admin" before allowing access
				        if ("admin".equals(userType)) {
				            try {
				                addcourse window = new addcourse();
				                window.frame1.setVisible(true);
				            } catch (Exception f) {
				                f.printStackTrace();
				            }
				        } else {
				            // Display a message indicating insufficient privileges
				            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
				        }
				    }
				});
				btnNewButton_2.setBounds(566, 454, 125, 36);
				Course.add(btnNewButton_2);
				
				JScrollPane cour = new JScrollPane();
				cour.setBounds(80, 149, 629, 167);
				Course.add(cour);
				
								table1 = new JTable(model1);
								cour.setViewportView(table1);
								// Set the model to the table1
								table1.setModel(model1);
								
								JLabel jtest = new JLabel("New label");
								jtest.setBounds(150, 43, 61, 18);
								Course.add(jtest);
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(160, 188, 254));
		Dashboard.setBounds(0, 0, 789, 668);
		layeredPane.add(Dashboard);
		Dashboard.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\online-learning (3).png"));
		lblNewLabel.setBounds(39, 109, 128, 119);
		Dashboard.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("2");
		
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(227, 143, 48, 52);
		Dashboard.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Courses");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(195, 196, 184, 32);
		Dashboard.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\teachers-day.png"));
		lblNewLabel_4.setBounds(67, 279, 150, 143);
		Dashboard.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("5");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 50));
		lblNewLabel_5.setBounds(227, 311, 48, 52);
		Dashboard.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Teachers");
		lblNewLabel_3_1.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(195, 385, 184, 32);
		Dashboard.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\audience.png"));
		lblNewLabel_6.setBounds(53, 490, 141, 150);
		Dashboard.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Students");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(195, 566, 167, 32);
		Dashboard.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("5");
		lblNewLabel_5_1.setFont(new Font("Arial Black", Font.PLAIN, 50));
		lblNewLabel_5_1.setBounds(227, 503, 48, 52);
		Dashboard.add(lblNewLabel_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(479, 0, 324, 668);
		Dashboard.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Select Module");
		btnNewButton_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "student" before allowing access
		        if ("student".equals(userType)) {
		            try {
		                // Initialize userLevel with a default value
		                int userLevel = -1;  // You can set any default value here

		                // Now fetch the user's level from the database
		                userLevel = getUserLevelFromDatabase(userType);

		                // Check if the user's level is 6
		                if (userLevel == 6) {
		                    module window = new module();
		                    window.frame1.setVisible(true);
		                } else {
		                    // Display a message indicating insufficient privileges
		                    JOptionPane.showMessageDialog(systempanel, "Only Level 6 students can access!");
		                }
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Error!");
		        }
		    }
		});
		
		
		btnNewButton_6.setBackground(new Color(216, 216, 216));
		btnNewButton_6.setBounds(93, 280, 122, 23);
		panel_1.add(btnNewButton_6);
		
		JTextPane txtpnIfYouBelong = new JTextPane();
		txtpnIfYouBelong.setBackground(new Color(192, 192, 192));
		txtpnIfYouBelong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnIfYouBelong.setText("Remainder!!\r\n\r\nIf you belong to Level 6, please click the button below to choose your choice of module.");
		txtpnIfYouBelong.setBounds(10, 140, 292, 174);
		panel_1.add(txtpnIfYouBelong);
		
		JLabel lblNewLabel_12 = new JLabel("Notice");
		lblNewLabel_12.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel_12.setBounds(107, 50, 92, 37);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\notice.png"));
		lblNewLabel_13.setBounds(46, 46, 64, 64);
		panel_1.add(lblNewLabel_13);
		
		JPanel Student = new JPanel();
		Student.setBackground(new Color(160, 188, 254));
		Student.setBounds(0, 0, 789, 668);
		layeredPane.add(Student);
		Student.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Students");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel_10.setBounds(75, 93, 210, 63);
		Student.add(lblNewLabel_10);
		
		JButton btnNewButton_4 = new JButton("Add Student");
		btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_4.setBounds(75, 476, 151, 45);
		Student.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Edit Student");
		btnNewButton_4_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_4_1.setBounds(325, 476, 151, 45);
		Student.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("Delete Student");
		btnNewButton_4_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_4_2.setBounds(564, 476, 172, 45);
		Student.add(btnNewButton_4_2);
		
		JScrollPane stu = new JScrollPane();
		stu.setBounds(71, 177, 616, 181);
		Student.add(stu);
		
		table = new JTable(model);
		stu.setViewportView(table);
		
		JPanel teach = new JPanel();
		teach.setBackground(new Color(160, 188, 254));
		teach.setBounds(0, 0, 789, 668);
		layeredPane.add(teach);
		teach.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Instructor");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel_9.setBounds(32, 63, 323, 76);
		teach.add(lblNewLabel_9);
		
		JButton btnNewButton_3 = new JButton("Add Instructor");
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_3.setBounds(42, 501, 134, 35);
		teach.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Edit Instructor");
		btnNewButton_3_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_3_1.setBounds(308, 501, 134, 35);
		teach.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Delete Instructor");
		btnNewButton_3_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "admin" before allowing access
		        if ("admin".equals(userType)) {
		            try {
		                addcourse window = new addcourse();
		                window.frame1.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only Admin can access!");
		        }
		    }
		});
		btnNewButton_3_2.setBounds(570, 501, 134, 35);
		teach.add(btnNewButton_3_2);
		
		JScrollPane scrollPane_2 = new JScrollPane((Component) null);
		scrollPane_2.setBounds(42, 150, 693, 300);
		teach.add(scrollPane_2);
		
		table2 = new JTable(model2);
		scrollPane_2.setViewportView(table2);
		

		JLabel lblNewLabel_1 = new JLabel("COURSE MANAGEMENT SYSTEM");
		lblNewLabel_1.setBounds(3, 58, 301, 25);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		JButton course = new JButton("Course");
		course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Course);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		course.setBounds(52, 284, 178, 49);
		panel.add(course);
		
		model2.addColumn("IntructorID");
        model2.addColumn("Name");
        model2.addColumn("Course");
        fetchDataForTeacher("teachers", model2);
				
		
		model1.addColumn("CourseID");
		model1.addColumn("CourseName");
        model1.addColumn("Semester");
        fetchDataForCourse("course", model1);
		
        model.addColumn("UserID");
        model.addColumn("Name");
        model.addColumn("Course");
        fetchDataForStudents("signup", model); 
		
		JButton dashboard = new JButton("Dashboard");
		dashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		dashboard.setBounds(52, 214, 178, 49);
		panel.add(dashboard);
		
		JButton instructor = new JButton("Instructor");
		instructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(teach);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		instructor.setBounds(52, 352, 178, 49);
		panel.add(instructor);
		
		JButton students = new JButton("Students");
		students.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Student);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		students.setBounds(52, 423, 178, 49);
		panel.add(students);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Login window = new Login();
						window.LoginPanel.setVisible(true);
					} catch (Exception f) {
						f.printStackTrace();
					}
				systempanel.setVisible(false);
				}
			
		});
		logout.setBounds(52, 568, 178, 49);
		panel.add(logout);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\process.png"));
		lblNewLabel_11.setBounds(68, 76, 128, 128);
		panel.add(lblNewLabel_11);
		
		JButton btnNewButton_5 = new JButton("Student Report");
		btnNewButton_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if the user type is "teacher" before allowing access
		        if ("teacher".equals(userType)) {
		            try {
		                studentrecord window = new studentrecord();
		                window.frame.setVisible(true);
		            } catch (Exception f) {
		                f.printStackTrace();
		            }
		        } else {
		            // Display a message indicating insufficient privileges
		            JOptionPane.showMessageDialog(systempanel, "Only instructor can access Student Report.");
		        }
		    }
		});

		btnNewButton_5.setBounds(52, 493, 178, 49);
		panel.add(btnNewButton_5);
		
       
	}
	private void fetchDataForTeacher(String tableName, DefaultTableModel model2) {
        try {
        	Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getObject("userID"));
                row.add(resultSet.getObject("Name"));
                row.add(resultSet.getObject("course"));
                // Add more columns as needed

                model2.addRow(row);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void fetchDataForCourse(String tableName, DefaultTableModel model1) {
        try {
        	Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getObject("CourseID"));
                row.add(resultSet.getObject("CourseName"));
                row.add(resultSet.getObject("Semester"));
                // Add more columns as needed

                model1.addRow(row);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private void fetchDataForStudents(String tableName, DefaultTableModel model) {
        try {
        	Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getObject("UserID"));
                row.add(resultSet.getObject("Name"));
                row.add(resultSet.getObject("Course"));
                // Add more columns as needed

                model.addRow(row);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private int getUserLevelFromDatabase(String userType) {
	    int userLevel = 0;  // Default value

	    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
	        String query = "SELECT Level FROM signup WHERE UserType = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, userType);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    userLevel = resultSet.getInt("Level");
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); // Handle this exception according to your application's requirements
	    }

	    return userLevel;
	}
}

