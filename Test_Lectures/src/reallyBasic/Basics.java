package reallyBasic;

public class Basics {

	private int numberOfPrints;
//	Constant names: all upper case, separating words by ”_”:
//	DAYS_IN_WEEK
	
	 public int getNumberOfPrints() {
		return numberOfPrints;
	}

	public void setNumberOfPrints(int numberOfPrints) {
		this.numberOfPrints = numberOfPrints;
	}

	public static final int DAYS_IN_WEEK = 7;

	/* Methods: mixed letter names, start with lower case letter;
	 get and set for getter and setter methods*/
	 
	 public void printConstant() {
		 setNumberOfPrints(numberOfPrints + 1);
		 System.out.println(DAYS_IN_WEEK + " Number of prints: " + this.getNumberOfPrints());
	 }
	 
	public static void main(String[] args) {

		Basics num = new Basics();
		num.printConstant();
		num.printConstant();
		num.printConstant();
		num.printConstant();
		
	}

}
