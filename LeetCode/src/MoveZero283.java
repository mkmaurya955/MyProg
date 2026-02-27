class MoveZero283 {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
//		int temp;
//		int j = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] != 0) {
//				temp = nums[j];
//				nums[j] = nums[i];
//				nums[i] = temp;
//				j++;
//			}
//		}

//		for(int k = 0; k < nums.length;k++) {
//			System.out.println(nums[k]);
//		}
//	}
//  { 0, 1, 0, 3, 12 };
		int insert = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insert] = nums[i];
				insert++;
			}
		}

		// 1,3,12,3,12
		while (insert < nums.length) {
			nums[insert] = 0;
			insert++;
		}
		for (int k = 0; k < nums.length; k++) {
			System.out.println(nums[k]);
		}

	}

}
