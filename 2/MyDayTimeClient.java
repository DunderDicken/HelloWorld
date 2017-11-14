import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

//public class MyDayTimeClient {
//	public static final int PORT = 1337;
//
//	public static void main(String[] args) throws IOException {
//		InetAddress address = InetAddress.getByName(null);
//
//		Socket socket = new Socket(address, PORT);
//		System.out.println("Client socket: " + socket);
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//		String fromServer = in.readLine();
//		System.out.println(fromServer);
//		socket.close();
//
//	}
//
//}

public class MyDayTimeClient {
	public static final int PORT = 1337;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InetAddress address = InetAddress.getByName(null);

		Socket socket = new Socket(address, PORT);
		System.out.println("Client socket: " + socket);

		ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());

		Date now = (Date) inObj.readObject();

		System.out.println(now);
		socket.close();

	}

}