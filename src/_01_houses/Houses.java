package _01_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	Robot houseMaker = new Robot (45, 400);
	public void run() {	
		Random random = new Random ();
		houseMaker.setWindowColor(Color.black);
		Color cooler;
		for (int i = 0; i <10; i++) {
		int color = random.nextInt(3);
		if (color == 0) {
			cooler = Color.PINK;
		}
		else if (color ==1) {
			cooler = Color.YELLOW;
		}
		else {
			cooler = Color.ORANGE;
		}
		int size = random.nextInt(3);
		if (size == 0){
			makeHouse ("small", cooler);
		}
		else if (size == 1) {
			makeHouse ("medium", cooler);
		}
		else {
			makeHouse ("large", cooler);
		}
		}
		houseMaker.hide();
	}
	void makeHouse (int height, Color cooler) {
			houseMaker.setPenColor(cooler);
			houseMaker.setSpeed(25);
			houseMaker.penDown();
			houseMaker.setAngle(0);
			houseMaker.move(height);
			if (height == 250) {
				drawPointyRoof ();
			}
			else {
				drawFlatRoof ();
			}
			houseMaker.move(height);
			houseMaker.turn(-90);
			houseMaker.setPenColor(Color.green);	
			houseMaker.move (30);
			houseMaker.turn (-90);
	}
	void makeHouse (String height, Color cooler) {
		if (height.equalsIgnoreCase("small")) {
			makeHouse (60, cooler);
		}
		else if (height.equalsIgnoreCase("medium")) {
			makeHouse (120, cooler);
		}
		else if (height.equalsIgnoreCase("large")) {
			makeHouse (250, cooler);
		}
	}
	void drawPointyRoof () {
		houseMaker.turn(45);
		houseMaker.move(35);
		houseMaker.turn(90);
		houseMaker.move(35);
		houseMaker.turn(45);
	}
	void drawFlatRoof () {
		houseMaker.turn(90);
		houseMaker.move(35);
		houseMaker.turn(90);
	}
}

