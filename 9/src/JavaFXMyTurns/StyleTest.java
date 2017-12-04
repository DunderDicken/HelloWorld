// LabelTest.java
package JavaFXMyTurns;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StyleTest extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		TextField fNameFld = new TextField();
		Label fNameLbl = new Label("First Name:");
		fNameLbl.setLabelFor(fNameFld);

		TextField lNameFld = new TextField();
		Label lNameLbl = new Label("Last Name:");
		lNameLbl.setLabelFor(lNameFld);

		GridPane root = new GridPane();
		root.addRow(0, fNameLbl, fNameFld);
		root.addRow(1, lNameLbl, lNameFld);
		root.setStyle(
				"-fx-padding: 10;" +
		        "-fx-border-style: solid inside;" +
		        "-fx-border-width: 20;" +
		        "-fx-border-insets: 5;" +
		        "-fx-border-radius: 5;" +
		        "-fx-border-color: blue;");
		// check: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html#gridpane

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Testing CSS");
		stage.show();
	}
}
