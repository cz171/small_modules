package checkAna;

import java.util.Arrays;

public class Solution {
	public static boolean isPalindrome(String s) {
		int[] map = new int[256];
		for (char c: s.toCharArray()) {
			map[c] += 1;
		}
	
		int odd = 0;
		for (int counter: map) {
			if (counter % 2 != 0) {
				odd++;
				if (odd > 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		System.out.println(isPalindrome("abbdsds"));
	}

}
