package Fundamental;

public class StaticVariable {
	
	static int a = 30;
	static int b;
	public static void main(String[] args) {
		System.out.println("Static Variable.." +a);
		System.out.println("Static Variable.." +b);// default value
		StaticVariable sv = new StaticVariable();
		System.out.println("From Object Creation.."+sv.a);
		System.out.println("From Object Creation.."+sv.b);//default value
	}


}
