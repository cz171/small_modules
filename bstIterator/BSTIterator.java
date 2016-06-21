package bstIterator;
import java.util.*;

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
	public BSTIterator(TreeNode root) {
		pushAll(root);
	}
	
	boolean hasNext() {
		return !stack.isEmpty();
	}
	
	int next() {
		TreeNode n = stack.pop();
		pushAll(n.right);
		return n.val;
	}
	
	private void pushAll(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}
