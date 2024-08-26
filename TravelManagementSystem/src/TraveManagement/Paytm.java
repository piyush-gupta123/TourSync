package TraveManagement;

import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {
	JButton back;
	Paytm() {
		setBounds(500, 200, 800, 600);
//		setLayout(null);

		JEditorPane pane = new JEditorPane();
		pane.setEditable(false);

		try {
			pane.setPage("https://paytm.com/");
		} catch (Exception e) {
			pane.setContentType("text/html");
			pane.setText("<html>Could not load page, Error 404</html>");
		}

		JScrollPane sp = new JScrollPane(pane);
		getContentPane().add(sp);
		
		back = new JButton("Back");
		back.setBounds(610, 20, 80, 40);
		back.addActionListener(this);
		pane.add(back);

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new Paytm();
	}
}
