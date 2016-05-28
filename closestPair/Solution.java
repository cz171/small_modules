package closestPair;
import java.util.Arrays;
public class Solution {
	public static int[] findPair(int[] nums) {
		int[] result = new int[] {-1, -1};
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int diff = Integer.MAX_VALUE;
		while (start < end) {
			if (nums[start] + nums[end] - 0 < diff) {
				result[0] = nums[start];
				result[1] = nums[end];
				diff = Math.abs(nums[start] + nums[end] - 0); 
			} 
			
			if (nums[start] + nums[end] < 0) {
				start++;
			} else {
				end--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//test case
		int[] nums = new int[] {-3, 2, 1, -4, -1};
		System.out.println(Arrays.toString(findPair(nums)));
	}
}
