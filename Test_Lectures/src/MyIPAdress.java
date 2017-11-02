import java.net.*;
public class MyIPAdress {

	public static void main(String[] args) {
		try {
			InetAddress you = InetAddress.getByName("www.oru.se");
			System.out.println(you);
			
			InetAddress me = InetAddress.getLocalHost();
			//String dottedQuad = me.toString();
			
			System.out.println("My address is " + me.toString());
		} catch (UnknownHostException ex) {
			System.out.println("I'm sorry. I don't know my own address.");
		}
	}
}

