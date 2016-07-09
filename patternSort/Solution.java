package patternSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int[] patternSort(int[] nums, int[] pattern) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < pattern.length; i++) {
			map.put(pattern[i], i);
		}
		
		Integer[] sorted = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sorted[i] = nums[i];
		}
		Arrays.sort(sorted, (a, b) -> {
			if (map.containsKey(a) || map.containsKey(b)) {
				if (map.containsKey(a) && map.containsKey(b)) {
					return map.get(a) - map.get(b);
				} else if (map.containsKey(a)) {
					return -1;
				} else {
					return 1;
				}
			}
			
			return a - b;
			
		});
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sorted[i];
		}
		
		return nums;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pattern = new int[] {5, 2, 3, 4};
		int[] nums = new int[] {2, 5, 5, 2, 3, 4, 4, 3, 1, -1, 9};
		System.out.println(Arrays.toString(patternSort(nums, pattern)));

	}

}
