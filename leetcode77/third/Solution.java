package leetcode77.third;

import java.util.HashMap;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        HashMap<Integer, Integer> maxRow = new HashMap<>();
        HashMap<Integer, Integer> maxCol = new HashMap<>();
        for(int i=0; i <grid.length; i ++){
        		int maxRowValue = Integer.MIN_VALUE;
            for(int j=0; j < grid[i].length; j ++){
            		maxRowValue = grid[i][j] > maxRowValue?  grid[i][j]: maxRowValue;
                if(maxCol.containsKey(j)) {
                		if(grid[i][j] > maxCol.get(j)) {
                			maxCol.put(j, grid[i][j]);
                		}
                }else {
                		maxCol.put(j, grid[i][j]);
                }
            }
            maxRow.put(i, maxRowValue);
        }
        int result = 0;
        for(int i=0; i <grid.length; i ++){
        	  for(int j=0; j < grid[i].length; j ++){
        		  int limit = Math.min(maxRow.get(i), maxCol.get(j));
        		  if(grid[i][j] < limit) {
        			  result += Math.abs(limit - grid[i][j]);
        		  }
        	  }
        }
        return result;
    }
	public static void main(String[] args) {
		int gridNew[][] =new int [][]{
			{3, 0, 8, 4}, 
		    {2, 4, 5, 7},
		    {9, 2, 6, 3},
		    {0, 3, 1, 0}
	    };
	    Solution ob = new Solution();
	    ob.maxIncreaseKeepingSkyline(gridNew);
	}

}
