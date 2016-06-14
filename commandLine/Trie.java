package commandLine;
import java.util.*;
public class Trie {
	class Node {
		String s;
		TrieNode node;
		public Node(String s, TrieNode node) {
			this.s = s;
			this.node = node;
		}
	}
	
	class TrieNode {
		boolean isLeaf;
		Map<Character, TrieNode> children;
		public TrieNode() {
			isLeaf = false;
			children = new HashMap<>();
		}
	}
	
	TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	public void addWord(String s) {
		TrieNode now = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!now.children.containsKey(c)) {
				now.children.put(c, new TrieNode());
			}
			now = now.children.get(c);
		}
		now.isLeaf = true;
	}
	
	public String search(String prefix) {
		TrieNode now = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (!now.children.containsKey(c)) {
				return "";
			}
			now = now.children.get(c);
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(prefix, now));
		
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			String s = n.s;
			TrieNode tNode = n.node;
			
			if (tNode.isLeaf) {
				return s;
			} 
			
			for (char c: tNode.children.keySet()) {
				queue.offer(new Node(s + String.valueOf(c), tNode.children.get(c))); 
			}
		}
		
		return "";
	}
	
}
