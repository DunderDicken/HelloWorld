

import java.net.*;
import java.io.*;

public class LowPortScanner {
	public static void main(String[] args) {
		//String host = args.length > 0 ? args[0] : "localhost";
		String host = "localhost";
		for (int i = 10; i < 1024; i++) {
			try {
				// try to open a socket at host and port
				// if no exception, then printout that there is a server
				// and close the socket again
				// when you have done this, the error messages will disappear
				
				Socket s = new Socket(host,i);
				System.out.println("Found a server! " + s.getInetAddress() + 
						" on port: " + s.getPort() + " from port : " + s.getLocalPort() 
						+ " on: " + s.getLocalAddress());
				
				s.close();
				
				if(s.isClosed()) {
					System.out.println("s is closed!");
				}else {
					System.out.println("s is NOT closed!");
				}


			} catch (UnknownHostException ex) {
				System.err.println(ex);
				break;
			} catch (IOException ex) {
				System.out.println("There must be no server on port " + i + " of "
						+ host);

			}
		
		}
	}
}
