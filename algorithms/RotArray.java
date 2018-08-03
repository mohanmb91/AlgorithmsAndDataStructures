package algorithms;


class RotArray {
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, nums.length -1);
		reverse(nums, 0, k -1);
		reverse(nums, k, nums.length -1);
	}
	
	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start ++;
			end --;
		}
	}

	public static void main(String args[]) {
		rotate(new int[] {1,2,3,4,5,6,7,8,9}, 3);
	}
}


