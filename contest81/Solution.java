package contest81;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] shortestToChar(String S, char C) {
		int results[] = new int[S.length()];
		boolean isEIndex[] = new boolean[S.length()];
        for(int i=0; i < S.length(); i++) {
        	if(C == S.charAt(i)) {
        		isEIndex[i] = true; 
        	}
        }
        for(int i=0; i < S.length(); i++) {
        	if(S.charAt(i) == C) {
        		results[i] = 0;
        	}else {
        		int temp = i;
        		int index = -1;
        		// backward
        		while(temp>= 0) {
        			if(isEIndex[temp]) {
        				index = i - temp;
        				break;
        			}
        			temp --;
        		}
        		temp = i;
        		// forward
        		while(temp <  S.length()) {
        			if(isEIndex[temp]) {
        				if(index == -1) {
        					index = temp - i;
            				break;
        				}else if((temp - i) < index) {
        						index = temp - i;
                				break;
        				}
        			}
        			temp ++;
        		}
        		results[i] = index;
        	}
        }
        
        return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
