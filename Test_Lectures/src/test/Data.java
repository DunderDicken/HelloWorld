package test;
import java.io.Serializable;
import java.util.Random;

public class Data implements Serializable {

	private int num;
	private String name = "A name: ";
	private int randNum;
	Random rand = new Random();
	
	public Data(int n) {this.num = n; this.randNum = (int) rand.nextInt(100);}
	@Override
	public String toString() { return this.name + Integer.toString(num) + "   " + Integer.toString(randNum) ;}
}
