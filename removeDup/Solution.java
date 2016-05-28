package removeDup;
import java.util.*;
public class Solution {
	public static String removeDup(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
//		//O(n) space, O(n) time
//		StringBuilder sb = new StringBuilder();
//		Set<Character> set = new HashSet<>();
//		for (char c: s.toCharArray()) {
//			if (!set.contains(c)) {
//				sb.append(c);
//				set.add(c);
//			} 
//		}
//		
//		return sb.toString();
		
		//O(1) space, O(nlogn) time
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		int first = 0;
		int second = 0;
		while (second < chars.length) {
			while (second < chars.length - 1 &&
					chars[second] == chars[second + 1]) {
				second++;
			} 
			
			chars[first] = chars[second];
			first++;
			second++;
		}
		
		String res = String.valueOf(chars);
		return res.substring(0, first);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test 
		String s = "cbadsab";
		System.out.println(removeDup(s));
	}

}
