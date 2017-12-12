package fxTraining;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
	
	static Stage stage;
	static boolean btnYesClicked;
	
	public static boolean show(String title, String message, String btnTrue, String btnFalse) {
		//Initialize btnYesClicked
		btnYesClicked = false;
		
		//Create stage
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(300);
		stage.setMinHeight(200);
		
		//Label with given message
		Label lbl = new Label(message);

		//Button for True statement, like Ok or Yes
		Button buttonTrue = new Button(btnTrue);
		buttonTrue.setOnAction(e -> 
		{
			stage.close();
			btnYesClicked = true;
			});
		
		//Button for No statement, close window
		Button buttonFalse = new Button(btnFalse);
		buttonFalse.setOnAction(e -> 
		{
			stage.close();
			btnYesClicked = false;
		});
		
		//Hbox for the buttons
		HBox btnPane = new HBox(30);
		btnPane.getChildren().addAll(buttonTrue, buttonFalse);
		btnPane.setAlignment(Pos.BASELINE_CENTER);
		
		//Vbox
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl,btnPane);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
		
		return btnYesClicked;
		
	}

}
