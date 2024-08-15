package TraveManagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener {
	String username;
	JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackage;

	Dashboard(String username) {
		this.username = username;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0, 0, 102));
		p1.setBounds(0, 0, 1600, 60);
		add(p1);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/dashboard.png");
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5, 0, 70, 70);
		p1.add(icon);

		JLabel heading = new JLabel("Dashboard");
		heading.setBounds(80, 10, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		p1.add(heading);

		JPanel p2 = new JPanel();
		p2.setBounds(0, 60, 300, 900);
		p2.setLayout(null);
		p2.setBackground(new Color(0, 0, 102));
		add(p2);

		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0, 0, 300, 50);
		addPersonalDetails.setBackground(new Color(0, 0, 102));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);

		updatePersonalDetails = new JButton("Update Personal Details");
		updatePersonalDetails.setBounds(0, 50, 300, 50);
		updatePersonalDetails.setBackground(new Color(0, 0, 102));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);

		viewPersonalDetails = new JButton("View Details");
		viewPersonalDetails.setBounds(0, 100, 300, 50);
		viewPersonalDetails.setBackground(new Color(0, 0, 102));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
		viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);

		JButton deletePersonalDetails = new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(0, 150, 300, 50);
		deletePersonalDetails.setBackground(new Color(0, 0, 102));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
		p2.add(deletePersonalDetails);

		checkPackages = new JButton("Check Packages");
		checkPackages.setBounds(0, 200, 300, 50);
		checkPackages.setBackground(new Color(0, 0, 102));
		checkPackages.setForeground(Color.WHITE);
		checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkPackages.addActionListener(this);
		checkPackages.setMargin(new Insets(0, 0, 0, 110));
		p2.add(checkPackages);

		bookPackage = new JButton("Book Package");
		bookPackage.setBounds(0, 250, 300, 50);
		bookPackage.setBackground(new Color(0, 0, 102));
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookPackage.setMargin(new Insets(0, 0, 0, 120));
		bookPackage.addActionListener(this);
		p2.add(bookPackage);

		JButton viewPackage = new JButton("View Package");
		viewPackage.setBounds(0, 300, 300, 50);
		viewPackage.setBackground(new Color(0, 0, 102));
		viewPackage.setForeground(Color.WHITE);
		viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewPackage.setMargin(new Insets(0, 0, 0, 120));
		p2.add(viewPackage);

		JButton viewHotels = new JButton("View Hotels");
		viewHotels.setBounds(0, 350, 300, 50);
		viewHotels.setBackground(new Color(0, 0, 102));
		viewHotels.setForeground(Color.WHITE);
		viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewHotels.setMargin(new Insets(0, 0, 0, 130));
		p2.add(viewHotels);

		JButton bookHotel = new JButton("Book Hotel");
		bookHotel.setBounds(0, 400, 300, 50);
		bookHotel.setBackground(new Color(0, 0, 102));
		bookHotel.setForeground(Color.WHITE);
		bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookHotel.setMargin(new Insets(0, 0, 0, 140));
		p2.add(bookHotel);

		JButton viewBookedHotel = new JButton("View Booked Hotel");
		viewBookedHotel.setBounds(0, 450, 300, 50);
		viewBookedHotel.setBackground(new Color(0, 0, 102));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewBookedHotel.setMargin(new Insets(0, 0, 0, 70));
		p2.add(viewBookedHotel);

		JButton destinations = new JButton("Destinations");
		destinations.setBounds(0, 500, 300, 50);
		destinations.setBackground(new Color(0, 0, 102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		destinations.setMargin(new Insets(0, 0, 0, 125));
		p2.add(destinations);

		JButton payments = new JButton("Payments");
		payments.setBounds(0, 550, 300, 50);
		payments.setBackground(new Color(0, 0, 102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
		payments.setMargin(new Insets(0, 0, 0, 155));
		p2.add(payments);

		JButton calculator = new JButton("Calculator");
		calculator.setBounds(0, 600, 300, 50);
		calculator.setBackground(new Color(0, 0, 102));
		calculator.setForeground(Color.WHITE);
		calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calculator.setMargin(new Insets(0, 0, 0, 145));
		p2.add(calculator);

		JButton notepad = new JButton("Notepad");
		notepad.setBounds(0, 650, 300, 50);
		notepad.setBackground(new Color(0, 0, 102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		notepad.setMargin(new Insets(0, 0, 0, 155));
		p2.add(notepad);

		JButton aboutUs = new JButton("About");
		aboutUs.setBounds(0, 700, 300, 50);
		aboutUs.setBackground(new Color(0, 0, 102));
		aboutUs.setForeground(Color.WHITE);
		aboutUs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		aboutUs.setMargin(new Insets(0, 0, 0, 175));
		p2.add(aboutUs);

		ImageIcon i4 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/home.jpg");
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel img2 = new JLabel(i6);
		img2.setBounds(0, 0, 1650, 1000);
		add(img2);

		JLabel text = new JLabel("Travel and Tourism Management System");
		text.setBounds(400, 70, 1200, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.PLAIN, 55));
		img2.add(text);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addPersonalDetails) {
			new AddCustomer(username);
		} else if (ae.getSource() == viewPersonalDetails) {
			new ViewDetails(username);
		} else if (ae.getSource() == updatePersonalDetails) {
			new UpdateCustomerDetails(username);
		} else if (ae.getSource() == checkPackages) {
			new ViewPackages();
		} else if (ae.getSource() == bookPackage) {
			new BookPackage(username);
		}
	}

	public static void main(String args[]) {
		new Dashboard("pgupta");
	}
}
