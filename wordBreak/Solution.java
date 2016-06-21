package wordBreak;
import java.util.*;
public class Solution {
	public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> words = new ArrayList<String>();

        int len = s.length();
        for (int i = 1; i <= len; i++) {
            String pref = s.substring(0, i);
            if (dict.contains(pref)) {
                if (i == len) {
                	words.add(pref);
                }
                else {
                    String remain = s.substring(i, len);
                    List<String> remainDecomp = wordBreak(remain, dict);
                    if (remainDecomp != null) { // has decompositions
                        for (String item : remainDecomp) {
                            words.add(pref + " " + item);
                        }
                    }
                }
            }
        }
        return words;
    }
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		dict.add("break");
		dict.add("codebreak");

		
		System.out.println(wordBreak("leetcodebreak", dict));

		
	}
	
	
}
