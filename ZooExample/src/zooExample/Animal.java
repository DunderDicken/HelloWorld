package zooExample;

public class Animal implements CanDoTricks {
	
	protected String name;
	private int weight;

	public Animal (String n, int w) {
		name = n;
		weight = w;
	}

	public void eat (String food) {
		System.out.println(name + " eats some " + food + ".");
		weight += 0.5;
	}

	public void actOut() {
		System.out.println(name +  " is sad, as it can do nothing.");
	}

}

