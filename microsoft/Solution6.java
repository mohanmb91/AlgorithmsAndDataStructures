package microsoft;

class Solution6 {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    public boolean isMatchHelper(char in[], char p[], int iI, int pI){
        boolean r = false;
        if(pI >= p.length && iI >= in.length){
            return true;
        }
        if(pI < p.length && p[pI] == '*'){
            while(pI < p.length && p[pI] == '*'){
                pI ++;
            }
            if(pI >= p.length){
                return true;
            }else{
        		if(iI < in.length && pI < p.length && p[pI] == '?'){
                    if(in[iI] >= 'a' && in[iI] <= 'z'){
                         r = r || isMatchHelper(in, p, iI + 1, pI + 1);
                    }
            	}else {
            		for(int i= iI; i < in.length; i ++){
                        if(in[i] == p[pI]){
                            r = r || isMatchHelper(in, p, i, pI);
                        }
                    }	
            	}
            }
        }else if(iI < in.length && pI < p.length && p[pI] >= 'a' && p[pI] <= 'z'){
            if(p[pI] == in[iI]){
                r = r || isMatchHelper(in, p, iI + 1, pI + 1);
            }
        }
        else if(iI < in.length && pI < p.length && p[pI] == '?'){
            if(in[iI] >= 'a' && in[iI] <= 'z'){
                 r = r || isMatchHelper(in, p, iI + 1, pI + 1);
            }
        }
        return r;
    }

	public static void main(String[] args) {
		System.out.println(new Solution6().isMatch("c", "*?*"));
	}

}
