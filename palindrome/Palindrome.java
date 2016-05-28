package palindrome;


public class Palindrome {
	/**
	 * least characters to be added to form a string
	 * if change the condition to change/add/delete character
	 */
	public int leastCharacters(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		
		int[][] dp = new int[s.length()][s.length()];
		int len = s.length();
		
		for (int first = len - 1; first >= 0; first--) {
			for (int last = first + 1; last < len; last++) {
				if (s.charAt(first) == s.charAt(last)) {
					dp[first][last] = dp[first + 1][last - 1];
				} else {
					dp[first][last] = Math.min(dp[first + 1][last - 1], 
							Math.min(dp[first][last - 1], dp[first + 1][last])
							) + 1;
				}
			}
		}
		
		return dp[0][len - 1];
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int len = s.length();
//		int[][] dp = new int[len][len];
//		
//		for (int first = len - 1; first >= 0; first--) {
//			for (int last = first + 1; last < len; last++) {
//				if (s.charAt(first) == s.charAt(last)) {
//					dp[first][last] = dp[first + 1][last - 1];
//					continue;
//				}
//				
//				dp[first][last] = Math.min(dp[first + 1][last - 1],
//						Math.min(dp[first + 1][last], dp[first][last - 1])) + 1;
//				
//			}
//		}
//		
//		return dp[0][len - 1];
//		
	}
	
}
