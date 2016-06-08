package wordPattern;

public class Test {
	public static void main(String[] args) {
		wordPattern p = new wordPattern();
		System.out.println(p.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(p.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(p.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}
}
