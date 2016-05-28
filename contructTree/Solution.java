package contructTree;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	static class TreeNode {
		int indegree;
		int outdegree;
		TreeNode left;
		TreeNode right;
		String val;
		List<TreeNode> children;
		public TreeNode(String val) {
			this.val = val;
			left = null;
			right = null;
			indegree = 0;
			outdegree = 0;
			children = new ArrayList<>();
		}	
		
		public boolean equals(Object obj) {
            if(obj == this) return true;
            if(obj == null || obj.getClass() != this.getClass()) {
            	return false;
            }
            TreeNode node = (TreeNode) obj;
            return node.val == this.val;
		}
	}
	
	Map<String, TreeNode> tree = new HashMap<>();
	TreeNode root;
	
	public boolean constructTree(String s) {
		 List<List<String>> list = new ArrayList<>();
         List<String> edges = new ArrayList<String>();
         Pattern regex = Pattern.compile("\\((.*?)\\)");
         Matcher regexMatcher = regex.matcher(s);
         while (regexMatcher.find()) { //Finds Matching Pattern in String
                 edges.add(regexMatcher.group(1)); //Fetching Group from String
         }
         
         System.out.println(edges);
         for (String edge: edges) {
        	 String[] nodes = edge.split(",");
        	 if (!tree.containsKey(nodes[0])) {
        		 tree.put(nodes[0], new TreeNode(nodes[0]));
        	 }
        	 
        	 if (!tree.containsKey(nodes[1])) {
        		 tree.put(nodes[1], new TreeNode(nodes[1]));
        	 }
        	 
        	 TreeNode pNode = tree.get(nodes[0]);
        	 TreeNode cNode = tree.get(nodes[1]);
        	 
        	 if (pNode.equals(cNode) || cNode.children.contains(pNode) || cNode.indegree >= 2) {
        		 return false;
        	 }
        	 
        	 pNode.children.add(cNode);
        	 cNode.indegree += 1;
        	 pNode.outdegree += 1;
         }
         
         int cc = 0; //num of connected components
         for (TreeNode n: tree.values()) {
        	 if (n.indegree == 0) {
        		 root = n;
        		 cc++;
        	 }
         }
         
         return cc == 1;
     }
	
	public void inorderPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (root.children.size() > 0) {
			inorderPrint(root.children.get(0));
		}
		System.out.println(root.val);
		if (root.children.size() > 1) {
			inorderPrint(root.children.get(1));
		}
	}
}
