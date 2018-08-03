package leetcode.subarray;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public boolean validTicTacToe(String[] board) {
    			int Ocount = 0;
    			int Xcount = 0;
            boolean isXwinner = isPlayerWinner('X', board);
            boolean isOwinner = isPlayerWinner('O', board);
        		if(isXwinner && isOwinner) {
        			return false;
        		}
        		for(int i=0;i<3;i++) {
        			for(int j=0;j<3;j++) {
        				if(board[i].charAt(j) == 'X') {
        					Xcount += 1;
        				}else if(board[i].charAt(j) == 'O') {
        					Ocount += 1;
        				}
        			}
        		}
        		if(Xcount < Ocount) {
        			return false;
        		}
        		if(Math.abs(Xcount - Ocount) > 1) {
        			return false;
        		}
        		
        		if(isXwinner && Xcount != Ocount+1) {
        			return false;
        		}
        		if(isOwinner && Ocount != Xcount) {
        			return false;
        		}
            return true;
    }
    public boolean isPlayerWinner(char c, String board[]) {
    	if(
    			(board[0].charAt(0) == c &&
            board[0].charAt(1) == c &&
            board[0].charAt(2) == c)
            ||
            (board[1].charAt(0) == c &&
            board[1].charAt(1) == c &&
            board[1].charAt(2) == c)
            ||
            (board[2].charAt(0) == c &&
            board[2].charAt(1) == c &&
            board[2].charAt(2) == c)
            ||
            (board[0].charAt(0) == c &&
            board[1].charAt(0) == c &&
            board[2].charAt(0) == c)
            ||
            (board[0].charAt(1) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(1) == c)
            ||
            (board[0].charAt(2) == c &&
            board[1].charAt(2) == c &&
            board[2].charAt(2) == c)
            ||
            (board[0].charAt(0) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(2) == c)
            ||
            (board[0].charAt(2) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(0) == c)
            ) {
            	return true;
            }
    	 	return false;
    }
}