package multithreading;

public class OverLoadingRunMethod extends Thread{
	
	public void run() {
		for(int i =0; i<5;i++) {
			System.out.println("Child Thread..!!");
		}
	}
	
	public void run(int j) {
		System.out.println("This is overrriding run method..!!");
	}
	
	public static void main(String[] args) {
		OverLoadingRunMethod ovrLoadingRun = new OverLoadingRunMethod();
		ovrLoadingRun.start();
	}
	
}
