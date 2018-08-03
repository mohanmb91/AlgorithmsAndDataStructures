package leetcode83;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        char c = '\u0000';
        char p = '\u0000';
        int count = 0;
        int start = 0;
        int end = 0;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i=0; i<S.length(); i ++){
            c = S.charAt(i);
            if(c == p){
                count ++;
                end ++;
            }else{
                if(count >= 3){
                    List<Integer> result = new ArrayList<>();
                    result.add(start);
                    result.add(end);
                    results.add(result);
                }
                count = 0; 
                start = end = i;
                count++;
            }
            p = c;
        }
        if(start != end) {
        	  if(count >= 3){
		    	 List<Integer> result = new ArrayList<>();
		         result.add(start);
		         result.add(end);
		         results.add(result);
        	  }
        }
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.largeGroupPositions("aaa");
	}

}
