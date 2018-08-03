package contest82;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] f = new int[121];
        for(int v : ages){
        	f[v]++;
        }
        int ret = 0;
        for(int i = 0;i <= 120;i++){
        	for(int j = 0;j <= 120;j++){
        		if(j*2 <= i+14 || j > i || j > 100 && i < 100){
        		}else{
        			if(i == j){
        				ret += f[i] * (f[i]-1);
        			}else{
        				ret += f[i]*f[j];
        			}
        		}
        	}
        }
        return ret;
    }
    
    public static void main(String args[]) {
    	Solution ob = new Solution();
    	ob.numFriendRequests(new int[] {23,4,76,118,48,88,97,71,112,23,98,21,83,24,85,18,20,53,77,30,99,103,62,117,51,41,46,43,71,88,111,68,99,104,105,40,120,97,108,13,23,32,105,86,74,55,22,84,63,88,80,10,59,47,118,1,83,28,74,1,111,85,99,104,79,19,117,18,20,62,16,3,33,64,62,41,8,34,32,35,92,25,16,55,72,29,17,56,28,110,56,37,112,81,24,62,54,60,109,33});
    }
}