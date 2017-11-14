package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


	
public class StreamApp {
	
	public static void main(String[] args)
	throws ClassNotFoundException, IOException{
		Data d1 = new Data(11);
		Data d2 = new Data(4711);
		Data d3 = new Data(815);
		
		ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("data.out"));
		
		out.writeObject(d1);
		out.writeObject(d2);
		out.writeObject(d3);
		out.close();
		
	ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.out"));
	
	Data d4 = (Data)in.readObject();
	Data d5 = (Data)in.readObject();
	Data d6 = (Data) in.readObject();
	
	Data[] dataArray = new Data[6];
	dataArray[0] = d1;
	dataArray[1] = d2;
	dataArray[2] = d3;
	dataArray[3] = d4;
	dataArray[4] = d5;
	dataArray[5] = d6;
	
	for(Data d : dataArray) System.out.println(d);
	}

}
