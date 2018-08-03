package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class practice {
    static HashMap<Character, String> map = new HashMap<Character, String>();
    static List<String> result = new ArrayList<String>();

	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxCount, end, start;
        boolean hasChar[] = new boolean[256];
        if(n == 1){
            return 1;
        }else if(n < 1){
            return 0;
        }else{
            maxCount = start = 0;
             end = 0;
            while(end < n){
                int c = (int) s.charAt(end);
                if(!hasChar[c]){
                    hasChar[c] = true;
                    int tempMax = end - start + 1;
                    if(tempMax  > maxCount){
                        maxCount = tempMax;
                    }
                    end ++;
                }else{
                    while(hasChar[c] && start < end){
                        char ch = s.charAt(start);
                        hasChar[ch] = false;
                        start ++;
                        if(ch == c){
                            break;
                        }
                    }   
                    int tempMax = end - start + 1;
                    if(tempMax  > maxCount){
                        maxCount = tempMax;
                    }
                }
                
            }    
        }
        return maxCount;
    }
	public String longestPalindrome(String s) {
        int n = s.length();
    boolean mimoize[][] = new boolean[n][n];
        int max = 0; String result = "";
    for(int i=0; i < n ; i ++){
        if(i == 0){
            for(int j = 0; j < n ; j ++ ){
                mimoize[j][j] = true;
                max = 1;
                result = s.charAt(j)+ "";
            }
        }else if(i == 1){
            for(int j = 0; j < n - i ;j ++){
                int start = j;
                int end = j + i;
                if(s.charAt(start) == s.charAt(end)){
                    mimoize[start][end] = true;
                    result = s.substring(start, end);
                }
            }
        }else{
            for(int j = 0; j < n - i ;j ++){
                int start = j;
                int end = j + i;
                if(s.charAt(start) == s.charAt(end) && mimoize[start+1][end-1]){
                    mimoize[start][end] = true;
                    int temp = end - start + 1;
                    if(temp > max){
                        max = temp;
                        result = s.substring(start, end);
                    }
                }
            }
        }
    }
        return result;
    }

    
    public static List<String> letterCombinations(String digits) {
        map.put('2', "abc");map.put('3', "def");map.put('4', "ghi");map.put('5', "jkl");
        map.put('6', "mno");map.put('7', "pqrst");map.put('8', "tuv");map.put('9', "wxyz");
        letterCombinationsHelper(0,"", digits);
        return result;
    }
    public static void letterCombinationsHelper(int i, String temp, String Digits){
        if(i == Digits.length()){
            result.add(temp);
        }else{
            char c = Digits.charAt(i);
            String combinations = map.get(c);
            for(int j= 0; j < combinations.length(); j ++){
                letterCombinationsHelper(i+1, temp+combinations.charAt(j), Digits);
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int n= matrix.length;
        for(int layer= 0; layer < n/2; layer ++){
            int first = layer;
            int last = n - first - 1;
            
            for(int i = first; i < last; i++){
                int offset = i - first;
                
                int top = matrix[first][i];
                
                matrix[first][i] = matrix[last - offset][first];
                
                matrix[last - offset][first] = matrix[last][last - offset];
                
                matrix[last][last - offset] = matrix[first + offset][last];
                
                matrix[first + offset][last] = top;
            }
        }
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        List<List<String>> results = new ArrayList<List<String>>();
        HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();
        for(String eachStr: strs){
            int count[] = new int [26];
            for(int i = 0; i < eachStr.length(); i ++){
                count[((int) eachStr.charAt(i)) - 'a'] += 1;
            }
            
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i < count.length; i++){
                sb.append(count[i]);
                sb.append("#");
            }
            String key = sb.toString();
            if(resultMap.containsKey(key)) {
            	List<String> temp = resultMap.get(key);
            	temp.add(eachStr);
            		resultMap.put(key, temp);
            } else {
            	List<String> temp = new ArrayList<String>();
            	temp.add(eachStr);
            	 	resultMap.put(key,temp);
            }
        }
        for(String eachKey: resultMap.keySet()){
            results.add(resultMap.get(eachKey));
        }
        return results;
    }
    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for(int i =0 ; i < matrix[0].length; i ++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
        
        for(int i =0 ; i < matrix.length; i ++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        
        for(int i =1; i < matrix.length; i ++){
            for(int j = 1; j < matrix[0].length; j ++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i =1; i < matrix.length; i ++){
            if(matrix[i][0] == 0){
                for(int j =1; j < matrix[0].length; j ++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 1; j < matrix[0].length ; j ++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < matrix.length; i ++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRowZero){
            for(int i =0; i < matrix[0].length; i ++){
                matrix[0][i] = 0;
            }
        }
        
        if(firstColZero){
            for(int i =0; i < matrix.length; i ++){
                matrix[i][0] = 0;
            }
        }
    }
    public static ArrayList<List<Integer>> subsets(int[] S) {
    if(S.length == 0) {
    	return null;
    }
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    
    for(int i=0; i < S.length; i++) {
    		ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
    		
    		
    		for(List<Integer> a: result) {
    			temp.add(new ArrayList<Integer>(a));
    		}
    		
    		for(List<Integer> eachTemp:temp) {
    			eachTemp.add(S[i]);
    		}
    		// single
    		List<Integer> single = new ArrayList<Integer>();
    		single.add(S[i]);
    		temp.add(single);
    		
    		result.addAll(temp);
    }
    
    result.add(new ArrayList<Integer>());
    	return result;
    }
    public static List<Integer> grayCode(int n) {
        if(n==0){
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
     
        List<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);
     
        for(int i=result.size()-1; i>=0; i--){
        	result.add(numToAdd+result.get(i));
        }
     
        return result;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int count = 0;
        frontier.add(root);
        count += 1;
        while(!frontier.isEmpty()){
            int tempCount = 0;
            List<Integer> result = new ArrayList<Integer>();
            while(count-->0){
                TreeNode temp = frontier.poll();
                result.add(temp.val);
                
                if(temp.left != null){
                    frontier.add(temp.left);
                    tempCount += 1;
                }
                if(temp.right != null){
                    frontier.add(temp.right);
                    tempCount += 1;
                }
            }
            count = tempCount;
            results.add(result);
        }
        return results;
    }
    public static void main(String args[]) {
		/* lengthOfLongestSubstring("abcabcbb");
			Super s = new Subclass();
			s.foo();
		letterCombinations("3");
		rotate(new int[][]{
		                {5, 1, 9,11},
		                {2, 4, 8,10},
		                {13, 3, 6, 7},
		                {15,14,12,16}
		              });
		groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
		setZeroes(new int[][]{{0},{1},{2}});
		subsets(new int[] {1,2,3});
		grayCode(3);
		*/
		
	}
}



class Super {
	static void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	static void foo() {
		System.out.println("Subclass");
	}
}