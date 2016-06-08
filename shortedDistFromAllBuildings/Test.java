package shortedDistFromAllBuildings;

public class Test {

	public static void main(String[] args) {
		//test case
		int[][] matrix = new int[][] {
			{1, 0, 2, 0, 1},
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0}
		};
		
		Solution s = new Solution();
		System.out.println(s.shortestDistFromAllBuildings(matrix));
		
	}

}
