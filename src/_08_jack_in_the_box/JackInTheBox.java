package _08_jack_in_the_box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JackInTheBox implements ActionListener{
	int al = 0;
	public void showButton () {
		JFrame frame = new JFrame ();
		frame.setVisible(true);
		JButton button = new JButton ("Surprise");
		frame.add(button);
		frame.pack ();
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		al ++;
		if (al == 5) {
			showPicture ("jackInTheBox.png");
			playSound ("homer-woohoo.wav");
		}
		// TODO Auto-generated method stub
	}
	private void showPicture(String fileName) { 
	      try {
	           JLabel imageLabel = createLabelImage(fileName);
	           JFrame frame = new JFrame();
	           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           frame.add(imageLabel);
	           frame.setVisible(true);
	           frame.pack();
	      } catch (Exception e) {
	           e.printStackTrace();
	      }
	 }
	private JLabel createLabelImage(String fileName) {
	     try {
		          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	           } else {
	                Icon icon = new ImageIcon(imageURL);
	                JLabel imageLabel = new JLabel(icon);
	                return imageLabel;
	          }
	      } catch (Exception e) {
	           System.err.println("Could not find image " + fileName);
	           return new JLabel();
	     }
	}
	private void playSound(String soundFile) {
		String path = "src/_08_jack_in_the_box/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
	}
}
