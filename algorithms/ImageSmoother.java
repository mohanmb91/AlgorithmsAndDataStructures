package algorithms;

public class ImageSmoother {
	  public static int[][] imageSmoother(int[][] M) {
	        int rowM = M.length;
	        int colM = M[0].length;
	        int [][] result = new int[rowM][colM];
	        for(int i =0; i < rowM; i ++){
	            for(int j = 0; j < colM; j ++){
	                int row = i;
	                int col = j;
	                int count = 1;
	                int elementSum = M[row][col];
	                if(row - 1 >= 0){
	                    elementSum += M[row - 1][col];
	                    count ++;
	                    if(col + 1 < colM){
	                        elementSum += M[row - 1][col + 1];
	                        count ++;
	                    }    
	                }
	                if(col - 1 >= 0){
	                    elementSum += M[row][col - 1];
	                    count ++;
	                    if(row -1 >= 0){
	                        elementSum += M[row - 1][col - 1];
	                        count ++;
	                    }    
	                }
	                if(row + 1 < rowM){
	                    elementSum += M[row + 1][col];
	                    count ++;
	                    if(col - 1 >= 0){
	                        elementSum += M[row + 1][col - 1];
	                        count ++;
	                    }
	                }
	                if(col + 1 < colM){
	                    elementSum += M[row][col + 1];
	                    count ++;
	                    if(row + 1 < rowM){
	                        elementSum += M[row + 1][col + 1];
	                        count ++;
	                    }
	                }
	                result[row][col] = (elementSum / count) ;//Math.floor(temp);
	            }
	        }
	        return result;
	    }
	  
	  public static void main(String args[]) {
		  imageSmoother(new int[][]{
			  {2,3,4},
			  {5,6,7},
			  {8,9,10},
			  {11,12,13},
			  {14,15,16}
			  }
		  );
	  }
}
