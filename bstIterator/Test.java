package bstIterator;

public class Test {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		BSTIterator iter = new BSTIterator(root);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
