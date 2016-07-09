package findDistBetweenNode;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(4);
		
		BST bst = new BST();
		System.out.println(bst.findDist(root, root.left.left, root.right));
	}

}
