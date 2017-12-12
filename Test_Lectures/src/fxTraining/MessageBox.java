package fxTraining;


import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class MessageBox {

	public static void show(String message, String title) {
		//create the stage and set given title
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(300);
		
		//create label with given message
		Label label = new Label(message);
		
		//create a button
		Button btnOk = new Button("Ok");
		btnOk.setOnAction(e -> stage.close());
		
		//create pane
		VBox pane = new VBox(20);
		pane.getChildren().addAll(label,btnOk);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
