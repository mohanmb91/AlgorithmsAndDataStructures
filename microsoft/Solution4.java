package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

 
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class Solution4 {
	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	public class Solution {
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	        bfs(node, map, new HashSet<UndirectedGraphNode>());
	        UndirectedGraphNode r = null;
	        for (Entry<UndirectedGraphNode, UndirectedGraphNode> e : map.entrySet()) {
			    UndirectedGraphNode k = e.getKey();
	            UndirectedGraphNode v = e.getValue();
	            r = v;
	            List<UndirectedGraphNode> t = new ArrayList<>();
	            for(UndirectedGraphNode eN: k.neighbors){
	                t.add(map.get(eN));
	            }
	            r.neighbors = t;
		    }
	        return map.get(node);
	    }
	    public void bfs(UndirectedGraphNode r, HashMap<UndirectedGraphNode, UndirectedGraphNode> m, HashSet<UndirectedGraphNode> v){
	        Queue<UndirectedGraphNode> f = new LinkedList<UndirectedGraphNode>();
	        f.add(r);
	        v.add(r);
	        while(!f.isEmpty()){
	            UndirectedGraphNode c = f.poll();
	            if(!m.containsKey(c)){
	                m.put(c, new UndirectedGraphNode(c.label));
	            }
	            for(UndirectedGraphNode eN: c.neighbors){
	                if(!v.contains(eN)){
	                    f.add(eN);
	                    v.add(eN);
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
