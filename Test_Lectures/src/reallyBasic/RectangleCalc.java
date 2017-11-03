package reallyBasic;

import java.io.*;

public class RectangleCalc {
	private int a = 0, b = 0;
	
	public RectangleCalc(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int area() {
		return a*b;
	}
	
	public int circ() {
		return (2*a + 2*b);
	}
	
	
	public static void main(String[] args) {
		int a = 0, b = 0;
		String buf;

		BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

	
		try {
			System.out.println("Input side a: ");
			buf = keyboardReader.readLine();
			a = Integer.parseInt(buf);
			System.out.println("Input side b: ");
			buf = keyboardReader.readLine();
			b = Integer.parseInt(buf);

			System.out.println("Area: " + a * b);
			System.out.println("Circ: " + (2 * a + 2 * b));

		} catch (NumberFormatException | IOException e) {
			// TODO: handle exception
			
			System.out.println("ERRROR INPUT ERRROR!!!!!!" + e.getMessage());
		}
	}

}
