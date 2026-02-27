package multithreading;

public class FirstMultiThreadingProgram extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<10 ;i++) {
			System.out.println("From Child method MultiThreading Program..!!"+i);
		}
	}
	
	public static void main(String [] args) {
		FirstMultiThreadingProgram t = new FirstMultiThreadingProgram();
		t.start();
		for(int i =0; i<10 ;i++) {
			System.out.println("From Main method MultiThreading Program..!!"+i);
		}
	}

}
