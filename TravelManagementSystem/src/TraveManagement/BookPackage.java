package TraveManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
	JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
	Choice cpack;
	JTextField totalPerson;
	String username;
	JButton checkPrice, bookPackage, back;

	public BookPackage(String username) {
		this.username = username;
		setBounds(350, 200, 1100, 500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("BOOK PACKAGE");
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

		JLabel lblpackage = new JLabel("Select Package");
		lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpackage.setBounds(40, 110, 150, 20);
		add(lblpackage);

		cpack = new Choice();
		cpack.add("Selct Package");
		cpack.add("Gold Package");
		cpack.add("Silver Package");
		cpack.add("Bronze Package");
		cpack.setBounds(250, 110, 200, 20);
		add(cpack);

		JLabel lblperson = new JLabel("Total Person");
		lblperson.setBounds(40, 150, 150, 20);
		lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblperson);

		totalPerson = new JTextField("1");
		totalPerson.setBounds(250, 150, 200, 25);
		add(totalPerson);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(40, 190, 150, 20);
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblid);

		labelid = new JLabel("");
		labelid.setBounds(250, 190, 200, 25);
		labelid.setBackground(Color.WHITE);
		add(labelid);

		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(40, 230, 150, 20);
		lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblnumber);

		labelnumber = new JLabel("");
		labelnumber.setBounds(250, 230, 150, 25);
		add(labelnumber);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(40, 270, 150, 20);
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblphone);

		labelphone = new JLabel("");
		labelphone.setBounds(250, 270, 200, 25);
		add(labelphone);

		JLabel lblprice = new JLabel("Total Price");
		lblprice.setBounds(40, 310, 150, 20);
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblprice);

		labelprice = new JLabel("");
		labelprice.setBounds(250, 310, 150, 25);
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
		checkPrice.setBounds(60, 380, 120, 25);
		checkPrice.addActionListener(this);
		add(checkPrice);

		bookPackage = new JButton("Book Package");
		bookPackage.setBackground(Color.BLACK);
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setBounds(200, 380, 120, 25);
		bookPackage.addActionListener(this);
		add(bookPackage);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(340, 380, 120, 25);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/bookpackage.jpg");
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(550, 40, 500, 300);
		add(image);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == checkPrice) {
			String pack = cpack.getSelectedItem();
			int cost = 0;
			if (pack.equals("Gold Package")) {
				cost += 12000;
			} else if (pack.equals("Silver Package")) {
				cost += 10000;
			} else {
				cost += 8000;
			}
			int persons = Integer.parseInt(totalPerson.getText());
			cost *= persons;
			labelprice.setText("Rs. " + cost);
		} else if (ae.getSource() == bookPackage) {
			try {
				Conn c = new Conn();
				String query = "Insert into bookpackage values('" + labelusername.getText() + "','"
						+ cpack.getSelectedItem() + "','" + totalPerson.getText() + "','" + labelid.getText() + "','"
						+ labelnumber.getText() + "','"+labelphone.getText()+"','"+labelprice.getText()+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new BookPackage("");
	}
}
