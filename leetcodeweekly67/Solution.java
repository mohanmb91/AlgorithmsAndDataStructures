package leetcodeweekly67;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class SE{
	int start;
	int end;
	SE(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
public class Solution {
    public static List<Integer> partitionLabels(List<Character> S) {
    		int n = S.size();
        HashMap<Character, SE> startEndMap = new HashMap<Character, SE>();
         for(int i=0; i < n; i ++){
        	 	char c = S.get(i); 
            if(!startEndMap.containsKey(c)) {
            		startEndMap.put(c, new SE(i,i));
            }else {
            		SE newSE = startEndMap.get(c);
            		newSE.setEnd(i);
            		startEndMap.put(c, newSE);
            }
        }
         int start, end;
         start = end = 0;
         List<Integer> result = new ArrayList<Integer>(); 
         int maxLength = 0;
         int tempStart =0;
         while(start < n) {
        	 	char c = S.get(start);
        	 	SE temp = startEndMap.get(c);
        	 	if(temp.getEnd() >= end) {
        	 		end = temp.getEnd();
        	 		int length = end - tempStart + 1;
        	 		if(maxLength < length) {
        	 			maxLength = length;
        	 		}
        	 	}
        	 	if(start == end) {
        	 		result.add(maxLength);
        	 		maxLength = 0;
        	 		end++;
        	 		tempStart = end;
        	 	}
        	 	start ++;
         }
          return result;
    }
    public static void main(String args[]) {
    	 // partitionLabels("abc");
    }
}
