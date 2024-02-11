package CMS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class module {

	JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					module window = new module();
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
	public module() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(166, 188, 255));
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select the Module");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel.setBounds(124, 29, 179, 40);
		frame1.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Object Oriented Programming");
		chckbxNewCheckBox.setBackground(new Color(166, 188, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(87, 122, 271, 23);
		frame1.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxConceptsAndTechnology = new JCheckBox("Concepts and Technology of AI");
		chckbxConceptsAndTechnology.setBackground(new Color(166, 188, 255));
		chckbxConceptsAndTechnology.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxConceptsAndTechnology.setBounds(87, 173, 271, 23);
		frame1.getContentPane().add(chckbxConceptsAndTechnology);
		
		JCheckBox chckbxNumericalMethodsAnd = new JCheckBox("Numerical Methods and Concurrency");
		chckbxNumericalMethodsAnd.setBackground(new Color(166, 188, 255));
		chckbxNumericalMethodsAnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNumericalMethodsAnd.setBounds(87, 223, 293, 23);
		frame1.getContentPane().add(chckbxNumericalMethodsAnd);
		
		JButton btnNewButton = new JButton("Selection Complete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame1.setVisible(false);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(143, 283, 150, 23);
		frame1.getContentPane().add(btnNewButton);
		frame1.setBounds(100, 100, 459, 395);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
