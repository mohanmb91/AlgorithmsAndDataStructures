package contest76;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	
    public String similarRGB(String color) {
    		if(color.length() <= 1) {
    			return "";
    		}
    		HashMap<String, String> shortHands= new HashMap<String, String>();
    		shortHands.put("00", "0");
    		shortHands.put("11", "1");
    		shortHands.put("22", "2");
    		shortHands.put("33", "3");
    		shortHands.put("44", "4");
    		shortHands.put("55", "5");
    		shortHands.put("66", "6");
    		shortHands.put("77", "7");
    		shortHands.put("88", "8");
    		shortHands.put("99", "9");
    		shortHands.put("aa", "a");
    		shortHands.put("bb", "b");
    		shortHands.put("cc", "c");
    		shortHands.put("dd", "d");
    		shortHands.put("ee", "e");
    		shortHands.put("ff", "f");
    		
    		StringBuilder result = new StringBuilder("");
    		
    		if(color.length() >= 3) {
    			result.append("#");
    			result.append(findMinDifference(color.substring(1,3).toLowerCase(), shortHands));
    		}
    		if(color.length() >= 5) {
    			result.append(findMinDifference(color.substring(3,5).toLowerCase(), shortHands));
    		}
    		if(color.length() >= 7) {
    			result.append(findMinDifference(color.substring(5,7).toLowerCase(), shortHands));
    		}
        return result.toString();
    }
  
	private String findMinDifference(String RGB, HashMap<String, String> shortHands) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		String result = "";
		for(String eachKey: shortHands.keySet()) {
			if (Math.abs(Integer.parseInt(RGB, 16) - Integer.parseInt(eachKey, 16)) < min) {
				min = Math.abs(Integer.parseInt(RGB, 16) - Integer.parseInt(eachKey, 16));
				result = shortHands.get(eachKey);	
			} 
		}
		return result;
	}

	public static void main(String[] args) {
		Solution ob = new Solution();
		
		System.out.println(ob.similarRGB("#09f166"));

	}

}
