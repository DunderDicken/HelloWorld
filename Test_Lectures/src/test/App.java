package test;
interface Runable{
	void run();
	
}

class Machine {
	protected void start(Runable r) {
		System.out.println("starting machine");
		r.run();
	}

}

public class App {

	public static void main(String[] args) {

		Machine mc1 = new Machine();
		mc1.start(new Runable(){
			public void run(){
			System.out.println("running");
		}
		});

//		Machine mc2 = new Machine() {
//			protected void start() {
//				System.out.println("Starting machine 2");
//			}
//		};
		Machine mc2 = new Machine();
		mc2.start(() -> System.out.println("running 2"));

	}

}
