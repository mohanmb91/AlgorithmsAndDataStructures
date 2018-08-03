package mssEqualsK;

import java.util.HashMap;

public class Solution {
	public static int maxSubArrayLen(int[] nums, int k) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int max = 0;
	    int sum=0;
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	 
	        if(sum==k){
	            max = Math.max(max, i+1);
	        }  
	 
	        int diff = sum-k;
	 
	        if(map.containsKey(diff)){
	            max = Math.max(max, i-map.get(diff));
	        }
	 
	        if(!map.containsKey(sum)){
	            map.put(sum, i);
	        }
	    }
	    return max;
	}
	
	/*
		1, 0	     0,1     3,2     7, 3      4,4     7,5  14,6     7,7
		
	*/
	public static void main(String args[]) {
		maxSubArrayLen(new int[] {1, -1, 3, 4, -3, 3, 7, -7}, 7);
	}
}
