package mindiffBST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
	public int minDiffInBST(TreeNode root) {
        Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        frontier.add(root);
         
        int minDiff = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
        while(!frontier.isEmpty()){
            TreeNode parent = frontier.poll();
             if(parent.left != null){
            	 	list.add(parent.left.val);
            	 	frontier.add(parent.left);
            }
            if(parent.right != null){
            		list.add(parent.right.val);
    				frontier.add(parent.right);
            }
        }
        Collections.sort(list);
        for(int i=0; i < list.size() - 1; i ++) {
        		if(minDiff > Math.abs(list.get(i) - list.get(i+1))) {
        			minDiff = Math.abs(list.get(i) - list.get(i+1));
        		}
        }
        return minDiff;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
