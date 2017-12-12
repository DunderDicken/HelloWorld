package fxTraining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	//Start scene
	Button btnSwitch1;
	Scene scene1;
	
	
	//AddSub Scene
	private Button btnAdd;
	private Button btnSub;
	private Label lbl;
	private int counter = 0;
	Button btnSwitch2;
	Scene scene2;
	
	//stage
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		
		btnSwitch1 = new Button("Switch scene");
		btnSwitch1.setOnAction(e -> btnSwitch_Click());
		HBox pane1 = new HBox(10);
		pane1.getChildren().add(btnSwitch1);
		
		scene1 = new Scene(pane1,200,200);
		
		//addSub
		btnAdd = new Button("add");
		btnAdd.setOnAction(e -> {
			counter++;
			lbl.setText(Integer.toString(counter));
			//MessageBox.show("You clicked me!", "this is a title");
			if(ConfirmationBox.show("Confirmation needed", "this is the message"
					, "Yes", "Nope")) {
				lbl.setText("YES!");
			}
		
		});
		
		btnSub = new Button("Sub");
		btnSub.setOnAction(e -> {
			counter--;
			lbl.setText(Integer.toString(counter));
		});
		
		btnSwitch2 = new Button("Switch");
		btnSwitch2.setOnAction(e -> btnSwitch_Click());
		
		
		lbl = new Label(Integer.toString(counter));
		HBox pane2 = new HBox(10);
		pane2.getChildren().addAll(lbl,btnAdd,btnSub,btnSwitch2);
		
		scene2 = new Scene(pane2,300,300);
		
		//set Scene
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
	}

	private void btnSwitch_Click() {

		if(stage.getScene() == scene1)
			stage.setScene(scene2);
		else
			stage.setScene(scene1);
	}

}
