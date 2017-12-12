package fxTraining;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;

public class SliderTest extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	Stage stage;
	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		Label lbl = new Label("This is GROoooot");
		Slider slider = new Slider(10, 90, 20);
		slider.valueProperty().addListener(property -> lbl.setFont(new Font(slider.getValue())));

		Button smaller = new Button("Smaller");
		Button bigger = new Button("Bigger");
		Rectangle gauge = new Rectangle(0,5,50,15);
		Rectangle outline = new Rectangle(0,5,100,15);
		outline.setFill(null);
		outline.setStroke(Color.AQUA);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(slider,lbl);
		
			
		scene = new Scene(vbox, 300, 200);
		stage.setScene(scene);
		stage.show();
		
	}


}
