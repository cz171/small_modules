package bigestInt;

import java.util.Arrays;

public class Solution {
	//find biggest two integers in the array
	public static int[] find(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		
		if (nums.length == 1) {
			return new int[] {nums[0]};
		}
		
		if (nums.length == 2) {
			return new int[] {nums[0], nums[1]};
		}
		
		int biggest = Math.max(nums[0], nums[1]);
		int secondBig = Math.min(nums[0], nums[1]);
		
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] > biggest) {
				secondBig = biggest;
				biggest = nums[i];
			} else if (nums[i] > secondBig) {
				secondBig = nums[i];
			}
		}
		
		return new int[] {secondBig, biggest};
	}
	
	public static void main(String[] args) {
		//test case
		int[] nums = new int[] {2, 3, 4, 321, 32, 513};
		int[] nums1 = new int[] {2, 3, -1, 32, 10};
		System.out.println(Arrays.toString(find(nums)));
		System.out.println(Arrays.toString(find(nums1)));

	}

}
