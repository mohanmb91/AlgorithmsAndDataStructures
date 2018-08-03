package decrept;

import java.util.HashMap;
public class Solution {   
    public static String answer(String s) { 
        int asciiA = 97;
        int asciiZ = 122;
        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i=0; i < 26; i ++){
            char last =  (char) asciiZ;
            char first =  (char) asciiA;
            map.put(last, first);
            asciiZ --;
            asciiA ++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0; i < s.length(); i ++){
            char c = s.charAt(i);
            int ascii = (int) c;
            if(ascii >= 97 && ascii <= 122){
                sb.append(map.get(c)+"");    
            }else{
                sb.append(c+ "");
            }
        }
        
        return sb.toString();
    } 
    public static void main(String args[]) {
    	
    }
}