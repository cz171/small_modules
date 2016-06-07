package intArraySum;
import java.util.*;
public class Solution {
	//given two int array to represent two integers, return an array to represent the sum
	public static int[] sum(int[] nums1, int[] nums2) {
		int i = nums1.length - 1;
		int j = nums2.length - 1;
		int carry = 0;
		ArrayList<Integer> res = new ArrayList<>();
		while (i >= 0 && j >= 0) {
			int sum = nums1[i--] + nums2[j--] + carry;
			carry = sum / 10;
			res.add(sum % 10);
		}
		
		while (i >= 0) {
			int sum = nums1[i--] + carry;
			carry = sum / 10;
			res.add(sum % 10);
		}
		
		while (j >= 0) {
			int sum = nums2[j--] + carry;
			carry = sum / 10;
			res.add(sum % 10);
		}
		
		if (carry == 1) {
			res.add(1);
		}
		
		int[] result = new int[res.size()];
		for (int index = result.length - 1; index >= 0; index--) {
			result[index] = res.get(res.size() - index - 1);
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3};
		int[] nums2 = new int[] {8, 8, 7};
		System.out.println(Arrays.toString(sum(nums1, nums2)));
		
	}
}
