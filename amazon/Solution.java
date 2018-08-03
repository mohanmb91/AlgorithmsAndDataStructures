package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
	 public static List<String> subStringsKDist(String s, int num)
		{
		    HashSet<String> set= new HashSet<>();
		    int n = s.length();
	        int start, end;
	        start = end = 0;
	        int charCount[] = new int[256];
	        int count = 0;
	        while(end < n){
	            char c = s.charAt(end);
	            charCount[c] += 1;
	            count += 1;
	            if(count <= num) {
	            		if(charCount[c] > 1) {
	            			while(charCount[c] > 1) {
	            				charCount[s.charAt(start)] -= 1;
	            				start ++;
	            				count --;
	            			}
	            		}
	            }
	            if(count == num) {
	            		set.add(s.substring(start, end + 1));
	            		charCount[s.charAt(start)] -= 1;
	            		start ++;
        				count --;
	            }
	            end ++;
	        }
	        List<String> result = new ArrayList<>();
	        for(String each: set) {
	        		result.add(each);
	        }
	        return result;
	    }
	public static void main(String[] args) {
		subStringsKDist("awaglknagawunagwkwagl", 4);
	}

}
