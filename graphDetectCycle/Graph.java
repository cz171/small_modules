package graphDetectCycle;
import java.util.*;
public class Graph {
	/**
	 *    1
	 *   / \
	 *  2 - 4 
	 *   \ 
	 *    3
	 *    
	 *    Detect cycle in directed graph
	 */
	
	/*
	 * construct graph
	 * 
	 */
	
	public static Node construct() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		Node node3 = new Node(3);
		
		node1.neighbors.add(node2);
		node2.neighbors.add(node3);
		node1.neighbors.add(node4);
		
		return node1;
	}
	
	public static boolean hasCycle(Node node) {
		Set<Node> stack = new HashSet<>();
		return helper(node, stack);
	}
	
	public static boolean helper(Node node, Set<Node> stack) {
		stack.add(node);
		boolean hasCycle = false;
		for (Node neighbor : node.neighbors) {
			if (stack.contains(neighbor)) {
				return true;
			}
			hasCycle = hasCycle || helper(neighbor, stack);
		}
		
		stack.remove(node);
		return hasCycle;
	}
	
	public static void main(String[] args) {
		Node node = construct();
		System.out.println(hasCycle(node));
	}
}
