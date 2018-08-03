package contest85;

public class Solution {
	
	 public String pushDominoes(String d) {
	        int N = d.length();
	        char chDo[] = d.toCharArray();
	        int distance[] = new int[d.length()];
	        for(int i=0; i<N; i++){
	            char c = chDo[i];
	            if(c == 'R'){
	                int temp = i;
	                temp ++;
	                int count = 0;
	                while(temp < N){
	                	if(chDo[temp] == '.') {
	                		count ++;
	                	}
	                	else if(chDo[temp] == 'R'){
	                		distance[i] = count;
	                		count = 0;
	                        i = temp;
	                    }
	                	else if(chDo[temp] == 'L') {
	                		distance[i] = count/2;
	                		count = 0;
	                        i = temp;
	                        break;
	                	}
	                    temp ++;
	                }
	                if(temp == N) {
	                	distance[i] = count;
	                }
	            }
	        }
	        for(int i=N-1; i >= 0; i--){
	        	char c = chDo[i];
	        	if(c == 'L'){
	                int temp = i;
	                temp --;
	                int count = 0;
	                while(temp >= 0){
	                	if(chDo[temp] == '.') {
	                		count ++;
	                	}
	                	else if(chDo[temp] == 'L'){
	                		distance[i] = -1 * count;
	                		count = 0;
	                        i = temp;
	                    }
	                	else if(chDo[temp] == 'R') {
	                		distance[i] = -1 * (count/2);
	                		count = 0;
	                        i = temp;
	                        break;
	                	}
	                    temp --;
	                }
	                if(temp == -1) {
	                	distance[i] = -1 * count;
	                }
	            }
	        }
	        
	        for(int i=0; i < distance.length; i ++){
	        	int val = distance[i];
	        	int temp = i;
	        	if(val > 0) {
	        		while(val> 0) {
	        			temp ++;
	        			chDo[temp] = 'R';
	        			val --;
	        		}
	        	}
	        	else if(val < 0) {
	        		while(val < 0) {
		        		temp --;
		    			chDo[temp] = 'L';
		    			val ++;
	        		}
	        	}
	        }
	        return chDo.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution ob = new Solution();
		ob.pushDominoes(".L.R...LR..L.."); // 034  5
	}

}
