package Fundamental;

public class LocalVariable {

	public void MethodOne() {
		int a = 10;
		System.out.println("Local Variable.."+a);
	}
	
	public static void main(String[] args) {
//		System.out.println("Direct call.." +a);a cannot be resolved to a variable
		LocalVariable lv = new LocalVariable();
		lv.MethodOne();
	}
}
