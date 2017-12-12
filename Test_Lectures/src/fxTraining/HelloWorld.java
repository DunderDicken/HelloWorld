package fxTraining;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.application.Application;

public class HelloWorld extends Application implements EventHandler<ActionEvent> {

	private Button btnAdd;
	private Button btnSub;
	private Label lbl;
	private int counter = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Add button
		btnAdd = new Button();
		btnAdd.setText("Add");
		btnAdd.setOnAction(this);

		// Add button
		btnSub = new Button();
		btnSub.setText("Subtract");
		btnSub.setOnAction(this);

		// Create label
		lbl = new Label();
		lbl.setText(Integer.toString(counter));

		//Add the buttons and the label to the Hbox pane
		HBox pane = new HBox(30);
		pane.getChildren().addAll(lbl, btnAdd, btnSub);
		

		//Add layout pane to a Scene
		Scene scene = new Scene(pane,300,300);
		
		//Add the scene to a stage
		primaryStage.setTitle("This is a window");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@Override
	public void handle(ActionEvent event) {

		if(event.getSource() == btnAdd) {
			counter++;
		}
		if(event.getSource() == btnSub) {
			counter--;
		}
		lbl.setText(Integer.toString(counter));
	}

	public static void main(String[] args) {

		launch(args);
	}

}
