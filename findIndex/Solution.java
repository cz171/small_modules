package findIndex;
import java.util.Arrays;
import java.util.Comparator;
public class Solution {
	/*
	 * Give you an array of integers: A
	Goal is to find three indexes (i,j,k) such that
   A[i] + A[j] == A[k]

	For Example:
   A = [ -5, 10, 1, 8, -2 ]
	10 + -2 == 8
    Good answer: i=1, j=4, k=3
	 */
	//很简单， 原来得对于取每个元素， 然后再次遍历 O(n^3)
	//可以sort, 取元素， 然后从头从尾指针向中间移动， 记得跳过该元素本身
	
	static class Map {
		int index;
		int value;
		public Map(int value, int index) {
			this.index = index;
			this.value = value;
		}
	}
	
	public static int[] findTriple(int[] nums) {
		int[] result = new int[] {-1, -1, -1};
		if (nums == null || nums.length < 3) {
			return result;
		}
		
		Map[] arrays = new Map[nums.length];
		for (int i = 0; i < nums.length; i++) {
			Map m = new Map(nums[i], i);
			arrays[i] = m;
		}
		
		Arrays.sort(arrays, new Comparator<Map>() {
			public int compare(Map m1, Map m2) {
				return m1.value - m2.value;
			}
		});
		
		
		for (int i = arrays.length - 1; i >= 2; i--) {
			int target =  arrays[i].value;
			int start = 0;
			int end = arrays.length - 1;
			while (start < end) {
				if (end == i) {
					end--;
					continue;
				}
				
				if (start == i) {
					start++;
					continue;
				}
				
				if (arrays[start].value + arrays[end].value < target) {
					start++;
				} else if (arrays[start].value + arrays[end].value > target) {
					end--;
				} else {
					result[0] = arrays[start].index;
					result[1] = arrays[end].index;
					result[2] = arrays[i].index;
					return result;
				}
			}
		}
		
		return result;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { -5, 10, 1, 8, -2 };
		System.out.println(Arrays.toString(findTriple(A)));
	}

}
