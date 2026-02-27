import java.util.Arrays;

public class AddTwoNumber1 {
	public int[] twoSum(int[] nums, int target) {

		for (int i = 0; i <= nums.length; i++) {
			for (int j = i + 1; j <= nums.length - 1; j++) {
				if ((nums[i] + nums[j]) == target) {

					return new int[] { i, j };
				}
			}
		}
		return null;

	}

	public static void main(String[] args) {
		AddTwoNumber1 addTwo = new AddTwoNumber1();
		int[] m = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(addTwo.twoSum(m, 9)));
	}

}
