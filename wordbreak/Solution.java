package wordbreak;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean wordBreak(String s, List<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<>();
		input.add("leet");
		input.add("ode");
		wordBreak("leetcode", input);
	}

}
