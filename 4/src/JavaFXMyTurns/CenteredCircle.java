package JavaFXMyTurns;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * This is the property binding example on page 80 of the book K. Sharan. Learn JavaFX 8. Building User Experience and Interfaces with Java 8
 * Apress.
 * @author fkl
 *
 */

public class CenteredCircle extends Application {

	public static void main (String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle c = new Circle();
		Group root = new Group(c);
		Scene scene = new Scene(root,200,200);

		c.centerXProperty().bind(scene.widthProperty().divide(2));
		c.centerYProperty().bind(scene.heightProperty().divide(2));
		c.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(2)));
		
		
		stage.setTitle("Binding in JavaFX");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}



}
