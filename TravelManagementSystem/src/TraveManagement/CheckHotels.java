package TraveManagement;
import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame {
	
	CheckHotels(){
		setBounds(500, 200, 800, 600);
		
		for(int i=1;i<=10;i++) {
			ImageIcon i1 = new ImageIcon("E:/Workspace/TourSync/TravelManagementSystem/src/icons/hotel"+(i)+".jpg");
			Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel l1 = new JLabel(i3);
			l1.setBounds(0, 0, 800, 600);
			add(l1);
		}
		
		setVisible(true);
	}
	
	public static void main (String args[]) {
		new CheckHotels();
	}
}
