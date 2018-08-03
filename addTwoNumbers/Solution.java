package addTwoNumbers;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean isCarryFlag = false;
		ListNode head = l1;
		while(true){
			l1.val += l2.val;
			if(isCarryFlag){
				l1.val += 1;
				isCarryFlag = false;
			}
			if(l1.val > 9){
				isCarryFlag = true;
				l1.val = l1.val % 10;
			}
			if(l1.next == null || l2.next == null){ break; }
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1.next == null){ 
			l1.next = l2.next; 
		}
		l1 = l1.next;
		while(l1 != null){
			if(isCarryFlag){
				l1.val += 1;
				isCarryFlag = false;
			}
			if(l1.val > 9){
				isCarryFlag = true;
				l1.val = l1.val % 10;
			}
			if(l1.next == null || !isCarryFlag){ break; }
			l1 = l1.next;
		}
		if(isCarryFlag){
			l1.next = new ListNode(1);
		}
		return head;
	}
}
