import java.util.Arrays;

public class AddTwoNumber {

	public int[] twoSum(int[] nums, int target) {

		int k = 0;
		int[] m = new int[2];
		for (int i = 0; i <= nums.length; i++) {
			for (int j = i + 1; j <= nums.length - 1; j++) {
				if ((nums[i] + nums[j]) == target) {
					m[k] = i;
					k++;
					m[k] = j;
				}
			}
		}
		return m;


	}
	
	public static void main(String[] args) {
		AddTwoNumber addTwo =  new AddTwoNumber();
		int[] m = {2,7,11,15};
		System.out.println(Arrays.toString(addTwo.twoSum(m, 9)));
	}

}
