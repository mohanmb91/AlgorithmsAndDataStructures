package algorithms;
import java.util.*;
class parentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('{','}');map.put('(',')');map.put('[',']');
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '}' || c == ']' || c == ')'){
				if(stack.empty() || map.get(stack.pop()) != c){
					return false;
				}
			}else{
				stack.push(c);
			}

		}
		return true;
	}	
}
