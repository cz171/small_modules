package findDistBetweenNode;

public class BST {
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		
		if (left != null && right != null) {
			return root;
		}
		
		return left == null ? right : left;
	}
	
	public int findDist(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lca = LCA(root, p, q);
		return dist(lca, p) + dist(lca, q);
	}
	
	private int dist(TreeNode root, TreeNode p) {
		if (root == p) {
			return 0;
		}
		
		if (root == null) {
			return -1;
		}
		
		int left = dist(root.left, p);
		int right = dist(root.right, p);
		
		if (left == -1 && right == -1) {
			return -1;
		}
		
		return left == -1 ? right + 1: left + 1;
		
	}
}
