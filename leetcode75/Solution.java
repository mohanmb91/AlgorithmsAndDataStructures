package leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(graph == null || graph.length == 0){return results;}
        Queue<List<Integer>> frontier = new LinkedList<List<Integer>>();
        int destination = graph.length - 1;
        List<Integer> start = new ArrayList<Integer>();
        start.add(0);
        frontier.add(start);
        while(!frontier.isEmpty()){
            List<Integer> current = frontier.poll();
            int nextIndex = current.get(current.size());
            for(int i=0; i < graph[nextIndex].length; i ++) {
            		List<Integer> newPath = new ArrayList<Integer>(current);
            		int nextElement = graph[nextIndex][i];
            		newPath.add(nextElement);
            		frontier.add(newPath);
            		if(nextElement == destination) {
            			results.add(newPath);
            		}
            }
        }
        return results;
    }
}