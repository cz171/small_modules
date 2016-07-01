package checkPalindrome;
import java.util.*;

public class Solution {
//Given a list ofstrings, return all pairs of strings that can make a palindrome.  高频
	public static List<String[]> findPalindrome(String[] strs) {
		List<String[]> list = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return list;
		}

		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				if (i == j) {
					continue;
				}
				
				if (isPalindrome(strs[i] + strs[j])) { 
					list.add(new String[] {strs[i], strs[j]});
				} else if (isPalindrome(strs[j] + strs[i])){
					list.add(new String[] {strs[j], strs[i]});
				}				
			}
		}
		
		return list;
		
	}
	
	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] strs = {
				"abc",
				"ca",
				"ac",
				"ba"
		};
		
		List<String[]> list = findPalindrome(strs);
		for (String[] pair: list) {
			System.out.println(pair[0] + " " + pair[1]);
		}
	}

}
