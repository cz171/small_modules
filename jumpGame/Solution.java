package jumpGame;
import junit.framework.Assert;
public class Solution {
	public static int minStep(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int last = 0;
		int curr = 0;
		int step = 0;
		for (int i = 0; i < nums.length; i++) {
			if (last < i) {
				last = curr;
				step++;
			} 
			
			curr = Math.max(curr, nums[i] + i);
		}
		
		return step;
	}
	
	public static void test() {
		int[] nums = new int[] {2, 3, 1, 1, 4};
		Assert.assertEquals(2, minStep(nums));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = new int[] {2, 3, 1, 1, 4};
//		System.out.println(minStep(nums));
		test();
	}

}
