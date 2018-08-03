package cerner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Solution {
  /**
   * Iterate through each line of input.
   */
   
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String number = line.trim();
      int count = 0;
      while(!isPalindrome(number)){
        String reverse = reverseNumber(number);
        BigInteger num = new BigInteger(number);
        BigInteger rev = new BigInteger(reverse);
        BigInteger temp = num.add(rev);
        number = temp.toString(); 
        count ++;
      }
      System.out.println(count+ " "+ number);
    }
  }
  
  public static boolean isPalindrome(String number){
    int start, end;
    start = 0; end = number.length() - 1;
    while(start < end){
      if(number.charAt(start) != number.charAt(end)){
        return false;
      }
      start ++;
      end --;
    }
    return true;
  }
  
  public static String reverseNumber(String number){
    StringBuilder sb= new StringBuilder("");
    
    for(int i = number.length()-1; i >= 0; i --){
      sb.append(number.charAt(i) + "");
    }
    return sb.toString();
  }
}
