package _01_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	Robot houseMaker = new Robot (45, 400);
	public void run() {	
		for (int i = 0; i <10; i++) {
		makeHouse (100);
		}
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
}

