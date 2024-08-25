package TraveManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
	JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
	Choice chotel, cac, cfood;
	JTextField totalPerson, totaldays;
	String username;
	JButton checkPrice, bookPackage, back;

	BookHotel(String username) {
		this.username = username;
		setBounds(350, 200, 1100, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("BOOK HOTEL");
		heading.setBounds(100, 20, 300, 25);
		heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		heading.setForeground(Color.RED);
		add(heading);

		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusername.setBounds(40, 70, 100, 20);
		add(lblusername);

		labelusername = new JLabel("");
		labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelusername.setBounds(250, 70, 100, 20);
		add(labelusername);

		JLabel lblpackage = new JLabel("Select Hotel");
		lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpackage.setBounds(40, 110, 150, 20);
		add(lblpackage);

		chotel = new Choice();
		chotel.setBounds(250, 110, 200, 20);
		add(chotel);

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from hotels");
			while (rs.next()) {
				chotel.add(rs.getString("hotelname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblperson = new JLabel("Total Person");
		lblperson.setBounds(40, 150, 150, 20);
		lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblperson);

		totalPerson = new JTextField("1");
		totalPerson.setBounds(250, 150, 200, 25);
		add(totalPerson);

		JLabel lbldays = new JLabel("Total Days");
		lbldays.setBounds(40, 190, 150, 20);
		lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbldays);

		totaldays = new JTextField("1");
		totaldays.setBounds(250, 190, 200, 25);
		add(totaldays);

		JLabel lblac = new JLabel("AC / Non-AC");
		lblac.setBounds(40, 230, 150, 20);
		lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblac);

		cac = new Choice();
		cac.add("Non-AC");
		cac.add("AC");
		cac.setBounds(250, 230, 150, 20);
		add(cac);

		JLabel lblfood = new JLabel("Food Included");
		lblfood.setBounds(40, 270, 150, 20);
		lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblfood);

		cfood = new Choice();
		cfood.add("No");
		cfood.add("Yes");
		cfood.setBounds(250, 270, 150, 20);
		add(cfood);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(40, 310, 150, 20);
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblid);

		labelid = new JLabel("");
		labelid.setBounds(250, 310, 200, 25);
		labelid.setBackground(Color.WHITE);
		add(labelid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(40, 350, 150, 20);
		lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblnumber);

		labelnumber = new JLabel("");
		labelnumber.setBounds(250, 350, 150, 25);
		add(labelnumber);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(40, 390, 150, 20);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblphone);

		labelphone = new JLabel("");
		labelphone.setBounds(250, 390, 200, 25);
		add(labelphone);

		JLabel lblprice = new JLabel("Total Price");
		lblprice.setBounds(40, 430, 150, 20);
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblprice);

		labelprice = new JLabel("");
		labelprice.setBounds(250, 430, 150, 25);
		add(labelprice);

		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		checkPrice = new JButton("Check Price");
		checkPrice.setBackground(Color.BLACK);
		checkPrice.setForeground(Color.WHITE);
		checkPrice.setBounds(60, 490, 120, 25);
		checkPrice.addActionListener(this);
		add(checkPrice);

		bookPackage = new JButton("Book Hotel");
		bookPackage.setBackground(Color.BLACK);
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setBounds(200, 490, 120, 25);
		bookPackage.addActionListener(this);
		add(bookPackage);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(340, 490, 120, 25);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/book.jpg");
		Image i2 = i1.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 40, 550, 400);
		add(image);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == checkPrice) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s
						.executeQuery("select * from hotels where hotelname = '" + chotel.getSelectedItem() + "'");
				while (rs.next()) {
					int cost = Integer.parseInt(rs.getString("costperperson"));
					int ac = Integer.parseInt(rs.getString("acroom"));
					int food = Integer.parseInt(rs.getString("foodincluded"));

					int persons = Integer.parseInt(totalPerson.getText());
					int days = Integer.parseInt(totaldays.getText());

					String acselected = cac.getSelectedItem();
					String foodselected = cfood.getSelectedItem();

					if (persons * days > 0) {
						int total = 0;
						total += acselected.equals("AC") ? ac : 0;
						total += foodselected.equals("Yes") ? food : 0;
						total += cost;
						total = total * persons * days;
						labelprice.setText("Rs. " + total);
					} else {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == bookPackage) {
			try {
				Conn c = new Conn();
				String query = "Insert into bookhotel values('" + labelusername.getText() + "','"
						+ chotel.getSelectedItem() + "','" + totalPerson.getText() + "','" + totaldays.getText() + "','"
						+ cac.getSelectedItem() + "','" + cfood.getSelectedItem() + "','" + labelid.getText() + "','"
						+ labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new BookHotel("");
	}
}
