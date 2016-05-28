package Trie;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		
		Trie t = new Trie();
		t.addWord("zhuluoji");
		t.addWord("zhuluoya");
		t.addWord("zhuluogou");
		System.out.println(t.searchPrefix("zhuluoji"));
		System.out.println(t.searchPrefix("zhuluoya"));
		System.out.println(t.searchPrefix("zhuluo"));
		System.out.println(t.searchWord("zhuluo"));
		System.out.println(t.searchWord("zhuluoji"));
		System.out.println(t.searchWord("zhuluoya"));
		
	}

}
