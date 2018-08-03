package microsoft;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Solution1{
    public static ListNode deleteNodeOdd(ListNode head){
        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;
        ListNode prevHeadTemp = prevHead;
    	if(prevHeadTemp.next == null) {
    		return null;
    	}else {
    		while(prevHeadTemp != null && prevHeadTemp.next != null) {
    			prevHeadTemp.next = prevHeadTemp.next.next;
    			prevHeadTemp = prevHeadTemp.next;
    		}
    	}
    	prevHead = prevHead.next;
        return prevHead;
    }

    public boolean runTests(ListNode h1, ListNode h2){
        if(h1 == null && h2 == null){
            return true;
        }else if(h1 != null && h2 == null){
        	return false;
        }else if(h1 == null && h2 != null){
        	return false;
        }
        else{
            while(h1 != null){
                if(h2 == null || h1.val != h2.val){
                    return false;
                }
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        return true;
    }
    public static void main(String args[]){
        boolean result = true;
        Solution1 instance = new Solution1();
        
        ListNode test1 = generateNNodes(5);
        ListNode output1 = new ListNode(2);
        output1.next = new ListNode(4);
     
        ListNode test2 = generateNNodes(0);
        ListNode output2 = null;
        
        ListNode test3 = generateNNodes(1);
        ListNode output3 = null;
        
        ListNode test4 = generateNNodes(2);
        ListNode output4 = new ListNode(2);
        
        ListNode test5 = generateNNodes(100);
        ListNode output5 = generateEvenNodes(100);
        
        result = result && instance.runTests(deleteNodeOdd(test1), output1);
        result = result && instance.runTests(deleteNodeOdd(test2), output2);
        result = result && instance.runTests(deleteNodeOdd(test3), output3);
        result = result && instance.runTests(deleteNodeOdd(test4), output4);
        result = result && instance.runTests(deleteNodeOdd(test5), output5);
        
        System.out.println(result? "success all test cases passed": "you have failing tests");
        System.out.println(Test());
        System.out.println(Test().equals("2\n3\n"));
    }

	private static ListNode generateEvenNodes(int n) {
		if(n == 0) { return null;}
		ListNode head = new ListNode(2);
		ListNode temp = head;
		if(n == 1) { return head;}
		for(int i = 4; i<= n; i+= 2) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		return head;
	}

	public static String Test() {
		return "2\n3\n";
	}
	private static ListNode generateNNodes(int n) {
		if(n == 0) { return null;}
		ListNode head = new ListNode(1);
		ListNode temp = head;
		if(n == 1) { return head;}
		for(int i = 2; i<= n; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		return head;
	}
}