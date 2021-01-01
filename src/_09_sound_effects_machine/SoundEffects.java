package _09_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffects implements ActionListener {
	JButton leftButton = new JButton ();
	JButton rightButton = new JButton ();
	public void showButton () {
		JFrame frame = new JFrame ();
		frame.setVisible(true);
		JPanel panel = new JPanel ();
		panel.add(leftButton);
		panel.add(rightButton);
		frame.add(panel);
		frame.pack();
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == leftButton) {
			playSound ("harley-davidson-daniel_simon.wav");
		}
		else if (buttonPressed == rightButton) {
			playSound ("sawing-wood-daniel_simon.wav");
		}
	}
	private void playSound(String soundFile) {
		String path = "src/_09_sound_effects_machine/";
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
