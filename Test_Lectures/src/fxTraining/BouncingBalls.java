package fxTraining;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBalls extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	final private int WIDTH = 600;
	final private int HEIGTH = 500;
	final private int BALL_SIZE = 20;
	final private int NUMBER_OF_BALLS = 4;

	private ArrayList<Ball> balls = new ArrayList<Ball>();;

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Group root = new Group();
		
		for (int i = 0; i < NUMBER_OF_BALLS; i++) {
			balls.add(new Ball(BALL_SIZE, WIDTH, HEIGTH, balls));

		}
		Rectangle rec = new Rectangle(WIDTH,HEIGTH);
		rec.setFill(Color.AQUA);
		root.getChildren().add(rec);
		root.getChildren().addAll(balls);
		
		Button topBtn = new Button("Paus");
		topBtn.setPrefHeight(100);
		topBtn.setPrefWidth(100);
	
		BorderPane rootPane = new BorderPane(root,topBtn,null,null,null);
		BorderPane.setAlignment(topBtn, Pos.CENTER);
		KeyFrame k = new KeyFrame(Duration.millis(10), e -> {
			for (Ball b : balls)
				b.move();
		});

		Timeline t = new Timeline(k);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
		
		Scene scene = new Scene(rootPane, WIDTH+200, HEIGTH+200);
		primaryStage.setTitle("Holy balls!");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

}
