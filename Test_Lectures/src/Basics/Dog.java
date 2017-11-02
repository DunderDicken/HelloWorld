package Basics;

public class Dog extends Animal{
	public Dog() {
		super();
	}
	public Dog(String name) {
		super(name);
	}

	@Override 
	public String makeSound() {
		return "Woff";
	}
}
