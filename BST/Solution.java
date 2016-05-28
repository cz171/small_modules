package BST;
import java.util.*;
public class Solution {
	class Node {
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public Node construct() {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(8);
		root.left.left = new Node(1);
		root.left.right = new Node(5);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		return root;
	}
	
	public ArrayList<Integer> traverse(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		
//		ArrayList<Integer> left = traverse(root.left);
//		ArrayList<Integer> right = traverse(root.right);
//		
//		result.addAll(left);
//		result.add(root.val);
//		result.addAll(right);
//		return result;
		//iteratively
		Stack<Node> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}
		
		return result;
		
	}
	
	public int[] findSumK(Node root, int k) {
		//inorder traversal
//		Stack<Integer> 
		int[] result = new int[] {-1, -1};
		if (root == null) {
			return result;
		}
		ArrayList<Integer> inorder = traverse(root);
		int start = 0, end = inorder.size() - 1;
		while (start < end) {
			int left = inorder.get(start);
			int right = inorder.get(end);
			if (left + right == k) {
				result[0] = left;
				result[1] = right;
				return result;
			} 
			
			if (left + right < k) {
				start++;
			} else {
				end--;
			}
		}
		
		return result;
	}
	
	public Node lca(Node root, Node a, Node b) {
		if (root == null || root == a || root == b) {
			return root;
		}
		
		Node left = lca(root.left, a, b);
		Node right = lca(root.right, a, b);
		
		if (left != null && right != null) {
			return root;
		}
		
		return left == null ? right: left; 
	}
	
	public int findShortedDist(Node root, Node a, Node b) {
		Node ancestor = lca(root, a, b);
		if (ancestor == null) {
			return 0;
		}
		
		return dist(ancestor, a) + dist(ancestor, b);
		
	}
	
	private int dist(Node root, Node b) {
		if (root == b || root == null) {
			return 0;
		}
		
		return Math.min(dist(root.left, b), dist(root.right, b)) + 1;
	}
	
	// right most node<= root,
	// 
	boolean isBST(Node root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);		
	}
	
	private boolean helper(Node root, int min, int max) {
		 if (root == null) {
			 return true;
		 }
		 
		 if (root.val < min || root.val > max) {
			 return false;
		 }
		 
		 return helper(root.left, min, root.val - 1) &&
				 helper(root.right, root.val + 1, max);
	}
}
