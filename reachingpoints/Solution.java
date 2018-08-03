package reachingpoints;

import java.util.*;

class Tile{
	int x;
	int y;
	Tile(int x, int y){
		this.x = x;
		this.y = y;
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
		if (obj == null)
			return false;
		Tile other = (Tile) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    	  Queue<Tile> frontier = new LinkedList<Tile>();
    	  frontier.add(new Tile(sx, sy));
    	  Tile target = new Tile(tx, ty);
      while(!frontier.isEmpty()){
    	  	Tile current = frontier.poll();
    	  	if(current.equals(target)) {
    	  		return true;
    	  	}
    	  	if(current.x <= target.x && current.y <= target.y) {
    	  		frontier.add(new Tile(current.x + current.y, current.y));
    	  		frontier.add(new Tile(current.x, current.x + current.y));
    	  	}
      }
      return false;
    }
	public static void main(String[] args) {	
		
	}

}
