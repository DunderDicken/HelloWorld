package reallyBasic;

public enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;

	public static int eval(Operation op, int arg1, int arg2) {
		int result = 0;
		
		switch (op) {
		case ADD: result = arg1 + arg2;
		case SUBTRACT: result = arg1 - arg2;
		case MULTIPLY: result = arg1 * arg2;
		case DIVIDE: result = arg1 / arg2;
		}
		return result;

	}
}