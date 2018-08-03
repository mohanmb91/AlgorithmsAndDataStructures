package mostSubTreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    static Map<Integer, Integer> results;
    static int maxCount = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        results = new HashMap<Integer, Integer>();
        findFrequentTreeSumHelper(root);
        List<Integer> nos = new ArrayList<Integer>();
        for(int current: results.keySet()){
            if(results.get(current) == maxCount){
                nos.add(current);
            }
        }
        return nos.stream().mapToInt(i -> i).toArray();
    }
    
    public int findFrequentTreeSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = 0;
        sum += findFrequentTreeSumHelper(root.left);
        sum += root.val;
        sum += findFrequentTreeSumHelper(root.right);
        results.put(sum,results.getOrDefault(sum, 0)  + 1);
        maxCount = Math.max(maxCount, results.get(sum));
        return sum;
    }
}