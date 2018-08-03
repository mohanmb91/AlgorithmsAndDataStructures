package algorithms;

public class RepeatedSubStringPattern {
	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int patternEnd = n/2;
		if(n <= 1) {
			return false;
		}
		
		while(patternEnd > 0) {
			int patternLength =  patternEnd;
			if(n % patternLength == 0) {
				int start = 0;
				StringBuilder sb = new StringBuilder("");
				String patternString = s.substring(start, patternLength);
				for(int end = patternLength; end <= n; end = end + patternLength ) {
					sb.append(patternString);
					start = end;
				}
				if(sb.toString().equals(s)) {
					return true;
				}
			}
			patternEnd--;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("aaabaaabaaab"));
	}

}
