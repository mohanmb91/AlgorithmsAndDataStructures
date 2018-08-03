package algorithms;

import java.util.*;

class MedianFinder {

    static PriorityQueue<Integer> highers= null;
    static PriorityQueue<Integer> lowers= null;
    public MedianFinder() {
        lowers = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return -1 * a.compareTo(b);
            }
        });
        highers = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        // add number
        addNumberIntoHeap(num);
        // load Balance
        loadBalance();
    }
    
    public void addNumberIntoHeap(int num){
        if(lowers.size() == 0 || num < lowers.peek()){
            lowers.add(num);
        }else{
            highers.add(num);
        }
    }
    
    public void loadBalance(){
        PriorityQueue<Integer> biggers = (highers.size() > lowers.size())? highers: lowers;
        PriorityQueue<Integer> smallers = (highers.size() > lowers.size())? lowers: highers;
        int s1 = biggers.size();
        int s2 = smallers.size();
        int diff = s1 - s2;
        if(diff >= 2){
            smallers.add(biggers.poll());
        }
    }
    
    public double findMedian() {
        PriorityQueue<Integer> biggers = (highers.size() > lowers.size())? highers: lowers;
        PriorityQueue<Integer> smallers = (highers.size() > lowers.size())? lowers: highers;
        if(biggers.size() == 0){
            return 0.0;
        }
        if(biggers.size() == smallers.size()){
            int n1 = biggers.peek();
            int n2 = smallers.peek();
            return ((double) (n1 + n2))/ 2;
        }else{
            return (double) biggers.peek();
        }
    }
    
    public static void main(String args[]) {
    		MedianFinder obj = new MedianFinder();
    		obj.addNum(-1);
    		System.out.println(obj.findMedian());
    		obj.addNum(-2);
    		System.out.println(obj.findMedian());
    		obj.addNum(-3);
    		System.out.println(obj.findMedian());
    		obj.addNum(-4);
    		System.out.println(obj.findMedian());
    		obj.addNum(-5);
    		System.out.println(obj.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */