package contest81.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
    	Arrays.sort(words, (a, b) -> b.length() - a.length());
    	StringBuilder result = new StringBuilder("");
    	HashMap<String, Integer> comboWithIndex = new HashMap<String, Integer>();
        for(int i=0; i < words.length; i ++){
            String eachWord = words[i];
        	if(!comboWithIndex.containsKey(eachWord)) {
	        	HashMap<String, Integer> temp = new HashMap<String, Integer>();
	            int c =0; 
	            while(c < eachWord.length()) {
	            	Set<String> keysets = temp.keySet();
	            	HashMap<String, Integer> temp1 = new HashMap<String, Integer>();
	            	for(String k: keysets) {
	            		int index = temp.get(k) + k.length() - 1;
	            		if(index == (c -1) ) {
	            			temp1.put(k + eachWord.charAt(c), temp.get(k));
	            		}
	            	}
	            	temp1.forEach((k,v)->{
	            		temp.put(k, v);
		            });
	            	temp.put(eachWord.charAt(c) + "" , c);
	            	c ++;
	            }
	            temp.forEach((k,v)->{
	            	comboWithIndex.put(k, v);
	            });
	            result.append(eachWord+ "#");
        	}
        }
        return result.toString().length();
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		s.minimumLengthEncoding(new String[] {"time", "me", "bell"});
	}

}
