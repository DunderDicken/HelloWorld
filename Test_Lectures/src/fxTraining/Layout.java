package fxTraining;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Layout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label top = new Label("TOP");
		Label top2 = new Label("-");
		Label top3 = new Label("-");
		Label center = new Label("CENTER");
		Label right = new Label("RIGTH");
		Label left = new Label("LEFT");
		Label bottom = new Label("BOTTOM");
		
//		top.setMaxWidth(Double.MAX_VALUE);
//		center.setMaxWidth(Double.MAX_VALUE);
//		right.setMaxWidth(Double.MAX_VALUE);
//		left.setMaxWidth(Double.MAX_VALUE);
//		bottom.setMaxWidth(Double.MAX_VALUE);
		
		Insets space = new Insets(10);
		Region spacer1 = new Region();
		Region spacer2 = new Region();
		HBox.setMargin(top2, space);
		HBox.setMargin(top, space);
		HBox.setMargin(top3, space);
		HBox.setHgrow(spacer1, Priority.ALWAYS);
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		HBox topPane = new HBox(top2, spacer2, top, spacer1, top3);

		BorderPane bPane = new BorderPane(center, topPane, right, bottom, left);
		BorderPane.setAlignment(center, Pos.CENTER);
		BorderPane.setAlignment(right, Pos.CENTER);
		BorderPane.setAlignment(left, Pos.CENTER);
		BorderPane.setAlignment(bottom, Pos.CENTER);

		Scene scene = new Scene(bPane);

		Stage stage = primaryStage;
		stage.setTitle("Layout");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
