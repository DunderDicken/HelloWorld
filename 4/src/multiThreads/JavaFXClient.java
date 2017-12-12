
package multiThreads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXClient extends Application {

	public static final int PORT = 2000;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	BufferedReader kbd_reader;

	Label label = new Label("????");

	MessageProperty lastMessage = new MessageProperty();

	class MessageProperty {
		private SimpleStringProperty message = new SimpleStringProperty();

		public final String getMessage() {
			return message.get();
		}

		public final void setMessage(String value) {
			message.set(value);
		}

		public SimpleStringProperty messageProperty() {
			return message;
		}
	}

	private class OutputSetter implements Runnable {
		private String textToSet;

		public OutputSetter(String t) {
			this.textToSet = t;
		}

		@Override
		public void run() {
			label.setText(textToSet);
		}
	}

	// THIS IS THE METHOD TO BE CHANGED ......

	private class ServerListener extends Thread {
		public void run() {
			String lineFromServer;
			try {
				while ((lineFromServer = in.readLine()) != null && !lineFromServer.equals("quit")) {
					System.out.println("From server: " + lineFromServer);

					// here is the space for dealing the incoming data...
					// You want to update the Label label, but how?
					// have a look at the OutputSetter class....

					// Thread t = new Thread(new OutputSetter(lineFromServer));
					// Platform.runLater(t);
					//
					// OutputSetter out = new OutputSetter(lineFromServer);
					// Platform.runLater(out);

					Platform.runLater(new OutputSetter(lineFromServer));

				}
			} catch (IOException e) {
				System.out.println("Exception captured: " + e);
			}
		}
	} // class ServerListener

	private void setupClientConnection() {
		InetAddress addr;
		try {
			addr = InetAddress.getByName(null);
			Socket socket = new Socket(addr, PORT);
			System.out.println("the new socket: " + socket);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			kbd_reader = new BufferedReader(new InputStreamReader(System.in));
			ServerListener t = new ServerListener();
			t.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primStage) throws Exception {

		setupClientConnection();

		Group root = new Group();
		Scene scene = new Scene(root);
		primStage.setTitle("JavaFX Client");
		primStage.setWidth(280);
		primStage.setHeight(150);

		Button insultButton = new Button("Insult");
		insultButton.setOnAction(ae -> {
			out.println("You ratpack!");
		});

		Button praiseButton = new Button("Praise");
		praiseButton.setOnAction(ae -> {
			out.println("You are the best!");
		});

		VBox vbox = new VBox();
		vbox.setLayoutX(20);
		vbox.setLayoutY(20);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();

		hbox1.getChildren().add(insultButton);
		hbox1.getChildren().add(praiseButton);
		hbox1.setAlignment(Pos.BOTTOM_LEFT);
		hbox1.setSpacing(10);

		hbox2.getChildren().add(label);
		hbox2.setAlignment(Pos.BOTTOM_LEFT);

		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		vbox.setSpacing(10);

		root.getChildren().add(vbox);

		primStage.setScene(scene);
		primStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
