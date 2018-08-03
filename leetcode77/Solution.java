package leetcode77;

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if(S.length() == 1){
            return new int[]{1, widths[ S.charAt(0) - 97 ]};
        }
        int lineCount = 0;
        int spaceOccupied = 100;
        for(int i=0; i< S.length(); i++){
            if(spaceOccupied + widths[ S.charAt(i) - 97 ] > 100) {
            		lineCount += 1;
            		spaceOccupied = widths[ S.charAt(i) - 97 ];
            }else {
            		spaceOccupied += widths[ S.charAt(i) - 97 ];
            }
        }
        return new int[]{lineCount, spaceOccupied};
    }
    public static void main(String[] args) {
    		Solution ob = new Solution();
    		ob.numberOfLines(new int[] {4, 10, 10, 10 , 10 }, "bbbcccdddaaa");
	}
}
