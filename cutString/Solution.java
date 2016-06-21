package cutString;
import java.util.*;
public class Solution {
	/**
	 * 给一个String，每个char是一个数字，再给一个target int，
	 * 要求切分String，使得切分后组成的数字的和等于target。
	 * 可以切分任意次
	 * @param args
	 */
	public static List<Integer> cutString(String s, int target, Map<String, List<Integer>> map) {
		List<Integer> res = new ArrayList<>();
		if (target < 0) {
			return res;
		}
		
		if (Integer.valueOf(s) == target) {
			res.add(Integer.valueOf(s));
			return res;
		}
		
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		for (int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			int val = Integer.valueOf(prefix);
			res.add(val);
			List<Integer> suffix = cutString(s.substring(i), target - val, map);
			
			if (suffix.size() > 0) {
				res.addAll(suffix);
				map.put(s, res);
				return res;
			}
			
			res.remove(res.size() - 1);
		}
		
		return new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		List<Integer> res = cutString("123456", 102, new HashMap<String, List<Integer>>());
		System.out.println(Arrays.toString(res.toArray()));
	}

}
