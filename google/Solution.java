package google;

public class Solution {
	    public boolean checkPossibility(int[] a) {
	        if(a.length == 2){
	            return a[0] <= a[1];
	        }
	        int count = 0;
	        for(int i=1; i < a.length - 1; i++){
	            int p = i -1;
	            int c = i;
	            int n = i +1;
	            if(a[p] > a[c] || a[c] > a[n] || a[p] > a[n]){
	                if(count == 1){
	                    return false;
	                }      
	                int cp = a[p];
	                int cc = a[c];
	                int cn = a[n];
	                a[p] = a[c];
	                if(!isFine(a, c)){
	                    a[p] = cp;
	                    a[c] = a[p];
	                    if(!isFine(a, c)){
	                        a[c] = cc;
	                        a[c] = a[n];
	                        if(!isFine(a, c)){
	                            a[c] = cc;
	                            a[n] = a[c];
	                            if(!isFine(a, c)){
	                                return false;
	                            }
	                        }
	                    }
	                }
	                count ++;
	            }
	            
	        }
	        return true;
	    }
	    
	    public boolean isFine(int a[], int i){
	        if(i - 1 >= 0 && a[i - 1] > a[i]){
	            return false;
	        }else if(i+1 < a.length && a[i] > a[i+1]){
	            return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution ob =  new Solution();
		ob.checkPossibility(new int[] {3, 2, 4, 3});
	}

}
