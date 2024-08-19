package TraveManagement;

import javax.swing.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {
	JButton back;
	JLabel labelUsername, labelpersons, labelid, labelpackage, labelnumber, labelphone, labelprice;

	ViewPackage(String username) {
		setBounds(450, 180, 870, 625);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
		heading.setBounds(60, 0, 300, 30);
		add(heading);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);

		labelUsername = new JLabel("");
		labelUsername.setBounds(220, 50, 150, 25);
		add(labelUsername);

		JLabel lblpackage = new JLabel("Package");
		lblpackage.setBounds(30, 90, 150, 25);
		add(lblpackage);

		labelpackage = new JLabel("");
		labelpackage.setBounds(220, 90, 150, 25);
		labelpackage.setBackground(Color.WHITE);
		add(labelpackage);

		JLabel lblpersons = new JLabel("Total Number");
		lblpersons.setBounds(30, 130, 150, 25);
		add(lblpersons);

		labelpersons = new JLabel("");
		labelpersons.setBounds(220, 130, 150, 25);
		add(labelpersons);

		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30, 170, 150, 25);
		add(lblid);

		labelid = new JLabel("");
		labelid.setBounds(220, 170, 150, 25);
		add(labelid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 210, 150, 25);
		add(lblnumber);

		labelnumber = new JLabel("");
		labelnumber.setBounds(220, 210, 150, 25);
		add(labelnumber);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30, 250, 150, 25);
		add(lblphone);

		labelphone = new JLabel("");
		labelphone.setBounds(220, 250, 150, 25);
		add(labelphone);

		JLabel lblprice = new JLabel("Price");
		lblprice.setBounds(30, 290, 150, 25);
		add(lblprice);

		labelprice = new JLabel("");
		labelprice.setBounds(220, 290, 150, 25);
		add(labelprice);

		back = new JButton("Back");
		back.setBounds(130, 360, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/bookedDetails.jpg");
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(450, 20, 500, 400);
		add(img);

		try {
			Conn c = new Conn();
			String query = "Select * from bookpackage where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				labelUsername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelpackage.setText(rs.getString("package"));
				labelpersons.setText(rs.getString("totalPersons"));
				labelprice.setText(rs.getString("price"));
				labelphone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new ViewPackage("");
	}
}
