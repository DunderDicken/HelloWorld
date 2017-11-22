package test;

import java.awt.BorderLayout;
import java.awt.Button;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;



public class JavaFXTest {

	public class BoringWindow extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public BoringWindow() {
			this.setTitle("Hello World Window TITLE");
			this.setSize(350,550);
			
			Container cp = getContentPane();
			cp.setLayout(new BorderLayout());
			JButton b = new JButton("Say Hello World!");
			b.addActionListener(ae -> {System.out.println("Hello World!");} );
			
			cp.add(b, BorderLayout.CENTER);
			this.setVisible(true);
		}
	}
	


	public static void main(String[] args) {
		
		JavaFXTest fx = new JavaFXTest();
		
		fx.new BoringWindow();

	}

}
