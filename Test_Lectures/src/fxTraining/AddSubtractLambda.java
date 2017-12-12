package fxTraining;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.event.*;

public class AddSubtractLambda extends Application{

	public static void main(String[] args) {

		launch(args);
	}
	
	private Button btnAdd;
	private Button btnSub;
	private Label lbl;
	private int counter = 0;
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		btnAdd = new Button("add");
		btnAdd.setOnAction(e -> {
			counter++;
			lbl.setText(Integer.toString(counter));
		});
		
		btnSub = new Button("Sub");
		btnSub.setOnAction(e -> {
			counter--;
			lbl.setText(Integer.toString(counter));
		});
		
		lbl = new Label(Integer.toString(counter));
		HBox pane = new HBox(10);
		pane.getChildren().addAll(lbl,btnAdd,btnSub);
		
		Scene scene = new Scene(pane,300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
