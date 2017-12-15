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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPaneLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Text sceneTitle = new Text("This is Text");
		
		grid.add(sceneTitle, 0, 0,1,1);
		
		Label userName = new Label("A wild username appeard");
		grid.add(userName, 0, 1);
		
		TextField userInput = new TextField();
		grid.add(userInput, 2, 1);
		
		Label password = new Label("Password");
		grid.add(password, 0, 2);
		
		PasswordField pwField = new PasswordField();
		grid.add(pwField,2,2);
		
		Button btn = new Button ("Sign in");
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.BOTTOM_RIGHT);
		btnBox.getChildren().add(btn);
		grid.add(btnBox, 2, 4);
		final Text actionTarget = new Text();
		grid.add(actionTarget, 1, 6);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				actionTarget.setFill(Color.RED);
				actionTarget.setText("WHAT DID YOU DO?!");
		}});
		
		//grid.setGridLinesVisible(true);
		Scene scene = new Scene(grid,300,300);
		primaryStage.setTitle("Title");
		primaryStage.setScene(scene);
		primaryStage.show();

		
	}

}
