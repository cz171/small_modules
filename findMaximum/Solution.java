package findMaximum;

public class Solution {
	//给一个double array， 让输出能使用＊，＋， 以及（）得到的maximum。 follow up，如果有<0的怎么处理
	public static double findMax(double[] nums) {
		//dp
		//[1, 2, 4]
		int len = nums.length;
		double[][] dp = new double[len][len];
		//i, j 表示nums[i]  -  nums[j] 所能表示的最大的值
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = nums[i];
					continue;
				}
				
				if (i + 1 == j) {
					dp[i][j] = Math.max(nums[i] + nums[j], nums[i] * nums[j]);
					continue;
				}
				
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], 
							Math.max(dp[i][k] * dp[k + 1][j], dp[i][k] * dp[k + 1][j])
							);
				}
			}
		}
		return dp[0][len - 1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] nums = new double[] { 1, 2, 1, 2};
		System.out.println(findMax(nums));
	}

}
