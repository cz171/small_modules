package bstToDoubleLL;
import java.util.*;
public class Solution {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	static class Node {
		int val;
		Node prev;
		Node next;
		public Node(int val) {
			this.val = val;
			prev = null;
			next = null;
		}
	}
	
	public static Node convertBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		Node dummy = new Node(-1);
		Node n = dummy;
		
		//iteratively do it
		Stack<TreeNode> s= new Stack<>();
		TreeNode curr = root;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			
			curr = s.pop();
			n.next = new Node(curr.val);
			n = n.next;
			curr = curr.right;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		//test
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(8);
		root.left = left;
		root.right = right;
		left.left = new TreeNode(2);
		left.right = new TreeNode(4);
		right.left = new TreeNode(7);
		right.right = new TreeNode(9);
	
		Node res = convertBST(root);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
