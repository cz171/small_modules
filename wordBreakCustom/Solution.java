package wordBreakCustom;
import java.util.*;

public class Solution {
	//can be memorized
	//shorten the runtime from O(2^n) to O(n^2)
	public static String wordBreak(Set<String> dict, String s, Map<String, String> map) {
		if (dict.contains(s)) {
			return s;
		}
		
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		for (int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = s.substring(i);
				String segSuffix = wordBreak(dict, suffix, map);
				if (segSuffix != null) {
					map.put(s, prefix + " " + segSuffix);
					return prefix + " " + segSuffix;
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		dict.add("good");
		Map<String, String> map = new HashMap<>();
		System.out.println(wordBreak(dict, "leetcodegood", map));
	}

}
