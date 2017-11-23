package syncTest;

public class App {

	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10001; i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10001; i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			System.out.println("t1 and t2 finnished. Join.");
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		
		System.out.println("count is:  " + count);
	}
}
