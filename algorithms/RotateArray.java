package algorithms;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int index = 0;
		int temp = -1;
		while(n-->0){
			int indexNew = index + k;
			indexNew = indexNew % nums.length;
			temp = nums[indexNew];
			nums[indexNew] = nums[index];
		}
	}
}
