package wordBreak;

import java.util.HashSet;
import java.util.Set;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("lee");
		System.out.println(s.wordBreak("leetcode", dict));
	}

}
