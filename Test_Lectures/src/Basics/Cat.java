package Basics;

public class Cat extends Animal{

	public Cat() {
		super();
		this.setName("A cat");
	}
	public Cat(String name) {
		super(name);
	}

	@Override
	public String makeSound() {
		
		return "Meow";
	}
	
	

}
