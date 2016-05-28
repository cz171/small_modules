package maxResult;

public class Solution {
	public int maxResult(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int len = arr.length;
		int[][] dp = new int[len][len];
		int[][] dpMin = new int[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = arr[i];
					dpMin[i][j] = arr[i];
					continue;
				}
				
				if (i + 1 == j) {
					dp[i][j] = Math.max(arr[i] * arr[j], arr[i] + arr[j]);
					dpMin[i][j] = Math.min(arr[i] + arr[j], arr[i] * arr[j]);
					continue;
				}
				
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], 
							Math.max(dp[i][k] + dp[k + 1][j], dp[i][k] * dp[k + 1][j])
							);
					dpMin[i][j] = Math.min(dp[i][j],
							Math.min(dpMin[i][k] + dpMin[k + 1][j], dpMin[i][k] * dp[k + 1][j])
							);
				}
				
			}
		}
		
		return dp[0][len - 1];
	}
}
