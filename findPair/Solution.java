package findPair;
import java.util.*;
public class Solution {
/**
 * 题目就是给一个unsorted  positive integer array , 没有duplicate, 输出是一个integer 和 这个integer 后面第一个大于该integer的那个数。。。。说的不清楚，举个例子吧：. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴

    input(int[]): 4, 2, 6, 8
    output(List<String>): 4---6
                       2---6
                       6---8
                       8---  -1 (因为8后面没有大于8的element了，用-1表示)
 * @param args
 */
	
	public static List<String> findLargerPair(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			if (s.isEmpty() || s.peek() > nums[i]) {
				s.push(nums[i]);
				continue;
			} else if (s.peek() < nums[i]) {
				while (!s.isEmpty() && s.peek() < nums[i]) {
					StringBuilder sb = new StringBuilder();
					sb.append(s.pop()).append("--").append(nums[i]);
					res.add(sb.toString());
				}
				s.push(nums[i]);
			} 
		}
		
		while (!s.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.pop()).append("--").append(-1);
			res.add(sb.toString());
		}
		
		return res;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {
				4, 2, 6, 8
		};
		
		List<String> list = findLargerPair(nums);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
