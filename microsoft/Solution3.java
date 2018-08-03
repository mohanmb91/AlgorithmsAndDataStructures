package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point{
    int x;
    int y;
    int i;
    Point(int x, int y){
        this.x = x;
        this.y = y;
        this.i = -1;
    }
    Point(int x, int y, int i){
        this.x = x;
        this.y = y;
        this.i = i;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
public class Solution3 {
    public boolean exist(char[][] b, String w) {
    	boolean v[][] = new boolean[b.length][b[0].length];
        List<Point> pS = new ArrayList<Point>();
        for(int i=0; i < b.length; i ++){
            for(int j=0; j < b[0].length; j ++){
                if(b[i][j] == w.charAt(0)){
                    pS.add(new Point(i, j));
                }
            }
        }
        for(Point ePS: pS){
            int x = ePS.x;
            int y = ePS.y;
            if(isValid(x, y, b, w, 0, v)){
                return true;
            }
            v = new boolean[b.length][b[0].length];
        }
        return false;
    }
    public boolean isValid(int x , int y, char[][] b, String w, int i,boolean v[][]){
    	if(i >= w.length()) {return true;}
    	if(b[x][y] != w.charAt(i)) {return false;}
    	if(i+1 >= w.length()) {return true;}
    	boolean result = false;
    	v[x][y] = true;
		if(x - 1 >= 0 && !v[x-1][y]){
			result = result || isValid(x -1, y, b, w, i+1, v);
		}
		if(x + 1 < b.length && !v[x+1][y]){
			result = result || isValid(x + 1, y, b, w, i+1, v);
		}
		if(y - 1 >= 0 && !v[x][y-1]){
			result = result || isValid(x, y - 1, b, w, i+1, v);
		}
		if(y + 1 < b[0].length && !v[x][y+1]){
			result = result || isValid(x, y + 1, b, w, i+1, v);
		}
		v[x][y] = false;
	    	return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 o = new Solution3();
		System.out.println(o.exist(new char[][] {{'A', 'A', 'A', 'A'},{'A', 'A', 'A', 'A'},{'A', 'A', 'A', 'A'}}, "AAAAAAAAAAAAA"));
		
	}

}
