package Basics;

import java.util.Scanner;

public class Animal {
	/*
	 * Public - alla har tillgång; Static - delat med alla Animal objects; final -
	 * konstant;
	 */

	public static final double FAVNUMBER = 1.68;

	// private - only other methods in the class
	private String name;
	private int weigth;
	private boolean hasOwner = false;
	private byte age;
	private long uniqueID;
	private char favoriteChar;
	private double speed;
	private float height;

	// protected - only code in the package
	protected static int numberOfAnimals = 0;

	static Scanner userInput = new Scanner(System.in);

	public Animal() {
		numberOfAnimals++;
		this.name = "Animal name ";

//		System.out.println("Enter a name: ");
//		if (userInput.hasNextLine()) {
//			// hasNextInr - nextInt
//			this.setName(userInput.nextLine());
//		}
//		System.out.println("Enter a weigth: ");
//		if (userInput.hasNextInt()) {
//			// hasNextInr - nextInt
//			this.setWeigth(userInput.nextInt());
//		}

		this.setUniqueID();
		this.setFavoriteChar();
	}
	public Animal(String name) {
		numberOfAnimals++;
		this.name = name;
		this.setUniqueID();
		this.setFavoriteChar();
	}
	
	public Animal(String name, int weigth, boolean hasOwner, byte age, double speed, float height) {
		numberOfAnimals++;
		this.name = name;
		this.weigth = weigth;
		this.hasOwner = hasOwner;
		this.age = age;
		this.speed = speed;
		this.height = height;
		
		this.setUniqueID();
		this.setFavoriteChar();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public boolean isHasOwner() {
		return hasOwner;
	}

	public void setHasOwner(boolean hasOwner) {
		this.hasOwner = hasOwner;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public long getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(long uniqueID) {
		this.uniqueID = uniqueID;
		System.out.println("Unique ID set to: " + this.uniqueID);
	}

	public void setUniqueID() {
		long minNumber = 1;
		long maxNumber = 1000000;

		this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));
		System.out.println("Unique ID set to: " + this.uniqueID);
	}

	public char getFavoriteChar() {
		return favoriteChar;
	}

	public void setFavoriteChar(char favoriteChar) {
		this.favoriteChar = favoriteChar;
	}

	public void setFavoriteChar() {
		int randomNumber = (int) (Math.random() * 126) + 1;
		this.favoriteChar = (char) randomNumber;

		if (randomNumber == 32) {
			System.out.println("Favorite char set to Space");
		} else if (randomNumber == 10) {
			System.out.println("Favorite char set to New line");
		} else if ((randomNumber > 97) && (randomNumber < 122)) {
			System.out.println("Favorite Char is a lowercase letter");
		}else if (((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber > 64) && (randomNumber < 91))) {
			System.out.println("Favorite Char is a letter");
		}else if(randomNumber == 8){
			System.out.println("Favorite char set to backspace");	
		}else {
			System.out.println("Favorite Char set to: " + this.favoriteChar);
		}
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	protected static void countTo(int startingNum) {

		for (int i = startingNum; i <= 100; i++) {

			if (i == 90)
				continue; // Hoppa ur
			System.out.println(i);
		}
	}

	protected static String printNumbers(int maxNUmbers) {
		int i = 1;

		while (i < (maxNUmbers / 2)) {
			System.out.println(i);
			i++;

			if (i == (maxNUmbers / 2))
				break;
		}

		Animal.countTo(maxNUmbers / 2);

		return "End of printNumbers";
	}

	protected static void guessMyNumbers() {
		int num;
		
		do {
			System.out.println("Guess NUmber 1 - 100");
			
			while(!userInput.hasNextInt()) {
				String numberEntered = userInput.next();
				System.out.printf("%s is not a number. \n", numberEntered);
			}
			num = userInput.nextInt();
		} while (num != 50);
	}
	
	//Polymorphis:
	public String makeSound() {
		return "Grrrr";
	}
	
	public static void speakAnimal(Animal randAnimal) {
		System.out.println("Animal says: " + randAnimal.makeSound());
	}
	
	public static void hasOwner(Animal randAnimal) {
		if(randAnimal.hasOwner) {
			System.out.println("I have a owner! says " + randAnimal.getName());
		}
		else {
			System.out.println("I'm sad, I have no owner.. says " + randAnimal.getName());
		}
	}
	
	public static void printStats(Animal animal) {
		System.out.printf(" Char: " + animal.getFavoriteChar() + "\n Age: " + animal.getAge() + "\n Height: " + animal.getHeight() + " \n Name: " + animal.getName() + "\n Speed: " + animal.getSpeed() + "\n ID: " + animal.getUniqueID() + "\n Weigth: " + animal.getWeigth() + "\n\n");
		
	}
	public static void main(String[] args) {

		System.out.println("numberOfAnimals" + numberOfAnimals);
		Animal theAnimal = new Animal();
		Animal doggi = new Dog("Doggie");
		Animal fido = new Dog();
		Animal fluffy = new Cat();
		Animal catty = new Cat("Cattie");
		Cat theCat = new Cat("The Cat");
		Cat theOneCat = new Cat();
		System.out.println("numberOfAnimals" + numberOfAnimals);
		
		Animal[] theAnimals = new Animal[10];
		
		theAnimals[0]= fido;
		theAnimals[1]= fluffy;
		theAnimals[2]= theAnimal;
		theAnimals[3]= doggi;
		theAnimals[4]= catty;
		theAnimals[5]= theCat;
		theAnimals[6]= theOneCat;
		
		for (int i = 0; i < theAnimals.length; i++) {
			if (theAnimals[i] != null) {
				speakAnimal(theAnimals[i]);
			}
			
		}
		System.out.println();
		
		for (int j = 0; j < theAnimals.length; j++) {
			
			if (theAnimals[j] != null) {
				System.out.println(theAnimals[j].getName() + " says: " + theAnimals[j].makeSound());
			}
		}
		
		printStats(doggi);
		printStats(catty);
		
	}

}
