package compareVersion;

class Solution {
    public static int compareVersion(String version1, String version2) {
        int startV1, endV1, startV2, endV2;
        startV1 = endV1 = startV2 = endV2 = 0;
        StringBuilder v1 = new StringBuilder("");
        StringBuilder v2 = new StringBuilder("");
        while(endV1 < version1.length() && endV2 < version2.length()){
            
            while(endV1 < version1.length() && version1.charAt(endV1) != '.'){
                v1.append(version1.charAt(endV1) + "");
                endV1++;
            }
            
            int num1 = pInt(v1.toString());
            
            while(endV2 < version2.length() && version2.charAt(endV2) != '.'){
                v2.append(version2.charAt(endV2) + "");
                endV2++;
            }
            
            int num2 = pInt(v2.toString());

            if(compareTwo(num1, num2) == 0){
                v1 = new StringBuilder("");
                v2 = new StringBuilder("");
                endV1++;
                endV2++;
            }
            else{
                return compareTwo(num1, num2);
            }
        }
        
        if(endV1 < version1.length()){
	        	while(endV1 < version1.length()) {
		    		while(endV1 < version1.length() && version1.charAt(endV1) != '.'){
	                v1.append(version1.charAt(endV1) + "");
	                endV1++;
	            }
		    		int num1 = pInt(v1.toString());
		    		if(num1 > 0) {
		    			return 1;
		    		}
		    		endV1++;
	        	}
        }else if(endV2 < version2.length()){
	        	while(endV2 < version2.length()) {
		    		while(endV2 < version2.length() && version2.charAt(endV2) != '.'){
	                v2.append(version2.charAt(endV2) + "");
	                endV2++;
	            }
		    		int num1 = pInt(v2.toString());
		    		if(num1 > 0) {
		    			return -1;
		    		}
		    		endV2++;
	        	}
        }
        return 0;
    }
    public static int compareTwo(int n1, int n2){
        if(n1 > n2){
            return 1;
        }else if(n2 > n1){
            return -1;
        }
        return 0;
    }
    public static int pInt(String input){
        if(input.equals("")) return 0;
        return Integer.parseInt(input);
    }
    public static void main(String args[]) {
    		compareVersion("1.0.1", "1");
    }
}