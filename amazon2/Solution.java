package amazon2;

import java.util.*;

class Node{
	String startLabel;
	int startIndex;
	
	String endLabel;
	int endIndex;
	
	String nextExpected;
	int nextExpectedIndex;
	
	public Node(String nextExpected, int nextExpectedIndex) {
		this.startLabel = "";
		this.endLabel = "";
		this.nextExpected = nextExpected;
		this.nextExpectedIndex = nextExpectedIndex;
		this.startIndex = -1;
		this.endIndex = -1;
	}
}
public class Solution
{        
	List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList)
	{
		List<Integer> result = new ArrayList<Integer>();
		int minStart = Integer.MIN_VALUE;
		int minEnd = Integer.MAX_VALUE;
		if(targetList.size() == 0 || availableTagList.size() == 0) {
			result.add(0);
			return result;
		}
		HashMap<String, Integer> targetMap = new HashMap<String, Integer>();
		int count = 0;
		for(String eachTarget: targetList){
			targetMap.put(eachTarget, count);
			count ++;
		}
		
		Queue<Node> frontier = new LinkedList<Node>();
		Node start = new Node(targetList.get(0), 0);
		frontier.add(start);
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			for(int i = current.nextExpectedIndex; i < availableTagList.size(); i ++) {
				String eachAvailable = availableTagList.get(i);
				if(eachAvailable.equals(current.nextExpected)) {
					if(current.nextExpectedIndex == targetList.size() -1) {
						int currSE = current.endIndex - current.startIndex + 1;	
						if(currSE < (minEnd - minStart - 1)) {
							minEnd = current.endIndex;
							minStart = current.startIndex;
						}
					}
					else if(current.startIndex == -1) {
						Node temp = new Node(current.nextExpected, current.nextExpectedIndex);
						temp.startIndex = current.nextExpectedIndex;
						temp.startLabel = current.nextExpected;
						temp.nextExpectedIndex = (current.nextExpectedIndex + 1 < targetList.size())? current.nextExpectedIndex + 1: -1;
						temp.nextExpected = (temp.nextExpectedIndex != -1)? targetList.get(temp.nextExpectedIndex): "";
						
					}else {
						Node temp = new Node(current.nextExpected, current.nextExpectedIndex);
						
					}
				}
			}
		}
		return result;
	}
    
}