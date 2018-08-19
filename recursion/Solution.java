package recursion;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class Solution {
	// Input : 10
	// output: 1 2 3 4 5 6 7 8 9 10
	
	static void postOrder(Node root) {
	    if(root != null){
	        postOrder(root.left);
	        postOrder(root.right);
	        System.out.print(root.data+" ");
	    }
	}
	
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        postOrder(root);
    }
}
/*



*/