package microsoft;

class Solution5 {
	public double findMedianSortedArrays(int[] n1, int[] n2) {
        if(n1.length == 0 && n2.length == 0){
            return 0.0;
        }
        int n = n1.length + n2.length;
        boolean isE = n % 2 == 0;
        int p1 =0, p2 =0;
        int c = isE? n/2 - 1: n/2;
        while(c> 0){
            if(p1 < n1.length){
                if(p2 >= n2.length || n1[p1] <= n2[p2]) {
                    p1++;	
                    c --;
                }
            }
            if(p2 < n2.length && c > 0){
                if(p1 >= n1.length || n1[p1] >= n2[p2]) {
                    p2 ++;
                    c --;
                }
            }
        }

        double r = 0.0;
        int count = isE? 2: 1;
        while(count > 0){
            if(p1 < n1.length){
                if(p2 >= n2.length || n1[p1] <= n2[p2]) {
                    r += n1[p1];
                    p1++;	
                    count --;
                }
            }
            if(p2 < n2.length  && count > 0) {
                if(p1 >= n1.length || n1[p1] >= n2[p2]) {
                    r += n2[p2];
                    p2 ++;
                    count --;
                }
            }
        }
    
        return isE? r/2.0: r;
    }
	public static void main(String[] args) {
		new Solution5().findMedianSortedArrays(new int[] {1,2}, new int[] {1,2, 3});

	}

}
