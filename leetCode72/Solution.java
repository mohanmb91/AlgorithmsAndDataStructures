package leetCode72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	 public static List<String> letterCasePermutation(String S) {
	        List<char[]> result = new ArrayList<char[]>();
	        if(S.length() == 0 || S.equals("")){
	            List<String> temp = new ArrayList<String>();
	            temp.add("");
	            return temp;
	        }
	        result.add(S.toCharArray());
	        int end= 0;
	        while(end < S.length()){
	            List<char[]> temp = new ArrayList<char[]>(result);
	            
	            for(char[] eachString: temp){
	                char[] temp1 = Arrays.copyOf(eachString, eachString.length);
                		if(eachString[end] >= 97 && eachString[end] <= 122){
                			temp1[end] = Character.toUpperCase(temp1[end]);
                			result.add(temp1);
                		}
                		else if(eachString[end] >= 65 && eachString[end] <= 90){
                			temp1[end] = Character.toLowerCase(temp1[end]);
                			result.add(temp1);
                		}
                    
	            }
	            end ++;
	        }
	        List<String> result1 = new ArrayList<String>();
	        for(char[] eachString: result){
	        		StringBuilder temp = new StringBuilder("");
	        		for(char eachChar: eachString) {
	        			temp.append(eachChar);
	        		}
	        		result1.add(temp.toString());
	        }
	        return result1;
	    }
	
	private static char[] deepCopy(char[] eachString) {
		char copy[] = new char[eachString.length];
		for(int i=0; i < eachString.length; i ++) {
			copy[i] = eachString[i];
		}
		return copy;
	}

	public static void main(String args[]) {
		letterCasePermutation("a1b2");
	}
}
