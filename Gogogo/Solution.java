package Gogogo;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
	public static ArrayList<String> reOrder(String[] strs, char[] rule) {
		ArrayList<String> result = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return result;
		}
		
		//first f
		// second a
		//f < a
		char first = rule[0];
		char second = rule[1];
		
		for (String s: strs) {
			if (s.isEmpty()) {
				continue;
			}
			
			String newStr = ""; 
			if (s.contains(String.valueOf(first))) {
				newStr = s.replaceAll(String.valueOf(first), "");
			}
			
			int left = s.length() - newStr.length();
			int i = 0;
			for (i = 0; i < newStr.length(); i++) {
				if (newStr.charAt(i) > second) {
					break;
				}
			}
			
			i--;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < left; j++) {
				sb.append(first);
			}
			
			newStr = newStr.substring(0, i) + sb.toString() +
					(i == newStr.length() ? "" : newStr.substring(i));
			
			result.add(newStr);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] test = {"aff", "acf", "fff", "aaa"};
		char[] rule = {'f', 'a'};
		ArrayList<String> result = reOrder(test, rule);
		for (String s: result) {
			System.out.println(s);
		}
	}
}
