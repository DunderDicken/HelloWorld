package fxTraining;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

	public double xSpeed;
	public double ySpeed;
	public double radius;
	private double fieldWidth;
	private double fieldHeigth;
	private List<Ball> balls;

	public Ball(double radius, double fieldWidth, double fieldHeigth, ArrayList<Ball> ballsList) {
		super();
		this.radius = radius;
		this.fieldWidth = fieldWidth;
		this.fieldHeigth = fieldHeigth;

		super.setRadius(radius);
		super.setCenterX(Math.random() * (fieldWidth - this.radius) + 1);
		super.setCenterY(Math.random() * (fieldHeigth - this.radius) + 1);

		this.xSpeed = Math.random() * 5 + 1;
		this.ySpeed = Math.random() * 5 + 1;
		
		this.balls = ballsList;

		super.setFill(Color.GREEN);
	}

	public void move() {
		// Move with given speed
		super.setCenterX(super.getCenterX() + this.xSpeed);
		super.setCenterY(super.getCenterY() + this.ySpeed);

		// Detect collision left
		if (super.getCenterX() <= this.radius) {
			super.setCenterX(this.radius);
			this.xSpeed = -this.xSpeed;
		}

		// Detect collision right
		if (super.getCenterX() >= (this.fieldWidth - this.radius)) {
			super.setCenterX(this.fieldWidth -this.radius);
			this.xSpeed = -this.xSpeed;
		}
		
		//Detect collision top
		if(super.getCenterY() <= this.radius) {
			super.setCenterY(this.radius);
			this.ySpeed = -this.ySpeed;
		}
		
		//Detect collision bottom
		if(super.getCenterY() >= (this.fieldHeigth - this.radius)) {
			super.setCenterY(this.fieldHeigth - this.radius);
			this.ySpeed = -this.ySpeed;
		}
		
		//Detect collision with other balls
		for(Ball b : balls ) {
			
			if(b != this && b.intersects(super.getLayoutBounds())) {
				double tempX = this.xSpeed;
				double tempY = this.ySpeed;
				
				this.xSpeed = b.xSpeed;
				this.ySpeed = b.ySpeed;
				
				b.xSpeed = tempX;
				b.ySpeed = tempY;
				break;
			}
		}
	
		
	}
	

}
