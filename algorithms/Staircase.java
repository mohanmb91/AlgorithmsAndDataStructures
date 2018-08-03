package algorithms;

import java.util.HashMap;

public class Staircase {
	static HashMap<Integer, Integer> memoization = new HashMap<Integer, Integer>();
    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairsHelper(cost, -1);
    }
    public static int minCostClimbingStairsHelper(int[] cost, int index){
	    	if(memoization.containsKey(index)) {
	    		return memoization.get(index);
	    	}
	    	if(index == cost.length-1) {
	    		return cost[index];
	    	}
	    	if(index >= cost.length) {
	    		return 0;
	    	}
        int result = 0;
        
        int leftResult = minCostClimbingStairsHelper(cost, index + 1);
        int rightResult = minCostClimbingStairsHelper(cost, index + 2);
        result = Math.min(leftResult, rightResult);
        if(index != -1) {
        		result += cost[index];	
        }
        if(!memoization.containsKey(index)) {
        		memoization.put(index, result);
        }
        	return result;
    }
	
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int []{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
