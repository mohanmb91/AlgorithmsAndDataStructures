package algorithms;

import java.util.*;
public class Solution {
	public static List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList();
	        int[] patternHash = new int[128]; 
	        for (char c : p.toCharArray()) {
	            patternHash[c]++;
	        }
	        int start, end, count;
	        start = end = count = 0;
	        char inputChars[] = s.toCharArray();
	        while(end < s.length()) {
	        		char c = inputChars[end];
	        		if(patternHash[c] > 0){
	        			patternHash[c] -= 1;
	        			count ++;
	        		}else {
	        			if(count == 0) {
	        				start ++;
	        			}else {
	        				char ch = inputChars[start];
	        				patternHash[ch] += 1;
	        				start ++;
	        				end --;
	        				count --;
	        			}
	        		}
	        		if(count == p.length()) {
	        			result.add(start);
	        			count--;
        				char ch = inputChars[start];
        				patternHash[ch] += 1;
        				start ++;
	        		}
	        		end ++;
	        }
	        return result;
	    }
    
	
	
	  
    public static void main(String args[]) {
    	findAnagrams("abab","ab");
    }
}



//public static List<Integer> findAnagrams(String s, String p) {
//    List<Integer> list = new ArrayList<>();
//if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
//
//int[] hash = new int[256]; 
//
//for (char c : p.toCharArray()) {
//    hash[c]++;
//}
//int left = 0, right = 0, count = p.length();
//
//while (right < s.length()) {
//    if (hash[s.charAt(right)] >= 1) {
//        count--;
//    }
//    hash[s.charAt(right)]--;
//    right++;
//    if (count == 0) {
//        list.add(left);
//    }
//    if (right - left == p.length() ) {
//       
//        if (hash[s.charAt(left)] >= 0) {
//            count++;
//        }
//        hash[s.charAt(left)]++;
//        left++;
//    
//    }
//
//    
//}
//    return list;
//}