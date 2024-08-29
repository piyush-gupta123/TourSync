package TraveManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
	JButton back;
	About() {
		setBounds(600, 200, 500, 450);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel k1 = new JLabel("ABOUT");
		k1.setBounds(200, 10, 100, 40);
		k1.setForeground(Color.RED);
		k1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(k1);

		TextArea tx = new TextArea(
				"TourSync is a comprehensive Travel and Tourism Management System built with Java and Swing, designed to streamline the booking and management process for travel packages and hotel reservations. The application includes the following key features:\r\n"
						+ "\r\n"
						+ "1. User Authentication: Secure login and registration for users to access personalized services.\r\n"
						+ "2. Booking Packages and Hotels: A user-friendly interface to browse, select, and book travel packages and hotel stays.\r\n"
						+ "3. Payment Gateway Integration: Seamless payment processing for bookings, ensuring a smooth and secure transaction experience.\r\n"
						+ "\nThis system provides an efficient way for users to plan and manage their travel experiences, offering a cohesive solution for the travel industry.",
				10, 20, Scrollbar.VERTICAL);
		tx.setEditable(false);
		tx.setBounds(20, 100, 450, 200);
		tx.setBackground(Color.WHITE);
		add(tx);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200, 350, 100, 25);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new About();
	}
}
