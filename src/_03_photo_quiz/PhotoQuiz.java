package _03_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() throws Exception {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// Copy Image Address
		String URL = "https://personal.psu.edu/xqz5228/jpg.jpg";
		// 2. create a variable of type "Component" that will hold your image
		Component image;
		// 3. use the "createImage()" method below to initialize your Component
		image = createImage (URL);
		// 4. add the image to the quiz window
		quizWindow.add(image);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String question1 = JOptionPane.showInputDialog(null, "Are minions yellow?");
		// 7. print "CORRECT" if the user gave the right answer
		if (question1.equalsIgnoreCase("yes")) {
			System.out.println("CORRECT");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			System.out.println("INCORRECT");
		}
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(image);
		// 10. find another image and create it (might take more than one line
		// of code)
		String URL2 = "https://tinyjpg.com/images/social/website.jpg";
		// 11. add the second image to the quiz window
		Component image2;
		image2 = createImage (URL2);
		quizWindow.add(image2);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		String question2 = JOptionPane.showInputDialog(null, "What animal is this?");
		// 14+ check answer, say if correct or incorrect, etc.
		if (question2.equalsIgnoreCase("Panda")) {
			System.out.println("CORRECT");
		}
		else {
			System.out.println("INCORRECT");
		}
	}

	private Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
