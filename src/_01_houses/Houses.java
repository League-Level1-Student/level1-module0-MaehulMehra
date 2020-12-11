package _01_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	Robot houseMaker = new Robot (45, 400);
	public void run() {	
		Random random = new Random ();
		for (int i = 0; i <10; i++) {
		int size = random.nextInt(3);
		if (size == 0){
			makeHouse ("small");
		}
		else if (size == 1) {
			makeHouse ("medium");
		}
		else {
			makeHouse ("large");
		}
		}
		houseMaker.hide();
	}
	void makeHouse (int height) {
			houseMaker.setPenColor(0, 0, 0);
			houseMaker.setSpeed(25);
			houseMaker.penDown();
			houseMaker.setAngle(0);
			houseMaker.move(height);
			houseMaker.turn(90);
			houseMaker.move(25);
			houseMaker.turn(90);
			houseMaker.move(height);
			houseMaker.turn(-90);
			houseMaker.setPenColor(Color.green);	
			houseMaker.move (30);
			houseMaker.turn (-90);
	}
	void makeHouse (String height) {
		if (height.equalsIgnoreCase("small")) {
			makeHouse (60);
		}
		else if (height.equalsIgnoreCase("medium")) {
			makeHouse (120);
		}
		else if (height.equalsIgnoreCase("large")) {
			makeHouse (250);
		}
	}
}

