package multiThreads;

import java.io.BufferedReader;
import java.io.IOException;

final class ServerListener extends Thread {
	final private BufferedReader fromServer;
	
	public ServerListener(BufferedReader fromServer) {
		this.fromServer = fromServer;
		}
	
	public void run() {
		String lineFromServer;
		try {
			while ((lineFromServer = fromServer.readLine()) != null && !lineFromServer.equals("quit")) {
				System.out.println("From server: " + lineFromServer);
			}
		} catch (IOException e) { 
			System.out.println("An IO Exception happened when listening to the server..."); 
		}
	} //run
}

