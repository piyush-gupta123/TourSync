package TraveManagement;

import javax.swing.*;
import java.awt.*;

public class BookPackage extends JFrame {
	JLabel labelusername;
	Choice cpack;
	JTextField totalPerson;
	public BookPackage() {
		setBounds(350, 200, 1100, 500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("BOOK PACKAGE");
		heading.setBounds(100, 20, 300, 25);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
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

		JLabel lblid = new JLabel("Select Package");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblid.setBounds(40, 110, 150, 20);
		add(lblid);
		
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

//		labelid = new JLabel("");
//		labelid.setBounds(220, 110, 150, 25);
//		labelid.setBackground(Color.WHITE);
//		add(labelid);
//
//		JLabel lblnumber = new JLabel("Number");
//		lblnumber.setBounds(30, 170, 150, 25);
//		add(lblnumber);
//
//		labelnumber = new JLabel("");
//		labelnumber.setBounds(220, 170, 150, 25);
//		add(labelnumber);
//
//		JLabel lblname = new JLabel("Name");
//		lblname.setBounds(30, 230, 150, 25);
//		add(lblname);
//
//		labelname = new JLabel("");
//		labelname.setBounds(220, 230, 150, 25);
//		add(labelname);
//
//		JLabel lblgender = new JLabel("Gender");
//		lblgender.setBounds(30, 290, 150, 25);
//		add(lblgender);
//
//		labelgender = new JLabel("");
//		labelgender.setBounds(220, 290, 150, 25);
//		add(labelgender);
//
//		JLabel lblcountry = new JLabel("Country");
//		lblcountry.setBounds(500, 50, 150, 25);
//		add(lblcountry);
//
//		labelcountry = new JLabel("");
//		labelcountry.setBounds(690, 50, 150, 25);
//		add(labelcountry);
//		
		setVisible(true);

	}

	public static void main(String args[]) {
		new BookPackage();
	}
}
