package algorithms;
import java.util.*;

class Node{
	Node left;
	Node right;
	int value;
	public Node(int value){
		this.value = value;
	}
}
class  Tree{
	Node rootNode;
	public Tree(){
		rootNode  = null;
	}
	public Tree(int val){
		rootNode = new Node(val);
	}
	public Node insert(Node root, Node node){	
		if(root == null){
			return node;
		}else{
			if(root.value > node.value){
				root.left = insert(root.left, node);
			}else{
				root.right = insert(root.right, node);
			}
			return root;
		}
	}

	public void print(){
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(this.rootNode);
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			if(current.left != null){
				frontier.add(current.left);
			}
			if(current.right != null){
				frontier.add(current.right);
			}
			System.out.println("**"+ current.value);
		}
	}
}
class MergeTwoBst{
	public static void main(String args[]){
		Tree tree = new Tree(10);
		tree.insert(tree.rootNode, new Node(5));
		tree.insert(tree.rootNode, new Node(15));
		tree.insert(tree.rootNode, new Node(4));
		tree.print();
		System.out.println("=======>");
		Tree tree1 = new Tree(10);
		tree1.insert(tree1.rootNode, new Node(5));
		tree1.insert(tree1.rootNode, new Node(15));
		tree1.insert(tree1.rootNode, new Node(8));
		tree1.insert(tree1.rootNode, new Node(18));
		tree1.print();

	}
	public Node mergeBst(Node treeRoot1, Node treeRoot2){

		return null;
	}
}
