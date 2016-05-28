package qingwaguohe;

public class Solution {
	public boolean check(char[] arr) {
		if (arr.length == 0) {
			return false;
		}
		
		boolean[][] dp = new boolean[arr.length][arr.length];
		//i 表示当前位置 ， v 表示velocity
		dp[0][1] = true;
		for ()
		dp[i][v] = dp[i - (v - 1)][v - 1] || dp[i - v][v] || dp[i - (v + 1)][v + 1];
	}
}
