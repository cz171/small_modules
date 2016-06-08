package triple;

public class Solution {
	public static boolean increasingTriplet(int[] nums) {
        //dp
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int[][] dp = new int[nums.length][nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            
            for (int j = nums.length - 1; j >= i; j--) {
                if (i == j) {
                    dp[i][j] = 1;
                    min = Math.min(min, nums[i]);
                    continue;
                }
                
                if (nums[i] < min) {
                    dp[i][j] = dp[i + 1][j] + 1;
                    min = Math.min(nums[i], min);

                    if (dp[i][j] == 2) {
                        return true;
                    }
                }
            }
        }
        return dp[0][nums.length - 1] >= 2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 2, 3, 4, 5};
		int[] nums2 = new int[] {5, 4, 3, 2, 1};
		int[] nums3 = new int[] {2, 1, 3, 2, 1};
		System.out.println(increasingTriplet(nums));
		System.out.println(increasingTriplet(nums2));
		System.out.println(increasingTriplet(nums3));


	}

}
