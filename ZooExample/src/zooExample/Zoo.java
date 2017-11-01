package zooExample;

public class Zoo {

	public static void main (String[] args) {
		Bird tweety = new Bird("Tweety", 3, 10);
		//tweety.eat("corn");
		//tweety.fly();

		Fish bubbles = new Fish("Bubbles", 13, 100);
		//bubbles.eat("fish food");
		//bubbles.swim();

		Animal w = new Fish("Willy", 4000, 1000);
		//w.eat("Tourists");
		//w.swim();
		//((Fish) w).swim();
		
		Animal DuckBeaver = new Animal("DuckBeaver", 10);
		Circus.present(DuckBeaver);

		Circus.present(w);
		Circus.present(bubbles);
		Circus.present(tweety);



	}

}
