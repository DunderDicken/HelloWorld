import java.io.IOException;
import java.net.*;
public class MyIPAdress {

	public static void main(String[] args) throws IOException {
		try {
			
			
			InetAddress you = InetAddress.getByName("www.oru.se");
			if(you.isReachable(10)) {
				System.out.println("REACHABLE!");
			}
				
			System.out.println(you);
			System.out.println(you.getHostName());
			System.out.println(you.getHostAddress());
			
			InetAddress me = InetAddress.getLocalHost();
			//String dottedQuad = me.toString();
//			System.out.println(me.getHostName());
//			System.out.println(me.getHostAddress());
			
			System.out.println("My address is " + me.toString());
		} catch (UnknownHostException ex) {
			System.out.println("I'm sorry. I don't know my own address.");
		}
	}
}

