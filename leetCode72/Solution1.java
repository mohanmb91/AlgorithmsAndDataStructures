package leetCode72;

import java.util.*;

public class Solution1 {

	 public static boolean isBipartite(int[][] graph) {
	 	HashMap<Integer, Set<Integer>> map = new LinkedHashMap<Integer, Set<Integer>>();
	 	for(int i=0; i < graph.length; i ++) {
	 		Set<Integer> set = new HashSet<Integer>();
	 		for(int j=0; j < graph[i].length; j ++) {
	 			set.add(graph[i][j]);
	 		}
	 		map.put(i, set);
	 	}
	 	
	 	HashSet<Integer> setA = new HashSet<Integer>();
	 	HashSet<Integer> setB = new HashSet<Integer>();
	 	for(int eachNode: map.keySet()) {
	 		if(setA.contains(eachNode) && setB.contains(eachNode)) {
	 			return false;
	 		}
	 		if(setA.contains(eachNode)) {
	 			setA.add(eachNode);
	 			setB.addAll(map.get(eachNode));
	 		}else {
	 			setB.add(eachNode);
	 			setA.addAll(map.get(eachNode));
	 		}
	 	}
	 	
	 	return true;
	 }
	public static void main(String[] args) {
		isBipartite(new int[][] {
			{4,3,1},
			{0,5,2},
			{3,1,6},
			{7,2,0},
			{7,5,0},
			{4,6,1},
			{7,2,5},
			{4,3,6}
		});

	}

}
