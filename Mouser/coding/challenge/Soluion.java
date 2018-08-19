package Mouser.coding.challenge;


public class Soluion {
	public static void main(String[] args) {
		Soluion ob = new Soluion();
		System.out.println(ob.solution2(new int[] {1,1,0,1,0,0}));
	}

	private static int solution(int A) {
		char input[] = (A + "").toCharArray();
		int start = 0, end = input.length-1;
		StringBuilder sb = new StringBuilder(""); 
		while(start < end) {
			sb.append(input[start]);
			sb.append(input[end]);
			start ++; 
			end --;
		}
		if(start == end) {
			sb.append(input[start]);
		}
		return Integer.parseInt(sb.toString());
	}
	
	public int solution1(int[] A) {
		int n = A.length;
	    if(n == 0 || n == 1) return 0;
	    int start= 0, end = 1;
	    int max=1;
	    int maxIndex = 0;
	    while(end < n) {
	    	if(A[end - 1] < A[end]) {
	    		if(end - start + 1 > max) {
		    		max = end - start + 1;
		    		maxIndex = start;
		    	}	    		
	    	}else {
	    		start = end;
	    	}
	    	end ++;
	    }
	    return maxIndex;
	}
	
	int solution2(int[] A) {
		// 1,1,0,1,0,0
		int n = A.length;
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
		    if (A[i] == A[i + 1])
		        result = result + 1;
		}
		int r = -1;
		for (int i = 0; i < n; i++) {
			int count = 0;
		    if (i > 0) {
		        if (A[i - 1] != A[i])
		            count = count + 1;
		        else
		            count = count - 1;
		    }
		    if (i < n - 1) {
		        if (A[i + 1] != A[i])
		            count = count + 1;
		        else
		            count = count - 1;
		    }
		    r = Math.max(r, count);
		}
		return result + r;
	}
}
