package leetcode83Second;
class Solution {
    private static final String phone13 = "+***-***-***-";
    private static final String phone12 = "+**-***-***-";
    private static final String phone11 = "+*-***-***-";
    private static final String phone10 = "***-***-";
    private static final String email = "*****";
    public String maskPII(String S) {
        if(S==null || S.length()==0)
            return null;
        StringBuilder sb = new StringBuilder();
        if(S.contains("@"))
        {

            sb.append(Character.toLowerCase(S.charAt(0)));
            sb.append(email);
            
            boolean flag = false;
            int i=1;
            while(i<S.length())
            {
                if(S.charAt(i)=='@')
                {
                    if(!flag && i-1!=0)
                    {
                        sb.append(Character.toLowerCase(S.charAt(i-1)));
                        flag = true;
                    }
                }
                
                if(flag)
                {
                    if(S.charAt(i)=='.')
                        sb.append(S.charAt(i));
                    else
                     sb.append(Character.toLowerCase(S.charAt(i)));
                }
                i++;
            }
                
        }
        else
        {
                int count = 0;
                int i=0;
                while(i<S.length())
                {
                    char ch = S.charAt(i);
                    if(Character.isDigit(ch))
                        count++;
                    i++;
                }
            
                if(count==13)
                    sb.append(phone13);
                 if(count==12)
                    sb.append(phone12);
                if(count==11)
                    sb.append(phone11);
                if(count==10)
                    sb.append(phone10);
            
                i=S.length()-1;
                StringBuilder str1 = new StringBuilder();

                count=4;
                while(i>0 && count>0)
                {
                    char ch = S.charAt(i);
                    if(Character.isDigit(ch))
                    {
                        str1.append(ch);
                        count--;
                    }
                    i--;
                    
                }
                sb.append(str1.reverse());
            
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
