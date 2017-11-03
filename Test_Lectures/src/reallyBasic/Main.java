package reallyBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	
	static Numbers[] num = new Numbers[3];
	public static void main(String[] args) {
		double values[] = {1.1,1.2,1.3};
		double sum = 0;
		//for(double v : values) {sum++; System.out.println("sum:" + sum); }
		for(double v:values)System.out.println(v);
		//System.out.println("Classic for: ");
		for (int i = 0; i < values.length; i++) {
			//System.out.println(values[i]);
		}
		
		num[0] = new Numbers(10,10);
		num[1] = new Numbers(20,20);
		num[2]= new Numbers(30,30);
		int summa = 0;
		for(Numbers n : num) {
			
			summa += n.getIntegers();
			//System.out.println(summa);
		}

	}
}
