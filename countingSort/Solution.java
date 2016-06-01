package countingSort;

import java.util.Arrays;

//good for sorting k elements where range [1, k]
public class Solution {
	public static int[] countingSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[]{};
		}
		
		int[] res = new int[nums.length];
		int[] cnt = new int[nums.length];
		for (int num: nums) {
			cnt[num]++;
		}
		
//		int i = 0;
//		while (i < res.length) {
//			for (int j = 0; j < cnt.length; j++) {
//				while (cnt[j]-- > 0) {
//					res[i++] = j;
//				}
//			}
//		}
		
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i - 1];
		}
		int j = 0;
		for (int i = 0; i < cnt.length; i++) {
			while (j < cnt[i]) {
				res[j++] = i;
			}
		}
		
		return res;
	}
	
	// couting sort for every digit, sort from the last digit
	// int -32 bits
	public static int[] radixSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		
		int mask = nums[0].length;
		
	}
	
	public static void main(String[] args) {
		//test case
		int[] nums = new int[] {1, 2, 3, 1, 2, 3};
		System.out.println(Arrays.toString(countingSort(nums)));
	}

}
