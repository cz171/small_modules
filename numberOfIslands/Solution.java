package numberOfIslands;

public class Solution {
	static int[] dx = new int[] { -1, 0, 0, 1};
	static int[] dy = new int[] {0, 1, -1, 0};
	
	public static int numOfIslands(int[][] matrix) {
		int cnt = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(matrix, i, j, visited);
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for (int dir = 0; dir < 4; dir++) {
			int row = i + dx[dir];
			int col = j + dy[dir];
			if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length &&
					matrix[row][col] == 1 && !visited[row][col]) {
				dfs(matrix, row, col, visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		int[][] matrix = new int[][] {
			{1, 1, 1, 1, 0},
			{1, 1, 0, 1, 0},
			{1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0}
		};
		
		System.out.println(numOfIslands(matrix));
		
		
	}

}
