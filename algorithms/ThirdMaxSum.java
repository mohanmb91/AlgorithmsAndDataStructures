package algorithms;

import java.util.TreeSet;

public class ThirdMaxSum {
    public int thirdMax(int[] nums) {
        int maxResult = -1;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i =0; i < nums.length; i ++){
            int element = nums[i];
            if(!set.contains(element)){
                set.add(element);
            }
        }
        int count = 0;
        for(int eachElement: set.descendingSet()){
        		count += 1;
        		if(count <= 3) {
        			maxResult = eachElement;
        			continue;
        		}
        		break;
    		}
        return maxResult;
    }

}
