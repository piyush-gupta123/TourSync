package TraveManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewDetails extends JFrame implements ActionListener {
	JButton back;
	JLabel labelUsername, labelnumber, labelname, labelid, labelgender, labelcountry, labeladdress, labelemail,
			labelphone;

	ViewDetails(String username) {
		setBounds(450, 180, 870, 625);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);

		labelUsername = new JLabel("");
		labelUsername.setBounds(220, 50, 150, 25);
		add(labelUsername);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30, 110, 150, 25);
		add(lblid);

		labelid = new JLabel("");
		labelid.setBounds(220, 110, 150, 25);
		labelid.setBackground(Color.WHITE);
		add(labelid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 170, 150, 25);
		add(lblnumber);

		labelnumber = new JLabel("");
		labelnumber.setBounds(220, 170, 150, 25);
		add(labelnumber);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30, 230, 150, 25);
		add(lblname);

		labelname = new JLabel("");
		labelname.setBounds(220, 230, 150, 25);
		add(labelname);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30, 290, 150, 25);
		add(lblgender);

		labelgender = new JLabel("");
		labelgender.setBounds(220, 290, 150, 25);
		add(labelgender);

		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(500, 50, 150, 25);
		add(lblcountry);

		labelcountry = new JLabel("");
		labelcountry.setBounds(690, 50, 150, 25);
		add(labelcountry);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(500, 110, 150, 25);
		add(lbladdress);

		labeladdress = new JLabel("");
		labeladdress.setBounds(690, 110, 150, 25);
		add(labeladdress);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(500, 170, 150, 25);
		add(lblemail);

		labelemail = new JLabel("");
		labelemail.setBounds(690, 170, 150, 25);
		add(labelemail);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(500, 230, 150, 25);
		add(lblphone);

		labelphone = new JLabel("");
		labelphone.setBounds(690, 230, 150, 25);
		add(labelphone);

		back = new JButton("Back");
		back.setBounds(350, 350, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TravelManagementSystem/src/icons/viewall.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(20, 400, 600, 200);
		add(img);

		ImageIcon i4 = new ImageIcon("E:/Workspace/TravelManagementSystem/src/icons/viewall.jpg");
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel img2 = new JLabel(i6);
		img2.setBounds(600, 400, 600, 200);
		add(img2);

		try {
			Conn c = new Conn();
			String query = "Select * from customer where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				labelUsername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelemail.setText(rs.getString("email"));
				labelphone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back) {
			setVisible(false);
//			new Dashboard();
		}

	}

	public static void main(String args[]) {
		new ViewDetails("");
	}
}
