package reallyBasic;

public class InterfaceTest implements fourNumbers {

	enum Size{SMALL, MEDIUM, BIG};
	
	public double d1(double d) {
		System.out.println("d1: ");
		return 1;
	}

	
	public double d2(double d) {
		System.out.println("d2: ");
		return 2;
	}


	public double d3(double d) {
		System.out.println("d3: ");
		return 3;
	}

	
	public double d4(double d) {
		System.out.println("d4: ");
		return 4;
	}
	
	public static void main(String[] args) {
		double d = 0;
		for(Size s : Size.values()) {System.out.println(s);}
		for(Operation o : Operation.values()) {System.out.println(o);}
		

		
		InterfaceTest test = new InterfaceTest();
		
		System.out.println(test.d1(d));
		System.out.println(test.d2(d));
		System.out.println(test.d3(d));
		System.out.println(test.d4(d));
	}
}
