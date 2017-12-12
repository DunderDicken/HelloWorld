package fxTraining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private Insets padding = new Insets(10);
	//Start scene
	private Button btn1Scene1;
	private Button btn2Scene1;
	private Button btnSwitch1;
	private Label lbl1;
	Scene scene1;
	
	
	//Second scene
	private Button btn1Scene2;
	private Button btn2Scene2;
	private Button btnSwitch2;
	private Label lbl2;
	Scene scene2;
	
	//stage
	Stage stage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		stage.setTitle("Stage");
		
		//Scene 1 :
		btnSwitch1 = new Button("Switch 2 scene 2");
		btnSwitch1.setOnAction(e -> btnSwitch_Click());
		
		btn1Scene1 = new Button("Messagebox");
		btn1Scene1.setOnAction(e -> MessageBox.show("IMPORTANT MESSAGE", "TITLE!"));
		
		btn2Scene1 = new Button("Close");
		btn2Scene1.setOnAction(e -> closebtnClicked());
		
		lbl1 = new Label("This is text for scene1");
		
		HBox btnPane1 = new HBox(10, btn1Scene1,btn2Scene1, btnSwitch1);
		//btnPane1.getChildren().addAll(btn1Scene1,btn2Scene1, btnSwitch1);
		btnPane1.setAlignment(Pos.BASELINE_CENTER);
		btnPane1.setPadding(padding);
		//HBox.setMargin(btn1Scene1, new Insets(30));
		
		VBox pane1 = new VBox(20);
		pane1.getChildren().addAll(lbl1,btnPane1);
		pane1.setAlignment(Pos.CENTER);
		
		scene1 = new Scene(pane1);
		
		//Scene 2 :
		btnSwitch2 = new Button("Switch 2 scene 1");
		btnSwitch2.setOnAction(e -> btnSwitch_Click());
		
		btn1Scene2 = new Button("Messagebox");
		btn1Scene2.setOnAction(e -> MessageBox.show("IMPORTANT MESSAGE num. 2", "TITLE 2!"));
		
		btn2Scene2 = new Button("Confirmation 2");
		btn2Scene2.setOnAction(e -> ConfirmationBox.show("Confirmation 2", "Holy balls", "YES", "maybe"));
		
		lbl2 = new Label("This is text for scene2");
		
		HBox btnPane2 = new HBox(15);
		btnPane2.getChildren().addAll(btn1Scene2,btn2Scene2, btnSwitch2);
		btnPane2.setAlignment(Pos.BASELINE_CENTER);
		
		VBox pane2 = new VBox(20);
		pane2.getChildren().addAll(lbl2,btnPane2);
		pane2.setAlignment(Pos.CENTER);
		
		scene2 = new Scene(pane2);
		
		stage.setOnCloseRequest(e -> {
			e.consume();
			closebtnClicked();
		});
		
		//set scene:
		stage.setScene(scene1);
		stage.show();
		
	}


	private void closebtnClicked() {

		boolean reallyQuit = false;
		reallyQuit = ConfirmationBox.show("Really quit?", "Do you really REALLY want to quit?", "YES", "NO, not really");
		if(reallyQuit) {
			
			stage.close();
		}
	}


	private void btnSwitch_Click() {

		if(stage.getScene() == scene1) {
			stage.setScene(scene2);
		}else
			stage.setScene(scene1);
	}

}
