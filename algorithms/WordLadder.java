package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodeWord{
    String word;
    int length;
    NodeWord(String word, int length){
        this.word = word;
        this.length = length;
    }
}
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<NodeWord> frontier = new LinkedList<NodeWord>();
        wordList.add(endWord);
        frontier.add(new NodeWord(beginWord, 1));
        HashSet<String> wordDict = new HashSet<String>();
        for(String eachWord: wordList){
            wordDict.add(eachWord);
        }
        HashSet<String> roBeRemoved = new HashSet<String>();
        while(!frontier.isEmpty()){
            NodeWord temp = frontier.poll();
            for(String eachWord: wordDict){
                if(isTransformable(temp.word.toCharArray(), eachWord.toCharArray())){
                		if(eachWord.equals(endWord)) {
                			return temp.length + 1;
                		}else {
		                frontier.add(new NodeWord(eachWord, temp.length + 1));
		                roBeRemoved.add(eachWord);
                		}
                }
            }
            for(String eachWord: roBeRemoved){
            		wordDict.remove(eachWord);
            }
            roBeRemoved = new HashSet<String>();
        }
        return 0;
    }
    
    public static boolean isTransformable(char[] from, char[] to){
        int count = 0;
        for(int i =0 ; i < to.length; i ++){
            if(from[i] != to[i]){
                count += 1;
                if(count > 1){
                    return false;
                }
            }
        }
        if(count == 0){
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
    		List<String> input = new ArrayList<String>();
    		input.add("hot");
		input.add("dot");
		input.add("dog");
		input.add("lot");
		input.add("log");
		input.add("cog");
    		ladderLength("hit", "cog", input);
    }
}