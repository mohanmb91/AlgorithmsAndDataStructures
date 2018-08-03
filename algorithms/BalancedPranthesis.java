package algorithms;

/* 
	Input : n=1
	Output: {}
	
	Input : n=2
	Output: 
	{}{}
	{{}}
 */
public class BalancedPranthesis {
	public static void main(String[] args) {
		System.out.println(printBalancedParenthesis(3));
	}
	private static String printBalancedParenthesis(int n) {
		StringBuilder sb = new StringBuilder();	
		printBalancedParenthesisHelper(n, n, n, sb, "");
	return sb.toString();
}
	private static void printBalancedParenthesisHelper(int n, int aOP, int aCP, StringBuilder sb, String r) {
	if(aCP == 0) {
		sb.append(r+ "\n");
}else {
	if(aOP > 0 || aOP == aCP) {
		printBalancedParenthesisHelper(n, aOP-1, aCP, sb, r + "(");	
	}
	if(aOP < aCP) {
		printBalancedParenthesisHelper(n, aOP, aCP-1, sb, r + ")");
			}	
		}
	}
}
