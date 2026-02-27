package Fundamental;

public class VarArg {
	int total = 0;
	float tot =0.0f;
	double tot1 = 0.0;
	public void sumVal3(int... a) {
		for(int val : a) {
			total = total +val;
		}
		System.out.println("Sum..." +total);
	}

	public void sumVal1(float ...a) {
		for(float b :a) {
			tot = tot +b;
		}
		System.out.println("Float..."+ tot);
	}

	public void sumVal2(double...a) {
		for(double d :a) {
			tot1 = tot1+d;
		}
		System.out.println("Double..."+tot1);
	}

	public static void main(String[] args) {
		
		VarArg va = new VarArg();
		va.sumVal3(new int[]{10,20,30});
		va.sumVal1(new float[]{10.00f,20.90f,30.50f});
		va.sumVal2(new double[]{10.89,20.97,30.56});

	}

}
