package threads;

public class Presenter extends Thread {
	private String msg;
	private int sleepTime;
	private int steps;

	public Presenter(String message, int dur) {
		synchronized (this) {
			this.msg = message;
			this.sleepTime = dur;
			this.steps = 0;
			this.start();
		}

	}

	@Override
	public void run() {
		// while (true) {
		synchronized (this) {
			for (int z = 0; z < 10; z++) {
				for (int i = 0; i < this.steps; i++) {
					System.out.print(" ");
				}

				this.steps++;

				System.out.println(this.msg);
			}
			try {
				Thread.sleep((this.sleepTime * 1000));
			} catch (InterruptedException e) {
				System.out.println("Sombody woke me up!");

			} // catch
		}
	}// run

	public static void main(String[] args) {
//		double start = System.currentTimeMillis();

		Presenter t1 = new Presenter("FirstThread", (int) 0.1);
		Presenter t2 = new Presenter("SecondThread", (int) 0.5);
		Presenter t3 = new Presenter("ThirdThread", (int) 0.9);

		// Check time taken:
//		try {
//			t1.join();
//			t2.join();
//			t3.join();
//		} catch (InterruptedException e) {
//			System.out.println("Errror in main");
//			e.printStackTrace();
//		}
//
//		double end = System.currentTimeMillis();
//		System.out.println("Time Taken:  " + (end - start));

	}
}
