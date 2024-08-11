package TraveManagement;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JTextField tfusername, tfPassword;
	JButton login, signUp, fPassword;

	Login() {
		setSize(900, 400);
		setLocation(350, 200);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131, 193, 233));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		ImageIcon i1 = new ImageIcon("E:/Workspace/TravelManagementSystem/src/icons/login.png");
		Image img = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(img);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 120, 200, 200);
		p1.add(image);

		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(400, 30, 450, 300);
		add(p2);

		JLabel username = new JLabel("Username");
		username.setBounds(60, 20, 120, 25);
		username.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(username);

		tfusername = new JTextField();
		tfusername.setBounds(60, 60, 300, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);

		JLabel password = new JLabel("Password");
		password.setBounds(60, 110, 100, 25);
		password.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(password);

		tfPassword = new JTextField();
		tfPassword.setBounds(60, 150, 300, 30);
		tfPassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfPassword);

		login = new JButton("Login");
		login.setBounds(60, 200, 130, 30);
		login.setBackground(new Color(131, 193, 233));
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setBorder(new LineBorder(new Color(131, 193, 233)));
		p2.add(login);

		signUp = new JButton("SignUp");
		signUp.setBounds(230, 200, 130, 30);
		signUp.setBackground(new Color(131, 193, 233));
		signUp.setForeground(Color.WHITE);
		signUp.addActionListener(this);
		signUp.setBorder(new LineBorder(new Color(131, 193, 233)));
		p2.add(signUp);

		fPassword = new JButton("Forget Password");
		fPassword.setBounds(130, 250, 130, 30);
		fPassword.setBackground(new Color(131, 193, 233));
		fPassword.setForeground(Color.WHITE);
		fPassword.addActionListener(this);
		fPassword.setBorder(new LineBorder(new Color(131, 193, 233)));
		p2.add(fPassword);

		JLabel text = new JLabel("Trouble in logging in...");
		text.setBounds(280, 250, 150, 20);
		text.setForeground(Color.RED);
		p2.add(text);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			try {
				String username = tfusername.getText();
				String password = tfPassword.getText();
				
				String query = "Select * from account where username = '"+username+"' AND password = '"+password+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query); 
				
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect credentials..");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == signUp) {
			setVisible(false);
			new SignUp();
		} else if(ae.getSource() == fPassword) {
			setVisible(false);
			new ForgetPassword();
		}
	}

	public static void main(String args[]) {
		Login l = new Login();
	}
}
