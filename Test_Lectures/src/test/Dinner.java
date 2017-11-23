package test;

public class Dinner {

	protected boolean coffepot = false;

	private void drinkCoffee() throws NoPotException {
		if (coffepot == false)
			throw new NoPotException("MSG: Missing a pot here");
		else {
			System.out.println("Drinking sweet coffeee");
		}
	}

	private void eatDinner() throws NoPotException {
		drinkCoffee();

	}

	public static void main(String[] args) {

		Dinner d = new Dinner();
		try {
			d.eatDinner();
		} catch (NoPotException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());

			System.out.println("NO POT OMG!");

		}

	}
}
