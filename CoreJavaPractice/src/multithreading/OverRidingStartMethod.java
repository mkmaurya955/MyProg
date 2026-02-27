package multithreading;

public class OverRidingStartMethod extends Thread{

	public void start() {
		System.out.println("Start method..!!");
	}
	
	public void run() {
		System.out.println("Run Method..!");
	}
	
	public static void main(String[] args) {
		OverRidingStartMethod m = new OverRidingStartMethod();
		m.start();
		System.out.println("main Method..!!");
	}
}
