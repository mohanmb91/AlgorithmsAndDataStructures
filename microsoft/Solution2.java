package microsoft;

public class Solution2 {
	static String longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++)
        {
            for(int j=0;j<=b.length();j++)
            {
                if (i == 0 || j == 0)
                {
                     dp[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        
        int numberOfSubsequence = dp[a.length()][b.length()];
        char[] answer = new char[numberOfSubsequence];
        int i=a.length();
        int j = b.length();
        while(i>0 && j>0)
        {
             if(a.charAt(i-1) == b.charAt(j-1))
            {
                answer[numberOfSubsequence-1] = a.charAt(i-1);
                i--;
                j--;
                numberOfSubsequence--;
            }  
            else if(dp[i-1][j]>dp[i][j-1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }
        
        return String.valueOf(answer);
    }
	public static void main(String[] args) {
		boolean result = true;
		result = result && longestCommonSubsequence("abcdefghi", "bxxxxdyyyyepppghi").equals("bdeghi");
		result = result && longestCommonSubsequence("abcde", "xyzuio").equals("");
		result = result && longestCommonSubsequence("", "xyzuio").equals("");
		result = result && longestCommonSubsequence("", "").equals("");
		result = result && longestCommonSubsequence("abcd", "").equals("");
		result = result && longestCommonSubsequence("abcde", "axyzbxyzclkjd").equals("abcd");
		result = result && longestCommonSubsequence("aaaabbbbbbbbc", "axyzbxyzc").equals("abc");
		System.out.println(result? "success all test cases passed": "you have failing tests");
	}

}
