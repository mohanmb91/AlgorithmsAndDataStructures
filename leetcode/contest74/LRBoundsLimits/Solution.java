package leetcode.contest74.LRBoundsLimits;
class Solution {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j=0,count=0,res=0;
        
        for(int i=0;i<A.length;i++){
            if(A[i]>=L && A[i]<=R){
                res+=i-j+1;
                count=i-j+1;
            }
            else if(A[i]<L){
                res+=count;
            }
            else{
                j=i+1;
                count=0;
            }
        }
        return res;
    }
    public static void main(String args[]) {
    		numSubarrayBoundedMax(new int[] {70 ,90,7,81, 100, 40, 30 }, 80, 99);
    		
    		// 70, 90 ==> 90    70,90
    		//  90    70,90  90,7   70,90,7
    		//  70,90,7, 81 		90,7, 81   	7, 81 	81
    		// 
    		// res 16
    		// count 4
    		
    }
}

