package _10_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener{
	JButton duck = new JButton ("DUCK");
	JButton frog = new JButton ("FROG");
	JButton fluffyUnicorns = new JButton ("UNICORN");
	public void showButton () {
		JFrame frame = new JFrame ();
		frame.setVisible(true);
		JPanel panel = new JPanel ();
		panel.add(duck);
		panel.add(fluffyUnicorns);
		panel.add(frog);
		frame.add(panel);
		frame.pack();
		duck.addActionListener(this);
		frog.addActionListener(this);
		fluffyUnicorns.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == duck) {
			showDucks ();
		}
		else if (buttonPressed == frog) {
			showFrog ();
		}
		else if (buttonPressed == fluffyUnicorns) {
			showFluffyUnicorns ();
		}
		// TODO Auto-generated method stub
	}
	void showDucks() {
	      playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	 }

	void showFrog() {
	      playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	 }

	void showFluffyUnicorns() {
	      playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	 }

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't 
	     //work on some Linux implementations 
	      try {
	      if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	      if (Runtime.getRuntime().exec(new String[] { 
	       "which", "xdg- open" }).getInputStream().read() != -1) {
	      Runtime.getRuntime().exec(new String[] { "xdg-open", videoID }); 
	      }
	      } else {
	           URI uri = new URI(videoID);
	           java.awt.Desktop.getDesktop().browse(uri);
	      }      } catch (Exception e) {
	           e.printStackTrace();
	      }
	}
}
