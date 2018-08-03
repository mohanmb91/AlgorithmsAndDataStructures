package leetCode77second;

import java.util.HashSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String arr[] = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();
        for(int i= 0; i < words.length; i ++){
        	set.add(convertTocode(words[i], arr));
        }
        return set.size();
    }
	private String convertTocode(String word, String[] map) {
		StringBuilder sb = new StringBuilder("");
		for(int i =0; i < word.length(); i ++) {
			char c = word.charAt(i);
			sb.append(map[c - 97]);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
	    Solution ob = new Solution();
	    ob.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"});
	}
}
