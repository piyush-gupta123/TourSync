package TraveManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UpdateCustomerDetails extends JFrame implements ActionListener {
	JLabel labelUsername, labelname;
//	JComboBox comboid;
	JTextField tfnumber, tfCountry, tfaddress, tfemail, tfphone, tfid, tfgender;
//	JRadioButton rmale, rfemale;
	JButton add, back;

	UpdateCustomerDetails(String username) {
		setBounds(500, 200, 850, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(50, 0, 300, 25);
		add(text);

		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 20);
		add(lblusername);

		labelUsername = new JLabel("");
		labelUsername.setBounds(220, 50, 150, 25);
		add(labelUsername);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30, 90, 150, 25);
		add(lblid);

		tfid = new JTextField();
		tfid.setBounds(220, 90, 150, 25);
		add(tfid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 130, 150, 20);
		add(lblnumber);

		tfnumber = new JTextField();
		tfnumber.setBounds(220, 130, 150, 25);
		add(tfnumber);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30, 170, 150, 25);
		add(lblname);

		labelname = new JLabel("");
		labelname.setBounds(220, 170, 150, 25);
		add(labelname);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30, 210, 150, 25);
		add(lblgender);

		tfgender = new JTextField();
		tfgender.setBounds(220, 210, 150, 25);
		add(tfgender);

		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(30, 250, 70, 25);
		add(lblcountry);

		tfCountry = new JTextField();
		tfCountry.setBounds(220, 250, 150, 25);
		add(tfCountry);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(30, 290, 70, 25);
		add(lbladdress);

		tfaddress = new JTextField();
		tfaddress.setBounds(220, 290, 150, 25);
		add(tfaddress);

		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(30, 330, 70, 25);
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(220, 330, 150, 25);
		add(tfemail);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30, 370, 70, 25);
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(220, 370, 150, 25);
		add(tfphone);

		add = new JButton("Update");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(70, 430, 100, 25);
		add.addActionListener(this);
		add(add);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(220, 430, 100, 25);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TravelManagementSystem/src/icons/update.png");
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 100, 450, 300);
		add(image);

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
			while (rs.next()) {
				labelUsername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				tfid.setText(rs.getString("id"));
				tfnumber.setText(rs.getString("number"));
				tfgender.setText(rs.getString("gender"));
				tfCountry.setText(rs.getString("country"));
				tfaddress.setText(rs.getString("address"));
				tfemail.setText(rs.getString("email"));
				tfphone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String username = labelUsername.getText();
			String id = (String) tfid.getText();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String gender = null;
//			if (rmale.isSelected()) {
//				gender = "Male";
//			} else {
//				gender = "Female";
//			}

			String country = tfCountry.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();

			try {
				Conn c = new Conn();
				String query = "Update customer set username='" + username + "',id = '" + id + "',number='" + number
						+ "',name='" + name + "',gender='" + gender + "',country='" + country + "',address='" + address
						+ "',email='" + email + "',phone='" + phone + "'";
				c.s.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			setVisible(false);
//			new Dashboard(username);
		}
	}

	public static void main(String args[]) {
		new UpdateCustomerDetails("pgupta");
	}
}
