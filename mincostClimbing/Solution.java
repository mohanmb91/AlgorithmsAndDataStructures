package mincostClimbing;

class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1});
	}

}
