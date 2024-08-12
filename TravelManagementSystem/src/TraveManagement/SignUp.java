package TraveManagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SignUp extends JFrame implements ActionListener {
	JButton create, back;
	JTextField tfusername, tfname, tfpassword, tfanswer;
	Choice security;

	SignUp() {
		setBounds(350, 200, 900, 360);
//		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131, 193, 233));
		p1.setLayout(null);
		p1.setBounds(0, 0, 500, 400);
		add(p1);

		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.BOLD, 14));
		username.setBounds(50, 20, 125, 25);
		p1.add(username);

		tfusername = new JTextField();
		tfusername.setBounds(190, 20, 180, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblname.setBounds(50, 60, 125, 25);
		p1.add(lblname);

		tfname = new JTextField();
		tfname.setBounds(190, 60, 180, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(50, 100, 125, 25);
		p1.add(password);

		tfpassword = new JTextField();
		tfpassword.setBounds(190, 100, 180, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);

		JLabel lblsecurity = new JLabel("Security Question");
		lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsecurity.setBounds(50, 140, 130, 25);
		p1.add(lblsecurity);

		security = new Choice();
		security.add("Select question");
		security.add("What was the name of your first school");
		security.add("What is the name of City/Town in which you were born");
		security.add("What is your favourite color");
		security.add("What was your mother's maiden family name");
		security.setBounds(190, 140, 180, 25);
		p1.add(security);

		JLabel lblanswer = new JLabel("Answer");
		lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblanswer.setBounds(50, 180, 130, 25);
		p1.add(lblanswer);

		tfanswer = new JTextField();
		tfanswer.setBounds(190, 180, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);

		create = new JButton("Create Account");
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(131, 193, 233));
		create.setFont(new Font("Tahoma", Font.BOLD, 14));
		create.setBounds(80, 250, 145, 30);
		create.addActionListener(this);
		p1.add(create);

		back = new JButton("Back");
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(131, 193, 233));
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.setBounds(250, 250, 130, 30);
		back.addActionListener(this);
		p1.add(back);

		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/signUp.jpg");
		Image img = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(img);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 50, 250, 250);
		add(image);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == create) {
			String username = tfusername.getText();
			String name = tfname.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem();
			String answer = tfanswer.getText();

			String query = "Insert into account Values('" + username + "', '" + name + "', '" + password + "', '"
					+ question + "', '" + answer + "')";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				setVisible(false);
				new Login();
			}
			catch(Exception e) {
				e.printStackTrace();			}
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String args[]) {
		SignUp sign = new SignUp();
	}
}
