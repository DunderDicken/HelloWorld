package fxTraining;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BouncingBalls extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	final private int WIDTH = 600;
	final private int HEIGTH = 500;
	final private int BALL_SIZE = 20;
	
	private ArrayList<Ball> ballList new ArrayList<Balls>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		
		for (int i = 0; i < 1; i++) {
			ballList.add(new Ball(BALL_SIZE,WIDTH,HEIGTH, ballList));
			
		}
		
		root.getChildren().addAll(ballList);
		
		Scene scene = new Scene(root, WIDTH, HEIGTH);
		
		
	}

}
