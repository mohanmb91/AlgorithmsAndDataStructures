package codinggame.GhostBuster;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Send your busters out into the fog to trap ghosts and bring them home!
 **/
class Coord{
	int x;
	int y;
	Coord(int x, int y){
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bustersPerPlayer = in.nextInt(); // the amount of busters you control
        int ghostCount = in.nextInt(); // the amount of ghosts on the map
        int myTeamId = in.nextInt(); // if this is 0, your base is on the top left of the map, if it is one, on the bottom right

        int buster[] = new int[bustersPerPlayer];
        int busterX[] = new int[bustersPerPlayer];
        int busterY[] = new int[bustersPerPlayer];
        int busterState[] = new int[bustersPerPlayer];
        int busterCarries[] = new int[bustersPerPlayer];
        
        int ghost[] = new int[ghostCount];
        int ghostX[] = new int[ghostCount];
        int ghostY[] = new int[ghostCount];
        int ghostState[] = new int[ghostCount];
        int ghostAttackedBy[] = new int[ghostCount];
        
        int opp[] = new int[bustersPerPlayer];
        int oppX[] = new int[bustersPerPlayer];
        int oppY[] = new int[bustersPerPlayer];
        int oppState[] = new int[bustersPerPlayer];
        int oppCarries[] = new int[bustersPerPlayer];
        
        // game loop
        while (true) {
            int entities = in.nextInt(); // the number of busters and ghosts visible to you
            for (int i = 0; i < entities; i++) {
                int entityId = in.nextInt(); // buster id or ghost id
                int x = in.nextInt();
                int y = in.nextInt(); // position of this buster / ghost
                int entityType = in.nextInt(); // the team id if it is a buster, -1 if it is a ghost.
                int state = in.nextInt(); // For busters: 0=idle, 1=carrying a ghost.
                int value = in.nextInt(); // For busters: Ghost id being carried. For ghosts: number of busters attempting to trap this ghost.
                if(entityType == -1) { // this is ghost
                	ghost[entityId] = entityId;
//                	ghostX[entityId] = 
                }
            }
            for (int i = 0; i < bustersPerPlayer; i++) {
            	if(i == 0) {
            		System.out.println("MOVE 8000 4500"); // MOVE x y | BUST id | RELEASE	
            	}else {
            		System.out.println("MOVE 0 0");
            	}
                
            }
        }
    }
    public static float getDistance(Coord a, Coord b) {
    	return (float) Math.sqrt(
                Math.pow(a.x - b.x, 2) +
                Math.pow(a.y - b.y, 2) );	
    }
}