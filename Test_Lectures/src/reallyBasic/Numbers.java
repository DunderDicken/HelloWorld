package reallyBasic;

public class Numbers {
	private int integers;
	private double doubles;

	public Numbers(int n, double d) {
		this.integers = n;
		this.doubles = d;
	}

	public int getIntegers() {
		return integers;
	}

	public void setIntegers(int integers) {
		this.integers = integers;
	}

	public double getDoubles() {
		return doubles;
	}

	public void setDoubles(double doubles) {
		this.doubles = doubles;
	}
}
