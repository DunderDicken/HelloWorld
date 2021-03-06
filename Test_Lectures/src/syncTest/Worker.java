package syncTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private static Random random = new Random();

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<Integer> list2 = new ArrayList<Integer>();

	// Methods:
	public static void stageOne() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}

	}

	public static void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));

		}

	}

	public static void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) {
		System.out.println("Worker. Starting . ..");

		double start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Oooopsie Daysiee!");
		}

		double end = System.currentTimeMillis();

		System.out.println("TIme taken:  " + (end - start) + "  (Seconds: " + ((end - start) / 1000) + " )");
		System.out.println("List1 size: " + list1.size() + "; list2:  " + list2.size());

	}

}
