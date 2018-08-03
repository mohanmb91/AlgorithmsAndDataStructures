package leetcode75.third;

import java.util.HashMap;

class Solution {
    public static double champagneTower(int poured, int qr, int qg) {
        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        for(int i = 0;i < 100;i++){
        	for(int j = 0;j <= i;j++){
        		if(dp[i][j] > 1){
        			if(i < 99){
	        			dp[i+1][j] += (dp[i][j] - 1)/2;
	        			dp[i+1][j+1] += (dp[i][j] - 1)/2;
        			}
        			dp[i][j] = 1;
        		}
        	}
        }
        return dp[qr][qg];
    }
   public static void main(String args[]) {
    		System.out.println(champagneTower(8, 3, 2));
    }
}