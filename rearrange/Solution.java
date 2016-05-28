package rearrange;
import java.util.*;
public class Solution {
	public static String reArrange(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c,  0);
			}
			
			map.put(c, map.get(c) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0; // count key - 0

		while (true) {	
			cnt = 0;
			for (char c: map.keySet()) {
				if (map.get(c) > 0) {
					sb.append(c);
					map.put(c, map.get(c) - 1);
				} else {
					cnt++;
				}
			}
			if (cnt == map.size()) {
				break;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test
		String s = "aaabbccc";
		System.out.println(reArrange(s));

	}

}
