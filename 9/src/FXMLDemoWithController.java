//package JavaFXMyTurns;

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.*;
import javafx.beans.binding.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;


public class FXMLDemoWithController extends Application implements Initializable {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button okButton;
	// here you need to add something for the welcomeLabel

	public void initialize(URL url, ResourceBundle rb) {
		okButton.disableProperty().bind(
				Bindings.createBooleanBinding(
						() -> username.getText().length() == 0
						|| password.getText().length() == 0,
						username.textProperty(),
						password.textProperty()));
		okButton.setOnAction(event ->
		System.out.println("Verifying " + username.getText()
		+ ":" + password.getText()));
		// here you need to add some action to e.g. welcomeLabel.setText("Welcome")
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("DialogWithController.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}
}




