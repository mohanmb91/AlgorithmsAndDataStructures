package leetcode77fourth;

import java.util.Arrays;

public class Solution {
	 public boolean splitArraySameAverage(int[] A) {
	        Arrays.sort(A);
	        int n = A.length;
	        boolean found = false;
	        int lsum = 0;
	        for (int i = 0; i < n-1; i++)
	        {
	            lsum += A[i];
	            int rsum = 0;
	            for (int j = i + 1; j < n; j++)
	                rsum += A[j];

	            if (lsum*(n-i-1) == rsum*(i+1))
	            {
	                found = true;
	            }
	        }
	        return found;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution ob = new Solution();
		ob.splitArraySameAverage(new int[] {1,2,3,4,5,6,7,8});
	}

}
