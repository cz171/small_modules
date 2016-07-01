package findMedian;
import java.util.*;
public class Solution {
	//给定一个list of sorted integer arrays，要求找所有的数的median
	//e.g. [1,3,6,7,9], [2,4], [5], return 5
	static class Node {
		int pIndex;
		int index;
		int val;
		public Node(int pIndex, int index, int val) {
			this.pIndex = pIndex;
			this.index = index;
			this.val = val;
		}
	}
	
//	public static int findMedian(List<List<Integer>> lists) {
//		if (list == null || list.size() == 0) {
//			return 0;
//		}
//		
//		int size = 0;
//		for (List<Integer> list: lists) { 
//			size += list.size();
//		}
//		
//		Queue<Node> q = new PriorityQueue<>(size / 2);
//		for (int i = 0;)
//	}
	
	//find median of two sorted array
	public static double findMedian(int[] nums1, int[] nums2) {
		//find kth number
		int len = nums1.length + nums2.length;
		if (len % 2 == 0) {
			return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
		}
		return (double) findKth(nums1, 0, nums2, 0, len / 2);
	}
	
	private static int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		if (start1 >= nums1.length) {
			return nums2[start2 + k - 1];
		}
		
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		
		int key1 = start1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
		int key2 = start2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];
		
		if (key1 < key2) {
			return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
		} else {
			return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {
				1, 2, 3, 4, 5
		};
		int[] nums2 = new int[] {
				3, 5, 6, 7, 10
		};
		
		System.out.println(findMedian(nums1, nums2));
	}

}
