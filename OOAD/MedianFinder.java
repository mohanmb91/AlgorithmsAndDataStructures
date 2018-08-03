package OOAD;

import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    List<Integer> list;
    public MedianFinder() {
         list = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
       list.add(num);
    }
    
    public double findMedian() {
        int n = list.size();
        double result = 0.0;
        if(n <= 2 ){
            if(n == 1){
                return pd(list.get(0));
            }else{
                return (pd(list.get(0)) + pd(list.get(1))) / 2.0;
            }
        }
        int temp = n /2;
        if(n %2 == 0) {
        	// 0 1 2 3
        		result = (pd(list.get(temp)) + pd(list.get(temp+1))) / 2.0;
        }else {
        		result = pd(list.get(temp));	
        }
        return result;
    }
    
    public double pd(int n){
        return Double.parseDouble(n+"");
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */