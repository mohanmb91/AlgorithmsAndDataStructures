package leetcode83Third;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
	boolean ok(int d, int n)
	{
		int u = n/d;
		int a = u-d+1;
		if(a % 2 != 0)return false;
		return a > 0;
	}
	
	 static int countConsecutive(int N)
	    {
	        // constraint on values of L gives us the 
	        // time Complexity as O(N^0.5)
	        int count = 0;
	        for (int L = 1; L * (L + 1) < 2 * N; L++)
	        {
	            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
	            if (a-(int)a == 0.0) 
	                count++;        
	        }
	        return count+1;
	    }
	     

	public static void main(String[] args) {
		Solution ob = new Solution();
		countConsecutive(9);

	}

}

// int start, end, result, sum;
//start = end = result = sum = 0;
//while(end < n){
//    sum += num[end];
//    if(sum == N){
//        result += 1;
//    }
//    if(sum > N){
//        while(sum > N){
//           sum -= num[start]; 
//            start ++;
//        }
//        if(sum == N){
//            result += 1;
//        }
//    }
//    end ++;
//}
