package Trie;
import java.util.*;
public class Trie {
	class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean hasWord;
		
		public TrieNode() {
			children = new HashMap<>();
			hasWord = false;
		}
	}
	
	private TrieNode root;
	
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
		
		now.hasWord = true;
	}
	
	public boolean searchWord(String s) {
		TrieNode now = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!now.children.containsKey(c)) {
				return false;
			}
			
			now = now.children.get(c);
		}
		
		return now.hasWord;
	}
	
	public boolean searchPrefix(String s) {
		TrieNode now = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!now.children.containsKey(c)) {
				return false;
			}
			
			now = now.children.get(c);
		}
		
		return true;
	}
}
