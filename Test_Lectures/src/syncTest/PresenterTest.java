package syncTest;

public class PresenterTest extends Thread {
	private String name;
	private int sleepTime;
	private int steps;

	public PresenterTest(String name, int sleepTime) {

		this.name = name;
		this.sleepTime = sleepTime;
		this.steps = 0;
	}

	@Override
	public void run() {
		doTenLoops();

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			System.out.println("Sombody woke me up!");
			e.printStackTrace();
		}
	}

	private synchronized void doTenLoops() {

		for (int i = 0; i < 10; i++) {
			printNumOfSteps();

			System.out.println(this.name);
			this.steps++;
		}
	}

	private synchronized void printNumOfSteps() {
		for (int i = 0; i < this.steps; i++) {
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {

		PresenterTest t1 = new PresenterTest("First", 1000);
		PresenterTest t2 = new PresenterTest("Second", 2000);
		t1.start();
		t2.start();
		
		
	}

}
