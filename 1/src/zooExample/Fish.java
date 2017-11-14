package zooExample;

public class Fish extends Animal {
	
	private int maxDepth;
	
	public Fish (String n, int w, int d) {
		super(n,w);
		maxDepth = d;
	}
	
	public void swim() {
		System.out.println(name + " swims!");
	}
	
	public void actOut() {
		System.out.println(name +  " swims, because it's a fish.");
	}
	
}
