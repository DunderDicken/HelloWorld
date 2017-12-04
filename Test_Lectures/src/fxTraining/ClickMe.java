package fxTraining;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.*;
import javafx.beans.binding.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;


public class ClickMe extends Application{

	private Button btn;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primStage) throws Exception {
		
		btn = new Button();
		btn.setText("CLICK ME");
		btn.setOnAction(event -> {if(btn.getText() == "CLICK ME") { btn.setText("Thank you ");} 
		else{btn.setText("CLICK ME");} 
		});
		
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);
		
		Scene scene = new Scene(pane,400,400);
		primStage.setScene(scene);
		primStage.show();
	}

}
