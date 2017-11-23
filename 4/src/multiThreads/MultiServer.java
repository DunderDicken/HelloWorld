package multiThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	
	public static final int PORT = 2000;
	
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server socket: " + s);
		System.out.println("Server listening...");
		try { while(true) {
			// Blocks until a connection occurs:
			Socket socket = s.accept();
			System.out.println("Connection accepted.");
			System.out.println("The new socket: " + socket);
			try {
				ClientThread t = new ClientThread(socket);
				System.out.println("New thread started.");
				System.out.println("The new thread: " + t);
				}
				catch(IOException e) {
					// If the constructor fails, close the socket,
					// otherwise the thread will close it:
					socket.close();
				}
			} 
		} //catch, while, try
		finally { s.close(); }
		} //main
	} //MultiServer
