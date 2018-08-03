package noOfIlands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Tile{
	int x;
	int y;
	boolean isVisited;
	Tile(int x, int y){
		this.x = x;
		this.y = y;
		isVisited = false;
	}
}
public class Solution {
	static Queue<Tile> frontier;
	public static int numIslands(char[][] grid) {
		boolean isVisited[][] = new boolean[grid.length][grid[0].length];
		frontier = new LinkedList<Tile>();
		frontier.add(new Tile(0,0));
		isVisited[0][0] = true;
		int result = 0;
		while(!frontier.isEmpty()){
			Tile xy = frontier.poll();
			System.out.println(xy.x +"+"+ xy.y);
			for(Tile eachXY: getneibhoursAll(xy, grid, true)){
				if(! isVisited[eachXY.x][eachXY.y]) {
					frontier.add(new Tile(eachXY.x, eachXY.y));
					isVisited[eachXY.x][eachXY.y] = true;
				}
			}
			if(grid[xy.x][xy.y] == '1'){
				result += 1;
				dfs(xy, grid);
			}
		}
		return result;
	}

	public static void dfs(Tile xy, char[][] grid){
		grid[xy.x][xy.y] = '0';
		for(Tile eachXY: getneibhoursAll(xy, grid, false)){
			dfs(eachXY, grid);
		}
	}
	public static List<Tile> getneibhoursAll(Tile xy, char[][] grid, boolean isAll){
		int row = xy.x;
		int col = xy.y;
		int rowLength = grid.length;
		int colLength = grid[0].length;
		List<Tile> result = new ArrayList<Tile>();
		if(row - 1 >= 0 && (isAll || grid[row-1][col] == '1')){
			result.add(new Tile(row-1, col));
		} if(col -1 >= 0 && (isAll || grid[row][col - 1] == '1')){
			result.add(new Tile(row, col -1));
		} if(row + 1 < rowLength && (isAll || grid[row+1][col] == '1')){
			result.add(new Tile(row + 1, col));
		} if(col + 1 < colLength && (isAll || grid[row][col + 1] == '1')){
			result.add(new Tile(row, col + 1));
		}
		return result;
	}

	public static void main(String args[]) {
		numIslands(new char[][]{{'1','0','1','1','0'},
			{'0','0','0','0','0'},
			{'1','1','0','1','0'},
			{'0','0','0','0','0'}});
	}
}
