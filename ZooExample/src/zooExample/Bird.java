package zooExample;

public class Bird extends Animal {
	private int maxAltitude;
	
	public Bird (String n, int w, int a) {
		super(n, w);
		maxAltitude = a;
	}
	
	public void fly () {
		System.out.println(name + " flies!");
	}
	
	@Override
	public void eat (String food) {
		System.out.println(name + " flutters its wings.");
		super.eat(food);
	}
	
	public void actOut() {
		System.out.println(name +  " fly away, because it's a bird.");
	}

}
