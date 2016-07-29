package isFullCycle;

public class Solution {
	public static boolean isFullCycle(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		
		int n = nums.length;
		int component = 0;
		for (int i = 0; i < n; i++) {
			component =  (component + nums[component]) % n;
			component = component >= 0 ? component : component + n;
		}
		
		return component == 0;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {
				2, -1, -1 
		};
//		System.out.println(isFullCycle(nums));
		
		int[] nums2 = new int[] {
				-1, -1, 2
		};
		System.out.println(isFullCycle(nums2));

	}
}
