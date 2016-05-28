package commandLine;
import java.util.*;
public class Solution {
	class TrieNode {
		boolean hasWord;
		HashMap<Character, TrieNode> children;
		public TrieNode() {
			hasWord = false;
			children = new HashMap<>();
		}
	}
	
	TrieNode root;
	public Solution() {
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode now = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!now.children.containsKey(c)) {
				now.children.put(c, new TrieNode());
			}
			
			now = now.children.get(c);
		}
		
		now.hasWord = true;
	}
	
	public ArrayList<String> getWord(String prefix) {
		ArrayList<String> wordList = new ArrayList<>();
		find(prefix, 0, root, wordList);
		return wordList;
	}
	
	public void find(String prefix, int index, TrieNode now, ArrayList<String> wordList) {
		if (index == prefix.length()) {
			if (now.children.size() == 0) {
				wordList.add(prefix);
			}
			return;
		}
		
		char c = word.charAt(index);
		if (now.children.containsKey())
	}
	
}
