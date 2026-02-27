package Fundamental;

public class InstanceVariable {
	
	
	int a = 20;
	int b;
	public void methodOne() {
		System.out.println("From Method.." + a);
		System.out.println("From Method.." + b);//Default value
	}
	
	public static void main(String[] args) {
		
//		System.out.println("Instance Val"+ a);Cannot make a static reference to the non-static field a
		
		InstanceVariable iv = new InstanceVariable();
		System.out.println("Instance Variable.."+ iv.a);
		System.out.println("Instance Variable.."+ iv.b);//Default value
		iv.methodOne();
	}

}
