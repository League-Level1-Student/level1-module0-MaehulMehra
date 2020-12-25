package _07_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	public void showButton () {
		JFrame frame = new JFrame ();
		frame.setVisible(true);
		JButton button = new JButton ("Get My Fortune.");
		frame.add(button);
		frame.pack ();
		button.addActionListener(this);
		System.out.println("Button Clicked");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "WOOHOO");
		int rand = new Random().nextInt(5);
		if (rand == 0) {
			JOptionPane.showMessageDialog(null, "You win 2 cents");
		}
		else if (rand == 1) {
			JOptionPane.showMessageDialog(null, "You become awesomer.");
		}
		else if (rand == 2) {
			JOptionPane.showMessageDialog(null, "You can now eat your favorite food.");
		}
		else if (rand == 3) {
			JOptionPane.showMessageDialog(null, "You are now on your way to Hawaii.");
		}
		else {
			JOptionPane.showMessageDialog(null, "You get a job.");
		}
		// TODO Auto-generated method stub
		
	}
}
