public class Calculator {
	interface IntegerMath {
		int operation (int a, int b);
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main (String[] args) {
		Calculator myApp = new Calculator();
		IntegerMath addition = (a,b) -> a + b;
		IntegerMath subtraction = (a,b) -> a - b;
		//Lambda class:
		IntegerMath division = (a,b) -> a / b;
		
		
		//Anonymous class from interface:
//		IntegerMath multiply = new IntegerMath() {
//			public int operation(int a, int b) {
//				return a*b;
//			}
//		};
		//Lambda: 
		IntegerMath multiply = (a,b) -> a * b;

		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
		System.out.println("20 / 10 = " + myApp.operateBinary(20, 10, division));
		System.out.println("10 * 10 = " + myApp.operateBinary(10, 10, multiply));

		// System.out.println("20 / 10 = " +
		//		... how would the it look like to use an anonymous class here???
		//);
		//test

	}
}
