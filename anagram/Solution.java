package anagram;
import java.util.*;

public class Solution {
//	//Given an array of Strings, determine if a string and anagram pair exists.  
//	public static boolean hasAnagram(String[] strs) {
//		if (strs == null || strs.length == 0) {
//			return false;
//		}
//		
//		//O(n) ， but cannot solve when duplicates are contained
//		Set<Integer> set = new HashSet<>();
//		for (String s: strs) {
//			int mask = getMask(s);
//			if (set.contains(mask)) {
//				return true;
//			}
//			set.add(mask);
//		}
//		
//		return false;
//	}
//	
//	private static int getMask(String s) {
//		int res = 0;
//		for (char c: s.toCharArray()) {
//			res |= (1 << (c - '0'));
//		}
//		
//		System.out.println(res);
//		return res;
//	}
	
	public static boolean hasAnagram(String[] strs) {
		Set<String> set = new HashSet<>();
		String[] copy = Arrays.copyOf(strs, strs.length);
		for (int i = 0; i < copy.length; i++) {
			char[] chars = copy[i].toCharArray();
			Arrays.sort(chars);
			String s = String.valueOf(chars);
			if (set.contains(s)) {
				return true;
			}
			set.add(s);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// test
		String[] strs = {"abc", "dasa", "dsa", "dsada"};
		System.out.println(hasAnagram(strs));
	}

}
