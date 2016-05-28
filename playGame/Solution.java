package playGame;
public class Solution {
	public int getMax(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
		}
		
		int len = 2;
		while (len < nums.length) {
			for (int i = 0; len + i < nums.length; i++) {
				int takeFirst = nums[i] + 
						(nums[i + 1] > nums[i + len] ? dp[i + 2][i + len] : dp[i + 1][i + len - 1]);
				int takeSecond = nums[i + len] +
						(nums[i] > nums[i + len - 1] ? dp[i + 1][i + len - 1] : dp[i][i + len - 2]);
				dp[i][i + len] = Math.max(takeFirst, takeSecond);
			}
			len++;
		}
		
		return dp[0][nums.length - 1];
	}
	
	
}	
