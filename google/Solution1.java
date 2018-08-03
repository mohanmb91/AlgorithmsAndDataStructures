package google;

import java.util.Arrays;

public class Solution1 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wP = 0;
        if(abbr.length() > word.length()) {
        	return false;
        }
        if(abbr.equals("") && !word.equals("")) {
    		return false;
        }
        if(!abbr.equals("") && word.equals("")) {
    		return false;
        }
        for(int i=0; i < abbr.length(); i ++){
            char c = abbr.charAt(i);
            if(c >= '0' && c <= '9'){
                String num = "";
                int temp = i;
                while(c >= '0' && c <= '9'){
                	if(num.length() == 0 && abbr.charAt(temp) == '0') {return false;}
                    num += abbr.charAt(temp);
                    temp ++;
                    if(temp >= abbr.length()) {
                    	break;
                    }
                    c = abbr.charAt(temp);
                }
                i = temp - 1;
                int no = Integer.parseInt(num);
                while(no-->0) {
                	wP += 1;
                	if(no >= 1) {
                		if(wP >= word.length()) {
                			return false;
                		}
                	}
                }
                if(i + 1 >= abbr.length()) {
                	if(wP < word.length()) {
                		return false;
                	}
                }
            	if(wP >= word.length()) {
            		if(i + 1 < abbr.length()) {
            			return false;
            		}
            	}
            }else{
                if(abbr.charAt(i) != word.charAt(wP)){
                    return false;
                }
                if(wP >= word.length()){
                    return false;
                }
                wP ++;
            }
        }
        return true;
    }
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
        	index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        return result;
    }
    public int findNthDigit(int n) {
        long limit, s, e;
        long sR, eR, pS,pE, pSR, pER;
        limit = 10;
        s = sR = 1;
        e = eR = 9;
        pS = pE = pSR= pER = -1;
        while(!(n >= sR && n <= eR)){
            pS = s;
            pE = e;
            pSR = sR;
            pER = eR;
            s = pE + 1;
            e = (limit * 10) - 1;
            sR = pER + 1;
            eR = pER + ((e-pE) * (limit + "").length());
            limit = limit * 10;
        }
        if(pER == -1){
            return n;
        }
        n = Integer.valueOf((n - pER)+"");
        int digits = ((limit - 1) + "").length();
        int no = n / digits;
        int remains = n % digits;
        if(remains > 0){
            no += 1;
            no += pE;
            return Integer.parseInt( (no+"").charAt(remains - 1) +"");        
        }else{
            no += pE;
            String number = no+"";
            return Integer.parseInt( (number).charAt(number.length() - 1) +"");
        }
    }
    public static void main(String[] args) {
		Solution1 ob =  new Solution1();
		// ob.validWordAbbreviation("hi", "hi1");
		// ob.findUnsortedSubarray(new int[] {1,4,5,6,7,2,3,8});
		// ob.findRadius(new int[] {1,5,15}, new int[] {2,19,28});
		ob.findNthDigit(2147483647);
	}
}
