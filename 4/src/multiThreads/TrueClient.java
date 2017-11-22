package multiThreads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TrueClient {
	public static final int PORT = 2000;
	
	public static void main(String[] args) throws IOException {
		InetAddress addr;
		if (args.length >= 1)
			addr = InetAddress.getByName(args[0]);
		else
			addr = InetAddress.getByName(null);
		Socket socket = new Socket(addr, PORT);
		System.out.println("The new socket: " + socket);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
		BufferedReader kbd_reader = new BufferedReader(new InputStreamReader(System.in));
		ServerListener t = new ServerListener(in);
		t.start();
		String buf;
		while (true) {
			buf = kbd_reader.readLine();
			System.out.println("User input: " + buf);
			System.out.println("To server: " + buf);
			out.println(buf);
		}
	} //main
}
