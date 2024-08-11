package TraveManagement;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
	JProgressBar bar;
	Thread t;
	String username;

	Loading(String username) {
		this.username = username;
		setBounds(500, 200, 650, 400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel text = new JLabel("Travel and Tourism Application");
		text.setBounds(50, 20, 600, 40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Raleway", Font.BOLD, 35));
		add(text);

		bar = new JProgressBar();
		bar.setBounds(150, 100, 300, 35);
		bar.setStringPainted(true);
		add(bar);

		JLabel loading = new JLabel("Loading, Please wait..");
		loading.setBounds(230, 130, 200, 30);
		loading.setForeground(Color.RED);
		loading.setFont(new Font("Raleway", Font.BOLD, 16));
		add(loading);

		JLabel userName = new JLabel("Welcome "+username);
		userName.setBounds(20, 310, 400, 40);
		userName.setForeground(Color.RED);
		userName.setFont(new Font("Raleway", Font.BOLD, 16));
		add(userName);

		t = new Thread(this);
		t.start();

		setVisible(true);
	}

	public void run() {
		try {
			for (int i = 1; i <= 101; i++) {
				int max = bar.getMaximum();
				int value = bar.getValue();

				if (value < max) {
					bar.setValue(bar.getValue() + 1);
				} else {
					setVisible(false);
					new Dashboard(username);
				}

				Thread.sleep(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new Loading("");
	}
}
