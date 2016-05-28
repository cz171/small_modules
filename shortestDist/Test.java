package shortestDist;

public class Test {
	public static void main(String[] args) {
		//test case
		int[][] matrix = {
				{1, 1, 1},
				{0, 1, 1}, 
				{2, 0, 1}
		};
		Solution s = new Solution();
		System.out.println(s.shortestDist(matrix));
	}
}
