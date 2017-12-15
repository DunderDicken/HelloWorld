package fxTraining;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPaneRec extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		//grid.setPadding(new Insets(10));
		grid.setHgap(10);

		Rectangle rec = new Rectangle(600, 500);
		rec.setFill(Color.AQUA);
		grid.add(rec, 1, 2,4,1);

		
		Text sceneTitle = new Text("This is Text");
		grid.add(sceneTitle, 0, 0, 1, 1);
		
		Text col1T = new Text("This is col1");
		grid.add(col1T, 1, 0, 1, 1);
		
		Text col2T = new Text("This is col2");
		grid.add(col2T, 2, 0, 1, 1);
		
		Text col3T = new Text("This is col3");
		grid.add(col3T, 3, 0, 1, 1);
		
		Text col4T = new Text("This is col4");
		grid.add(col4T, 4, 0, 1, 1);
		
		Text col5T = new Text("This is col5");
		grid.add(col5T, 5, 0, 1, 1);
		
		Button play = new Button("Play");
		//play.setPrefHeight(100);
		Button paus = new Button("Pause");

		Region spacer = new Region();
		spacer.setPrefHeight(100);
		
		grid.add(play, 3, 1);
		grid.add(spacer, 4, 1);
		
		grid.setGridLinesVisible(true);
		Scene scene = new Scene(grid, 800, 700);
		primaryStage.setTitle("Title");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
