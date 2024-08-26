package TraveManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
	JButton pay,back;
	Payment(){
		setBounds(500, 200, 800,600);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/paytm.jpeg");
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(0, 0, 800, 600);
		add(i4);
		
		pay = new JButton("Pay");
		pay.setBounds(420, 0, 80, 40);
		pay.addActionListener(this);
		i4.add(pay);
		
		back = new JButton("Back");
		back.setBounds(520, 0, 80, 40);
		back.addActionListener(this);
		i4.add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == pay) {
			setVisible(false);
			new Paytm();
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new Payment();
	}
}
