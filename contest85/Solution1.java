package contest85;

class Rect{
    Point bl;
    Point tr;
    Rect(Point bl, Point tr){
        this.bl = bl;
        this.tr = tr;
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution1 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Rect r1 = new Rect(new Point(rec1[0], rec1[1]), new Point(rec1[2], rec1[3]));
        Rect r2 = new Rect(new Point(rec2[0], rec2[1]), new Point(rec2[2], rec2[3]));
        int xLow = Math.min(r1.bl.x, r1.tr.x);
        int xHigh = Math.max(r1.bl.x, r1.tr.x);
        int yLow = Math.min(r1.bl.y, r1.tr.y);
        int yHigh = Math.max(r1.bl.y, r1.tr.y);
        
        if(r2.bl.x > xLow && r2.bl.x < xHigh && r2.bl.y > yLow && r2.bl.y < yHigh){
            return true;
        }
        if(r2.tr.x > xLow && r2.tr.x < xHigh && r2.tr.y > yLow && r2.tr.y < yHigh){
            return true;
        }
        return false;
    } 

	public static void main(String[] args) {
		Solution1 ob = new Solution1();
		ob.isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20});

	}

}
