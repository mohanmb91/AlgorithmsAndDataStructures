package fibonacci;

import java.math.BigInteger;
import java.util.*;


/* Java program for Memoized version */
public class Solution
{
	static BigInteger count = null;
	static HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
  /* Function to initialize NIL values in lookup table */
  
 // find fibonacci to 15th number
 // a = Array.new[15]
 // a[0] = 0
 // a[1] = 1
 // a[2] = 1
 // for (int i = 2; i < 15; i++) 
  /* function for nth Fibonacci number */
  public static int fib(int n)
  {
	  	count = count.add(new BigInteger("1"));
		if(map.containsKey(n)) {
			return map.get(n);	
		}
	   int result1 = fib(n-1);
	   int result2 = fib(n-2);
	   if(!map.containsKey(n)) {
		   map.put(n, result1 + result2);   
	   }
	   return result1 + result2;
  }
 
  public static void main(String[] args)
  {
	  map.put(0, 0);
	  map.put(1, 1);
    count = new BigInteger("0");
    Solution f = new Solution();
    System.out.println(count);
    int n = 100;
    System.out.println("Fibonacci number is" + " " + f.fib(n));
    System.out.println(count.toString());
  }
  // 79 => 102334155
  // 331160281 => 102334155
 
}