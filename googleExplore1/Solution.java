package googleExplore1;

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int bStart = B.indexOf(A);
        if(bStart == -1 || bStart > A.length()){
            return -1;
        }
        if(A.equals(B)) return 1;
        StringBuilder sb = new StringBuilder("");
        int result = 0; 
        if(bStart > 0 ){
        		result += 1;
            sb.append(A.substring(A.length()-bStart, A.length()));
        }
        int remainsB = B.length() - sb.toString().length();
        int firstHalfA = remainsB % A.length();
        int repeatA = remainsB / A.length();
        while(repeatA-->0) {
        		result += 1;
        		sb.append(A);
        }
        if(firstHalfA > 0) {
        		sb.append(A.substring(0,firstHalfA));
        		result += 1;
        }
        	return sb.toString().equals(B)? result: -1;
    }
	public static void main(String[] args) {
		Solution ob = new Solution();
		System.out.println((ob.repeatedStringMatch("abcde", "bcdeabcdeab") == 3?"Pass Test 1":"Fail 1"));
		System.out.println((ob.repeatedStringMatch("ab", "babababa") == 5?"Pass Test 2":"Fail 2"));
		System.out.println((ob.repeatedStringMatch("ab", "babababb") == -1?"Pass Test 3":"Fail 3"));
		System.out.println((ob.repeatedStringMatch("a", "a") == 1?"Pass Test 4":"Fail 4"));
		System.out.println((ob.repeatedStringMatch("a", "") == -1?"Pass Test 5":"Fail 5"));
		System.out.println((ob.repeatedStringMatch("", "") == 1?"Pass Test 6":"Fail 6"));
	}

}
