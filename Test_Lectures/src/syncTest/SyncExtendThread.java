package syncTest;

public class SyncExtendThread extends Thread {

	private Integer count = 0;

	@Override
	public void run() {


			for (int i = 0; i < 100; i++) {

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.count = count + 1;
			}
		
	}

	public static void main(String[] args) {

		SyncExtendThread t1 = new SyncExtendThread();
		SyncExtendThread t2 = new SyncExtendThread();
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count: " + t1.count + ",  t2 count: " + t2.count);
	}

}
