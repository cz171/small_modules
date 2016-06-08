package shortestPalindrome;

public class Solution {
	public static String shortestPalindrome(String s) {
        //find the longest palindrome from the begining, 
        //then reverse the left part, add it to the 
        //front part of the string
        if (s.isEmpty()) {
            return "";
        }
        
        int i = 0;
        int j = s.length() - 1;
        int end = j;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                j = --end;
                i = 0;
            }
        }
        
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindrome("abcd"));


	}

}
