package BST;

import java.util.Arrays;

import BST.Solution.Node;

public class Test {

	public static void main(String[] args) {
		//test
		Solution s = new Solution();
		Node root = s.construct();
		System.out.println(s.traverse(root).toString());
		System.out.println(s.lca(root, root.right.left, root.right).val);
		System.out.println(s.findShortedDist(root, root.right.left, root.right.right));
		System.out.println(s.isBST(root));

	}



}
