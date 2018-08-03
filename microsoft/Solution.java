package microsoft;

import java.math.BigInteger;
import java.util.Arrays;
class Solution {
	/* -----------------------------------
	 *  WARNING:
	 * -----------------------------------
	 *  Your code may fail to compile
	 *  because it contains public class
	 *  declarations.
	 *  To fix this, please remove the
	 *  "public" keyword from your class
	 *  declarations.
	 */
    public String reverseWords(String S) {
        char c[] = S.trim().toCharArray();
        int n = c.length;
        StringBuilder result = new StringBuilder("");
        if(c.length > 1){
            reverseStartEnd(c,0,n-1);
            int s=0, e=0;
            System.out.println(String.valueOf(c) + "===>" + s + "===>" + e );
            while(e < n && s <= e){
                if(c[e] == ' '){
                    System.out.println(String.valueOf(c) + "===>" + s + "===>" + e );
                    result.append(reverseStartEnd(c,s,e-1) + " ");
                    while(c[e] == ' '){
                        e ++;
                    }
                    s = e;
                }else{
                    e ++;   
                }
            }
            if(s <= (e-1) && (e-1) < n){
                result.append(reverseStartEnd(c,s,e-1));
            }
        }
        return result.toString().trim();   
    }
    public String reverseStartEnd(char c[], int start, int end){        
        while(end > start){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start ++;
            end --;
        }
        return String.valueOf(c).substring(start, end+1);
    }

    public int myAtoi(String str) {
        str = str.trim();
        if(str.equals("")){return 0;}
        if(str.length() == 1 && str.equals("-")){return 0;}
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder("");
        for(int i=0 ; i < str.length(); i ++){
            char c = str.charAt(i);
            if(c == '-' && i == 0){
                isNegative = true;
                continue;
            }if(c == '+' && i == 0) {continue;}
            if(c >= 48 && c <= 57){
                sb.append(c);
            } 
        }
        if(sb.toString().equals("")){return 0;}
        BigInteger bg = new BigInteger(sb.toString());
        if(isNegative){bg = bg.multiply(new BigInteger("-1"));}
        if(BigInteger.valueOf(Integer.MAX_VALUE).compareTo(bg) == -1){
            return Integer.MAX_VALUE;
        }
        if(BigInteger.valueOf(Integer.MIN_VALUE).compareTo(bg) == 1){
           return Integer.MIN_VALUE;
        }
        return bg.intValue();
    }
    
    
	public int trap(int[] h) {
	    int c =0, sO = 0, s = -1, e = 0, r = 0;
	    while(e < h.length){
	        if(s == -1){ 
	            s = h[e] > 0?e: -1;
	        }else{
	            if(h[s] <= h[e]){
	                r = r + ((Math.min(h[e],h[s]) * c) - sO);
	                s = e;
	                c=sO=0;
	            }else{
	                c ++;
	                sO += h[e];
	            }
	        }
	        e ++;
	    }
	    int nS = s;
	    s = -1;
	    e = h.length-1;
	    c=sO=0;
	    while(e >= nS){
	        if(s == -1){ 
	            s = h[e] > 0?e: -1;
	        }else{
	            if(h[s] <= h[e]){
	                r = r + ((Math.min(h[e],h[s]) * c) - sO);
	                s = e;
	                c=sO=0;
	            }else{
	                c ++;
	                sO += h[e];
	            }
	        }
	        e --;
	    }
	    return r;
	}
	
	 public boolean isNStraightHand(int[] h, int W) {
	        if(W == 1){ return true;}
	        if(h.length % W != 0){
	            return false;
	        }
	        Arrays.sort(h);
	        int e = 1;
	        int nG = 0 + W;
	        int tNG  = nG;
	        while(e < h.length){
	            while(e < nG){
	                if(h[e] > h[e-1]){
	                }else{
	                    while(tNG < h.length && h[tNG] == h[e]){
	                        tNG++;
	                    }
	                    if(tNG >= h.length){
	                        return false;
	                    }
	                    int t = h[e];
	                    h[e] = h[tNG];
	                    h[tNG] = t;
	                }
		            e ++;
	            }
	            nG += W;
	            tNG = nG;
	            e = nG - W + 1;
	        }
	        return true;
	    }
	public static void main(String args[]) {
    	Solution ob = new Solution();
    	// ob.myAtoi("+987 words and ");
        // System.out.println(ob.reverseWords("the sky is blue"));
    	// ob.trap(new int[] {0,1,0,3,1,0,1,3,2,1,2,1});
    	ob.isNStraightHand(new int[] {5,1}, 2);
    }
}