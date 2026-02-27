package Fundamental;

public class Program1 {
	
	public static void main(String [] manish) {
		System.out.println(sum(new int[]{10,20,30}));
	}
	static int total = 0;
	public static int sum(int[] is) {
		for(int val : is) {
			total = total+val;
		}
		return total;
		
	}

}
