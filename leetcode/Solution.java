package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {  
                public int compare(Integer w1, Integer w2) {
                    return w1.compareTo(w2);  
                }      
            });  
        
        for(int i=0; i < nums.length; i ++){
            pQueue.add(nums[i]);
            if(pQueue.size() > k){
            		pQueue.poll();
            }
        }
        
        Object[] arr = pQueue.toArray();
        // arr[];
        
        return Integer.parseInt(arr[arr.length - k].toString());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findKthLargest(new int[] {3,2,1,9,8,7}, 4);
	}

}
