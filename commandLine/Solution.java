package commandLine;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.addWord("php");
		t.addWord("phpk");
		System.out.println(t.search("p"));
		
	}
	
}
