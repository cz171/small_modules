package bstToLL;
import java.util.*;

public class Solution {
	public static Node bstToLL(TreeNode root) {
		//inorder traversal of bst
		if (root == null) {
			return null;
		}
		
		Stack<TreeNode> s = new Stack<>();
		Node dummy = new Node(-1);
		Node left = dummy;
		TreeNode curr = root;
		while (curr != null) {
			s.push(curr);
			curr = curr.left;
		}
			
		while (!s.isEmpty()) {
			curr = s.pop();
			left.next = new Node(curr.val);
			left = left.next;
			if (curr.right != null) {
				s.push(curr.right);
			}
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(5);
		n.left = new TreeNode(2);
		n.left.left = new TreeNode(1);
		n.left.right = new TreeNode(4);
		n.right = new TreeNode(7);
		Node node = bstToLL(n);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
