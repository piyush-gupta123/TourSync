package TraveManagement;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
	JButton back;
	JLabel labelUsername, labelpersons, labelid, labelhotel, labelnumber, labelphone, labelprice, labeldays, labelac,
			labelfood;

	ViewBookedHotel(String username) {
		setBounds(400, 200, 1000, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("VIEW BOOKED HOTEL DETAILS");
		heading.setBounds(60, 0, 400, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);

		labelUsername = new JLabel("");
		labelUsername.setBounds(220, 50, 150, 25);
		add(labelUsername);

		JLabel lblhotel = new JLabel("Hotel Name");
		lblhotel.setBounds(30, 90, 150, 25);
		add(lblhotel);

		labelhotel = new JLabel("");
		labelhotel.setBounds(220, 90, 150, 25);
		labelhotel.setBackground(Color.WHITE);
		add(labelhotel);

		JLabel lblpersons = new JLabel("Total Number");
		lblpersons.setBounds(30, 130, 150, 25);
		add(lblpersons);

		labelpersons = new JLabel("");
		labelpersons.setBounds(220, 130, 150, 25);
		add(labelpersons);

		JLabel lbldays = new JLabel("Total Days");
		lbldays.setBounds(30, 170, 150, 25);
		add(lbldays);

		labeldays = new JLabel("");
		labeldays.setBounds(220, 170, 150, 25);
		add(labeldays);

		JLabel lblac = new JLabel("AC/Non-AC");
		lblac.setBounds(30, 210, 150, 25);
		add(lblac);

		labelac = new JLabel("");
		labelac.setBounds(220, 210, 150, 25);
		add(labelac);

		JLabel lblfood = new JLabel("Food Included?");
		lblfood.setBounds(30, 250, 150, 25);
		add(lblfood);

		labelfood = new JLabel("");
		labelfood.setBounds(220, 250, 150, 25);
		add(labelfood);

		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30, 290, 150, 25);
		add(lblid);

		labelid = new JLabel("");
		labelid.setBounds(220, 290, 150, 25);
		add(labelid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 330, 150, 25);
		add(lblnumber);

		labelnumber = new JLabel("");
		labelnumber.setBounds(220, 330, 150, 25);
		add(labelnumber);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30, 370, 150, 25);
		add(lblphone);

		labelphone = new JLabel("");
		labelphone.setBounds(220, 370, 150, 25);
		add(labelphone);

		JLabel lblprice = new JLabel("Total Cost");
		lblprice.setBounds(30, 410, 150, 25);
		add(lblprice);

		labelprice = new JLabel("");
		labelprice.setBounds(220, 410, 150, 25);
		add(labelprice);

		back = new JButton("Back");
		back.setBounds(130, 460, 100, 25);
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
			String query = "Select * from bookhotel where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				labelUsername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelhotel.setText(rs.getString("name"));
				labelpersons.setText(rs.getString("persons"));
				labelprice.setText(rs.getString("price"));
				labelphone.setText(rs.getString("phone"));
				labeldays.setText(rs.getString("days"));
				labelac.setText(rs.getString("ac"));
				labelfood.setText(rs.getString("food"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new ViewBookedHotel("");
	}
}
