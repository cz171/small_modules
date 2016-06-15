package canWinGame;

public class Solution {
	// 两个人从1-N里面不重复地取数出来加在同一个sum上，第一个超过target的人赢，求先手是不是能赢。 写的暴力recursive
	public static boolean canWin(int n, boolean[] visited, int sum, int target) {
		boolean result = false;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			sum += i;
			if (sum > target) {
				return true;
			}
			
			if (!canWin(n, visited, sum, target)) {
				result = true;
			}
			
			visited[i] = false;
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
