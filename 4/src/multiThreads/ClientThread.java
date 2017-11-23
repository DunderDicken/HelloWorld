package multiThreads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


class ClientThread extends Thread {
	private static int numberOfClients = 0;
	private static ArrayList<ClientThread> allClients = new ArrayList<ClientThread>();
	private final int clientNumber = ++numberOfClients;
	private final Socket socket;
	private final BufferedReader in;
	private final PrintWriter out;

	public ClientThread(Socket s) throws IOException {
		socket = s;
		in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
		System.out.println("Client thread " + clientNumber +" created.");
		out.println("Welcome. You are client number " + clientNumber + ".");
		synchronized(this) {
			allClients.add(this);
		}
		// If any of the above calls throw an
		// exception, the caller is responsible for
		// closing the socket. Otherwise the thread
		// will close it.
		start(); //Starts the thread, and calls run()
	}
	
	public void run() {
		try {
			while (true) {
				String inline = in.readLine();
				System.out.println("Client thread " + clientNumber + " received: " + inline);
				if (inline == null || inline.equals("quit")) break;
				out.println("You said ’" + inline + "’");
				Iterator<ClientThread> i = allClients.iterator();
					while (i.hasNext()) {
						ClientThread t = i.next();
						if (t != this)
							t.out.println("From client " + clientNumber + ": " + inline);
					}	 
				} //while, while
			System.out.println("Client thread " + clientNumber + ": exiting...");
		}
		catch(IOException e) {
			System.out.println("Client thread " + clientNumber + ": I/O error");
		}
		finally {
			try { socket.close(); }
			catch(IOException e) {
				System.out.println("Client thread " + clientNumber + ": Socket not closed!");
			}
			synchronized(this) {
				allClients.remove(allClients.indexOf(this));
			}
		} //finally
	} //run
}