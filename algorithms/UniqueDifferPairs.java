package algorithms;

import java.util.Arrays;

public class UniqueDifferPairs {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length < 2){
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] + nums[1] == k){
                return 1;
            }
        }
        int left, right, diff, count;
        left = right = diff = count = 0;
        right++;
        while(right < nums.length){
            diff = Math.abs(nums[left] - nums[right]);
            if(diff == k){
                count ++;
                left ++;
                if(left == right) {
                		right ++;
                }
            }else if (diff > k){
                left ++;
            }else{
                right ++;
            }
            while(right < nums.length && nums[left] == nums[right]){
            	left++;
                right ++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPairs(new int[] {1,1,1,2,2}, 1));
	}

}
