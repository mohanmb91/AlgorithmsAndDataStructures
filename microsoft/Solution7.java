package microsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

class TreeNode{
	char c;
	List<TreeNode> childs;
	
	
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public List<TreeNode> getChilds() {
		return childs;
	}
	public void setChilds(List<TreeNode> childs) {
		this.childs = childs;
	}
	
}
class coord{
    int x, y; 
    boolean isStart;
    coord(int x, int y, boolean isStart){
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		coord other = (coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
public class Solution7 {
    public List<int[]> getSkyline(int[][] builds) {
        List<int[]> r = new ArrayList<>();
        PriorityQueue<coord> pq = new PriorityQueue<>(new Comparator<coord>(){
        	 @Override
             public int compare(coord a, coord b){
             	if(a.x != b.x){
                     return a.x-b.x;
                 }else{
                	 if(a.isStart && b.isStart) {
                		 return -1 * Integer.compare(a.y, b.y);
                	 }else if(!a.isStart && !b.isStart) {
                		 return Integer.compare(a.y, b.y);
                	 }else {
                		 if(a.isStart) {
                			 return -1;
                		 }else if(b.isStart) {
                			 return 1;
                		 }
                		 return 0;
                	 }
                 }
             }
        });
        for(int i=0; i < builds.length; i ++) {
        	int each[] = builds[i];
        	int start = each[0];
        	int end = each[1];
        	int height = each[2];
        	pq.add(new coord(start, height, true));
        	pq.add(new coord(end, height, false));
        }

        TreeMap<Integer, Integer> queue = new TreeMap<>();

        queue.put(0, 1);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        while(!pq.isEmpty()) {
        	coord buildingPoint = pq.poll();
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.y, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else { 
                queue.compute(buildingPoint.y, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }
            int currentMaxHeight = queue.lastKey();
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        
        return r;
    }
    public String treeToXML(TreeNode r) {
    	StringBuilder sb = new StringBuilder("");
    	if(r == null) return "";
    	treeToXMLHelper(r, 0, sb);
    	return sb.toString();
    }
    
    private void treeToXMLHelper(TreeNode r, int l, StringBuilder buildTag) {
    	String inden = getInden(l);
    	buildTag.append(inden + constructStartTag(r.c) + (r.getChilds().size() > 0? "\n": "") );
    	for(TreeNode eachR : r.getChilds()) {
    		treeToXMLHelper(eachR, l +1, buildTag);
    	}
    	buildTag.append((r.getChilds().size() > 0? inden: "") + constructEndTag(r.c));
	}
    public String getInden(int l) {
    	StringBuilder  sb = new StringBuilder();
    	for(int i=0; i < l; i ++) {
    		sb.append(" ");
    	}
    	return sb.toString();
    }
	private String constructEndTag(char c) {
		return "</"+c+">" ;
	}
    
    private String constructStartTag(char c) {
		return "<"+c+">";
	}
    
    
	
		
    public int scoreOfParentheses(String S) 
    {
    	int cur_score = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c: S.toCharArray()) {
            if(c == '('){
            	stack.push(cur_score);
                cur_score = 0;
            }
            else if(c == ')') {
            	if(cur_score == 0) cur_score = 1;
                else cur_score = 2 * cur_score;
                cur_score += stack.pop();
            }
        }
        return cur_score;
    }
    
	public static void main(String args[]) {
//    	int [][]  buildings = new int[][] {
//    		{0,1,2},{0,2,3}
//    	};
//    	List<int[]> r = new Solution7().getSkyline(buildings);
//    	for(int[] e: r) {
//    		System.out.println(e[0] + "  "+ e[1]);
//    	}
		
		System.out.println(new Solution7().scoreOfParentheses("((()())(()()))"));
    }
	
	
}